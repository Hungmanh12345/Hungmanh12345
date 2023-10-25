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
 * A Menu.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
@Where(clause = "is_delete=0")
public class Menu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "images")
    private String images;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;


    public Menu type(String type) {
        this.type = type;
        return this;
    }

    public Menu images(String images) {
        this.images = images;
        return this;
    }

    public Menu description(String description) {
        this.description = description;
        return this;
    }

    public Menu price(String price) {
        this.price = price;
        return this;
    }

    public Menu name(String name) {
        this.name = name;
        return this;
    }
}
