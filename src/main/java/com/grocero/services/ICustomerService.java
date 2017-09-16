package com.grocero.services;

import com.grocero.dtos.CustomerDto;
import com.grocero.dtos.MasterListDto;
import com.grocero.exceptions.NoDataFoundException;

import java.util.Set;

public interface ICustomerService {

    void save(CustomerDto customerDto);

    Set<CustomerDto> getAll() throws NoDataFoundException;

    void save(MasterListDto masterList);
}