package com.company.cleaningservices.entity;

import com.company.cleaningservices.entity.template.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "services")
public class Services extends BaseEntity {
    @ManyToOne
    private ServicesCategory category_id;
    @Column(nullable = false, unique = true)
    private String serviceName;
    private String description;
    @OneToOne
    private Attachment attachment_id;
}
