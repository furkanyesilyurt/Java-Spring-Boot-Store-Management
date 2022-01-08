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
@Table(name = "store")
public class Store implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "STORE_ID_SEQ")
    @GeneratedValue(generator = "generator")
    @Column(name = "store_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id", foreignKey = @ForeignKey(name = "store_manager_id_fkey"))
    private Staff staffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "store_address_id_fkey"))
    private Address addressId;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", staffId=" + staffId +
                ", addressId=" + addressId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
