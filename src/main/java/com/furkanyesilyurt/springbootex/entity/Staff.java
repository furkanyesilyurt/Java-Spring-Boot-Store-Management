package com.furkanyesilyurt.springbootex.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "staff")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","address"})
@JsonFilter("StaffFilter")
public class Staff implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "STAFF_ID_SEQ")
    @GeneratedValue(generator = "generator")
    @Column(name = "staff_id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "staff_address_id_fkey"))
    private Address address;

    @Column(name = "email")
    private String email;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
