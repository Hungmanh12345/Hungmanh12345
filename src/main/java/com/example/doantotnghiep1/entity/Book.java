package com.example.doantotnghiep1.entity;


import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
@Where(clause = "is_delete=0")
public class Book extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "information")
    private String information;

    @Column(name = "action")
    private String action;

    public Book phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Book bookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public Book quantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public Book information(String information) {
        this.information = information;
        return this;
    }
    public Book date(String date) {
        this.date = date;
        return this;
    }

    public Book time(String time) {
        this.time = time;
        return this;
    }

    public Book action(String action) {
        this.action = action;
        return this;
    }
}