package com.aytugakin.carservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "fuel")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String county;
    private Double gasolinePrice;
    private Double dieselPrice;
    private Double lpgPrice;
}
