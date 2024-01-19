package com.company.cleaningservices.payload;

import lombok.Data;

@Data
public class SubServiceDTO {
    private String name;
    private Integer services_Id;
    private Integer cleaningTypes_Id;
    private String description;
    private Integer attachment_id;
}
