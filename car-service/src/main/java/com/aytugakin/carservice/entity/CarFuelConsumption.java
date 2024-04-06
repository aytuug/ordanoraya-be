package com.aytugakin.carservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "car_fuel_consumption")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarFuelConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String distance;
    private String fuelConsumption;
    private FuelType fuelType;
}
