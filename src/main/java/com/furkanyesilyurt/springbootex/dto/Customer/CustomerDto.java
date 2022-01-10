package com.furkanyesilyurt.springbootex.dto.Customer;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDto {

    private final Long id;
    private final Long storeId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Long addressId;
    private final Boolean isActive;
    private final Date createDate;
    private final Date lastUpdate;
    private final Long active;

}
