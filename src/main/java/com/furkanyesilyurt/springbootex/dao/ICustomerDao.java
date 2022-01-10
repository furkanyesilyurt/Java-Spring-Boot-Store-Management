package com.furkanyesilyurt.springbootex.dao;

import com.furkanyesilyurt.springbootex.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDao extends JpaRepository<Customer, Long> {
}
