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
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Where(clause = "is_delete=0")
public class User extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private String age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birth")
    private String birth;

    @Column(name = "address")
    private String address;



    public User fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public User age(String age) {
        this.age = age;
        return this;
    }

    public User phone(String phone) {
        this.phone = phone;
        return this;
    }

    public User sex(String sex) {
        this.sex = sex;
        return this;
    }

    public User birth(String birth) {
        this.birth = birth;
        return this;
    }

    public User address(String address) {
        this.address = address;
        return this;
    }
}
