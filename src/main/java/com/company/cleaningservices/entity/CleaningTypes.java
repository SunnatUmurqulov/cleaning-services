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
@Table(name = "cleaning_types")
public class CleaningTypes extends BaseEntity {
    @Column(nullable = false,unique = true)
    private String name;
}
