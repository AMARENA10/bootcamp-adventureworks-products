package com.adventureworks.products.persistence.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product", schema = "SalesLT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "ListPrice")
    private Double price;
    @Column(name = "Color")
    private String color;
    @Column(name = "Size")
    private String size;
    @Column(name = "Weight")
    private Double weight;
    @Column(name = "ProductNumber")
    private String productNumber;
    @Column(name = "StandardCost")
    private Double standardCost;
    @Column(name = "SellStartDate")
    private Date sellStartDate;
    @Column(name = "rowguid" , columnDefinition="uniqueidentifier")
    private String rowguid;
    @Column(name = "ModifiedDate")
    private Date modifiedDate;
    @Column(name="ProductCategoryID")
    private Integer categoryId;

//    public Product() {
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", color='" + color + '\'' +
//                ", size='" + size + '\'' +
//                ", weight=" + weight +
//                ", productNumber='" + productNumber + '\'' +
//                ", standardCost=" + standardCost +
//                ", sellStartDate=" + sellStartDate +
//                ", rowguid='" + rowguid + '\'' +
//                ", modifiedDate=" + modifiedDate +
//                '}';
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//    public Double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(Double weight) {
//        this.weight = weight;
//    }
//
//    public String getProductNumber() {
//        return productNumber;
//    }
//
//    public void setProductNumber(String productNumber) {
//        this.productNumber = productNumber;
//    }
//
//    public Double getStandardCost() {
//        return standardCost;
//    }
//
//    public void setStandardCost(Double standardCost) {
//        this.standardCost = standardCost;
//    }
//
//    public Date getSellStartDate() {
//        return sellStartDate;
//    }
//
//    public void setSellStartDate(Date sellStartDate) {
//        this.sellStartDate = sellStartDate;
//    }
//
//    public String getRowguid() {
//        return rowguid;
//    }
//
//    public void setRowguid(String rowguid) {
//        this.rowguid = rowguid;
//    }
//
//    public Date getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(Date modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }
}
