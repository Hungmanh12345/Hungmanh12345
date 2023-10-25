package com.example.doantotnghiep1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@jakarta.persistence.Table(name = "ban")
@Where(clause = "is_delete=0")
public class Table extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "action")
    private String action;

    @Column(name = "number_seats")
    private String numberSeats;

    public Table code(String code) {
        this.code = code;
        return this;
    }

    public Table type(String type) {
        this.type = type;
        return this;
    }

    public Table action(String action) {
        this.action = action;
        return this;
    }


    public Table numberSeats(String numberSeats) {
        this.numberSeats = numberSeats;
        return this;
    }
}
