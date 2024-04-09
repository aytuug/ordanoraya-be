package com.aytugakin.busservice.repository;


import com.aytugakin.busservice.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
    Optional<Bus> findByCompanyAndDestinationCodeAndOriginCode (String company, String destinationCode, String originCode);
    Bus findFirstByDestinationCodeAndOriginCodeOrderByPriceAsc (String destinationCode, String originCode);
}
