package com.furkanyesilyurt.springbootex.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "generator")
    @Column(name = "address_id", nullable = false)
    private Long id;

    @Column(name = "adress")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "postal_code")
    private Long postalCode;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", postalCode=" + postalCode +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

}
