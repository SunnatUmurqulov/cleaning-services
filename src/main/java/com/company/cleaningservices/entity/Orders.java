package com.company.cleaningservices.entity;

import com.company.cleaningservices.entity.template.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {
    @ManyToOne
    private User userId;
    @ManyToOne
    private Services servicesId;
    @ManyToOne
    private SubServices subServicesId;
    @CreationTimestamp
    private Timestamp orderDate;
    private boolean isCompleted;
}
