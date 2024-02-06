package com.company.cleaningservices.entity;

import com.company.cleaningservices.entity.template.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "services")
@Builder
public class Services extends BaseEntity {
    @ManyToOne
    private ServicesCategory category_id;
    @Column(nullable = false, unique = true)
    private String serviceName;
    private String description;
    @OneToOne
    private Attachment attachment_id;
}
