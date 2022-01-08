package com.furkanyesilyurt.springbootex.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AddressDto {

    private final Long id;
    private final String address;
    private final String district;
    private final Long postalCode;
    private final String phoneNumber;
    private final Date lastUpdate;

}
