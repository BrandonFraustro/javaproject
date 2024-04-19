package com.champions.javaproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long idProduct;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "price")
    @Getter @Setter
    private float price;


}
