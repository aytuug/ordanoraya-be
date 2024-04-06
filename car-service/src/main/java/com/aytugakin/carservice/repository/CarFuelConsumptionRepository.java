package com.aytugakin.carservice.repository;

import com.aytugakin.carservice.entity.CarFuelConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarFuelConsumptionRepository extends JpaRepository<CarFuelConsumption, Long> {
}
