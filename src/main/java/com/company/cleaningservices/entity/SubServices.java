package com.company.cleaningservices.entity;

import com.company.cleaningservices.entity.template.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sub_services")
@Builder
public class SubServices extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Services services_Id;
    @ManyToOne
    private CleaningTypes cleaningTypes_Id;
    private String description;
    @OneToOne
    private Attachment attachment;
}
