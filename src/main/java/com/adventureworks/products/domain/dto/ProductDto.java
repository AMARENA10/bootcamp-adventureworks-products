package com.adventureworks.products.domain.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private Double price;
    private String color;
    private String size;
    private Double weight;
    private String number;
    private Double standardCost;
    private Date sellStartDate;
    private String rowguid;
    private Date modifiedDate;
    private Integer categoryId;
}
