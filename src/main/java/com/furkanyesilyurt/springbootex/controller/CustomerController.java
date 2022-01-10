package com.furkanyesilyurt.springbootex.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.furkanyesilyurt.springbootex.dto.Customer.CustomerDto;
import com.furkanyesilyurt.springbootex.dto.Customer.CustomerRegisterDto;
import com.furkanyesilyurt.springbootex.entity.Customer;
import com.furkanyesilyurt.springbootex.service.entityService.CustomerEntityService;
import lombok.RequiredArgsConstructor;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.webjars.NotFoundException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    public final CustomerEntityService customerEntityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public MappingJacksonValue findAll(){
        List<Customer> customers = customerEntityService.findAll();

        String filterName = "CustomerFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        MappingJacksonValue mapping = new MappingJacksonValue(customers);

        mapping.setFilters(filters);

        return mapping;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id){
        var customerDto = customerEntityService.findById(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CustomerRegisterDto> save(@RequestBody CustomerRegisterDto customerRegisterDto){
        var respCustomerDto = customerEntityService.save(customerRegisterDto);
        return new ResponseEntity<>(respCustomerDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        customerEntityService.deleteById(id);
    }

    private SimpleFilterProvider getProductFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getProductFilter();

        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getProductFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id","firstName","lastName","email","addressId","active");
    }

}
