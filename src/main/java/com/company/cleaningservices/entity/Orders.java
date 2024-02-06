package com.company.cleaningservices.entity;

import com.company.cleaningservices.entity.template.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Builder
public class Orders extends BaseEntity {
    @ManyToOne
    private User userId;
    @ManyToOne
    private Services servicesId;
    @ManyToOne
    private SubServices subServicesId;
    @CreationTimestamp
    private Timestamp orderDate;
}
