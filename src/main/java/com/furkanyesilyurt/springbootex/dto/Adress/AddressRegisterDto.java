package com.furkanyesilyurt.springbootex.dto.Adress;

import lombok.Data;

@Data
public class AddressRegisterDto {

    private String address;
    private String district;
    private String postalCode;
    private String phoneNumber;

}
