package com.furkanyesilyurt.springbootex.dao;

import com.furkanyesilyurt.springbootex.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdressDao extends JpaRepository<Address, Long> {
}
