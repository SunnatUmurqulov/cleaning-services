package com.company.cleaningservices.payload;

import lombok.Data;

@Data
public class OrderDTO {
    private Integer userId;
    private Integer servicesId;
    private Integer subServicesId;
}
