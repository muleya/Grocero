package com.grocero.services.impl;

import com.grocero.beans.CustomerBean;
import com.grocero.beans.MasterListBean;
import com.grocero.dtos.CustomerDto;
import com.grocero.dtos.MasterListDto;
import com.grocero.exceptions.NoDataFoundException;
import com.grocero.repositories.CustomerRepository;
import com.grocero.repositories.MasterListRepository;
import com.grocero.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService extends GroceroService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MasterListRepository masterListRepository;

    public void save(CustomerDto customerDto) {
        CustomerBean customerBean = customerRepository.save(dtoToBeanMapper.map(customerDto));
        customerDto.setId(customerBean.getId());
    }

    public Set<CustomerDto> getAll() throws NoDataFoundException {
        List<CustomerBean> customers = customerRepository.findAll();
        if (CollectionUtils.isEmpty(customers)) {
            throw new NoDataFoundException("No customers found");
        }
        return customers.stream().map(beanToDtoMapper::map).collect(Collectors.toSet());
    }

    public void save(MasterListDto masterListDto) {
        MasterListBean masterListBean = masterListRepository.save(dtoToBeanMapper.map(masterListDto));
        masterListDto.setId(masterListBean.getId());
    }

    @Override
    public Set<MasterListDto> getMasterLists(String customerId) throws NoDataFoundException {
        List<MasterListBean> masterLists = masterListRepository.findByCustomerId(customerId);
        if (CollectionUtils.isEmpty(masterLists)) {
            throw new NoDataFoundException("No master lists found");
        }
        return masterLists.stream().map(beanToDtoMapper::map).collect(Collectors.toSet());
    }
}
