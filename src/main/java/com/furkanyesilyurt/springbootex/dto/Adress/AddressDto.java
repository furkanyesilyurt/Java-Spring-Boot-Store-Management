package com.furkanyesilyurt.springbootex.dto.Adress;

import lombok.Data;

import java.util.Date;

@Data
public class AddressDto {

    private Long id;
    private String address;
    private String district;
    private String postalCode;
    private String phoneNumber;
    private Date lastUpdate;

}
