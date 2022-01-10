package com.furkanyesilyurt.springbootex.dao;

import com.furkanyesilyurt.springbootex.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStaffDao extends JpaRepository<Staff, Long> {
}
