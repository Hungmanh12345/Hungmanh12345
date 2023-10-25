package com.example.doantotnghiep1.entity;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import java.io.Serializable;

/**
 * A Customer.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Where(clause = "is_delete=0")
public class Customer extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "action")
    private String action;

    @Column(name = "number_table")
    private String numberTable;

    @Column(name = "total")
    private int total;


    public Customer name(String name) {
        this.name = name;
        return this;
    }
    public Customer phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Customer action(String action) {
        this.action = action;
        return this;
    }

    public Customer id(String id) {
        this.id = id;
        return this;
    }

    public Customer numberTable(String numberTable) {
        this.numberTable = numberTable;
        return this;
    }

    public Customer total(int total) {
        this.total = total;
        return this;
    }
}
