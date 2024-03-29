package com.company.cleaningservices.entity;

import com.company.cleaningservices.entity.template.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "services_category")
@Builder
public class ServicesCategory extends BaseEntity {
    @Column(nullable = false,unique = true)
    private String categoryName;
}
