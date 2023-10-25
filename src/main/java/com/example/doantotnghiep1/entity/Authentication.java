package com.example.doantotnghiep1.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@Entity
@Data
@Table(name = "authentication")
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_delete=0")
public class Authentication extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "position")
    private String position;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;


    public Authentication fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Authentication userName(String userName) {
        this.userName = userName;
        return this;
    }

    public Authentication password(String password) {
        this.password = password;
        return this;
    }

    public Authentication email(String email) {
        this.email = email;
        return this;
    }

    public Authentication phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Authentication position(String position) {
        this.position = position;
        return this;
    }
}
