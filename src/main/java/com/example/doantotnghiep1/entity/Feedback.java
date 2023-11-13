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
public class Feedback extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name ="name")
    private String name;

    @Column(name= "phone")
    private String phone;

    @Column(name = "Content")
    private String content;


    public Feedback id(String id) {
        this.id = id;
        return this;
    }

    public Feedback name(String name) {
        this.name = name;
        return this;
    }

    public Feedback phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Feedback content(String content) {
        this.content = content;
        return this;
    }
}
