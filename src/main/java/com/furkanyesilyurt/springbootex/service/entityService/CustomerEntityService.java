package com.furkanyesilyurt.springbootex.service.entityService;

import com.furkanyesilyurt.springbootex.converter.CustomerConverter;
import com.furkanyesilyurt.springbootex.dao.ICustomerDao;
import com.furkanyesilyurt.springbootex.dto.Customer.CustomerDto;
import com.furkanyesilyurt.springbootex.dto.Customer.CustomerRegisterDto;
import com.furkanyesilyurt.springbootex.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerEntityService {

    private final ICustomerDao customerDao;

    public List<Customer> findAll(){
        return customerDao.findAll();
    }

    public CustomerDto findById(Long id){
        Optional<Customer> optionalCustomer = customerDao.findById(id);
        Customer customer = null;
        if (optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
        }
        return CustomerConverter.INSTANCE.convertCustomerToCustomerDto(customer);
    }

    public CustomerRegisterDto save(CustomerRegisterDto customerRegisterDto){
        var customer = CustomerConverter.INSTANCE.convertCustomerRegisterDtoToCustomer(customerRegisterDto);
        customer = customerDao.save(customer);
        customerRegisterDto = CustomerConverter.INSTANCE.convertCustomerToCustomerRegisterDto(customer);
        return customerRegisterDto;
    }

    public void deleteById(Long id){
        customerDao.deleteById(id);
    }
}
