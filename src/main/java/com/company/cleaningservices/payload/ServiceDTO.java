package com.company.cleaningservices.payload;

import lombok.Data;

@Data
public class ServiceDTO {
    private Integer category_id;
    private String serviceName;
    private String description;
    private Integer attachment_id;
}
