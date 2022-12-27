package com.example.miniprojectsoa.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table

public class Product implements Serializable {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_sequence")
    private Long id;
    private String name;
    private String category;
    private Long quantity;
    private Float price;

    public Product(String name, String category, Long quantity, Float price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }
}
