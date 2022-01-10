package com.furkanyesilyurt.springbootex.dao;

import com.furkanyesilyurt.springbootex.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressDao extends JpaRepository<Address, Long> {

    Address findByPostalCode(String postalCode);
    void deleteByPostalCode(String postalCode);
}
