package com.example.doantotnghiep1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_date")
    protected Date createdDate;

    @CreatedBy
    @Column(name = "created_by")
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "updated_date")
    protected Date updatedDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected String updatedBy;
    @Column(name = "is_delete")
    protected Long isDeleted;
    @Column(name = "version")
    protected Long version;

    @PrePersist
    public void prePersist() {
        this.version = 1L;
        this.isDeleted = 0L;
        this.createdBy = "admin";
        this.updatedBy = "admin";
    }

    @PreUpdate
    public void preUpdate() {
        this.version =this.getVersion() + 1;
    }


    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnore
    public BaseEntity copyBaseEntity(BaseEntity other) {
        setCreatedBy(other.getCreatedBy());
        setCreatedDate(other.getCreatedDate());
        setUpdatedBy(other.getUpdatedBy());
        setUpdatedDate(other.getUpdatedDate());
        setVersion(other.getVersion());
        setIsDeleted(other.getIsDeleted());
        return this;
    }

}
