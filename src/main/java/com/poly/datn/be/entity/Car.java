package com.poly.datn.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "tbl_car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_name", nullable = false, length = 50)
    private String carName;

    @Column(name = "car_desc", nullable = false, unique = true, length = 500)
    private String carDesc;

    @Column(name = "brand_id", nullable = false, length = 11)
    private Integer brandId;

    @Column(name = "category_id", nullable = false, length = 11)
    private Integer categoryId;

    @Column(name = "car_price", nullable = false, length = 50)
    private String carPrice;

    @Column(name = "car_img", nullable = false, length = 50)
    private String carImage;

    @Column(name = "car_status", nullable = false, length = 11)
    private Integer carStatus;

    @Column(name = "created_at", nullable = false, length = 11)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false, length = 11)
    private Long updatedAt;
}
