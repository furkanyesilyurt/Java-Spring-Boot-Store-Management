package com.furkanyesilyurt.springbootex.dto.Staff;

import com.furkanyesilyurt.springbootex.entity.Address;
import lombok.Data;

import java.util.Date;

@Data
public class StaffDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private Long storeId;
    private String userName;
    private String password;
    private Date lastUpdate;
}
