package com.furkanyesilyurt.springbootex.dto;

import com.furkanyesilyurt.springbootex.entity.Address;
import com.furkanyesilyurt.springbootex.entity.Store;
import lombok.Data;

import java.util.Date;

@Data
public class StaffDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Address addressId;
    private final String email;
    private final Store storeId;
    private final String userName;
    private final String password;
    private final Date lastUpdate;

}
