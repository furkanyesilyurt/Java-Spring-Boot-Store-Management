package com.furkanyesilyurt.springbootex.dto.Customer;

import lombok.Data;

@Data
public class CustomerRegisterDto {

    private String firstName;
    private String lastName;
    private String email;
    private Long active;

}
