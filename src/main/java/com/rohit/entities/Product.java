package com.rohit.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private long price;
    private long quantity;
}
