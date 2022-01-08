package com.furkanyesilyurt.springbootex.dto;

import com.furkanyesilyurt.springbootex.entity.Address;
import com.furkanyesilyurt.springbootex.entity.Store;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerDto {

    private final Long id;
    private final Store storeId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address addressId;
    private final Boolean isActive;
    private final Date createDate;
    private final Date lastUpdate;
    private final Long active;

}
