package com.example.doantotnghiep1.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback")
@Where(clause = "is_delete=0")
public class Food extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "name_food")
    private String nameFood;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "price")
    private String price;

    @Column(name = "total")
    private String total;

    @Column(name = "address")
    private String address;

    @Column(name = "in4")
    private String in4;

    public Food id(String id) {
        this.id = id;
        return this;
    }

    public Food name(String name) {
        this.name = name;
        return this;
    }

    public Food phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Food quantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public Food price(String price) {
        this.price = price;
        return this;
    }

    public Food total(String total) {
        this.total = total;
        return this;
    }

    public Food address(String address) {
        this.address = address;
        return this;
    }

    public Food in4(String in4) {
        this.in4 = in4;
        return this;
    }

    public Food nameFood(String nameFood) {
        this.nameFood = nameFood;
        return this;
    }
}
