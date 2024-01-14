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
@Table(name = "attachment")
public class Attachment extends BaseEntity {
    private String name;
    private String contentType;
    private long size;
    private String filePath;
}
