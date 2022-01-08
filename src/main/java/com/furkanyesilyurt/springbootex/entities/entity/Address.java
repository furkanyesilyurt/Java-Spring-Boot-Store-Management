package com.furkanyesilyurt.springbootex.entities.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

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
