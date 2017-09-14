package com.grocero.services;

import com.grocero.beans.CustomerBean;
import com.grocero.beans.CustomerBeanBuilder;
import com.grocero.beans.MasterListBean;
import com.grocero.common.DtoToBeanMapper;
import com.grocero.dtos.CustomerDto;
import com.grocero.dtos.MasterListDto;
import com.grocero.repositories.MasterListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyingService {

    @Autowired
    private MasterListRepository masterListRepository;

    @Autowired
    private DtoToBeanMapper dtoToBeanMapper;

    public void save(MasterListDto masterListDto) {
        MasterListBean masterListBean = masterListRepository.save(dtoToBeanMapper.map(masterListDto));
        masterListDto.setId(masterListBean.getId());
    }

    public void save(CustomerDto customerDto) {

    }

}
