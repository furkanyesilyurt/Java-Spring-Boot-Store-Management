package com.furkanyesilyurt.springbootex.converter;

import com.furkanyesilyurt.springbootex.dto.Customer.CustomerDto;
import com.furkanyesilyurt.springbootex.dto.Customer.CustomerRegisterDto;
import com.furkanyesilyurt.springbootex.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerConverter {

    CustomerConverter INSTANCE = Mappers.getMapper(CustomerConverter.class);

    CustomerDto convertCustomerToCustomerDto(Customer customer);
    Customer convertCustomerRegisterDtoToCustomer(CustomerRegisterDto customerRegisterDto);
    CustomerRegisterDto convertCustomerToCustomerRegisterDto(Customer customer);


}
