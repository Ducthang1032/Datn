package com.poly.datn.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name",  nullable = false, length = 50)
    private String brandName;

    @Column(name = "brand_desc", nullable = false, length = 500)
    private String brandDesc;

    @Column(name = "brand_status", nullable = false)
    private Integer brandStatus;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;
}
