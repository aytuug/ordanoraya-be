package com.aytugakin.carservice.repository;

import com.aytugakin.carservice.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long> {
    Optional<Fuel> findByCityCodeAndCountyCode(String cityCode, String countyCode);
}
