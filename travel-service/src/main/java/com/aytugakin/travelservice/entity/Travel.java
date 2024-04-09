package com.aytugakin.travelservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "travel")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originCity;
    private String originCityCode;
    private String originCounty;
    private String originCountyCode;
    private String destination;
    private String destinationCode;
    private Double distance;
    private Double carConsumption;
}
