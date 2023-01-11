package com.backend.sanchit.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productType")
    private String productType;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productPrice")
    private double productPrice;

    @Column(name = "productImage")
    private String productImage;
}
