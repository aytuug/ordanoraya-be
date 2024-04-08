package com.aytugakin.carservice.service;

import com.aytugakin.carservice.controller.dto.AddFuelRequest;
import com.aytugakin.carservice.controller.dto.TravelCarConsumptionRequest;
import com.aytugakin.carservice.controller.dto.TravelCarConsumptionResponse;
import com.aytugakin.carservice.entity.Fuel;
import com.aytugakin.carservice.exception.ResourceNotFoundException;
import com.aytugakin.carservice.mapper.FuelMapper;
import com.aytugakin.carservice.repository.FuelRepository;
import com.aytugakin.carservice.service.dto.FuelDto;
import com.aytugakin.carservice.service.factory.FuelCalculator;
import com.aytugakin.carservice.service.factory.FuelCalculatorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarFuelConsumptionService {

    private final FuelRepository fuelRepository;
    private final FuelMapper fuelMapper;
    private final FuelCalculatorFactory fuelCalculatorFactory;

    public String scrapingFuelData(AddFuelRequest addFuelRequest) {
        List<Fuel> updatedFuelList = new ArrayList<>();

        for (FuelDto fuelDto : addFuelRequest.fuelDtoList()) {

            Optional<Fuel> optionalFuel = fuelRepository.findByCityAndCounty(
                    fuelDto.city(), fuelDto.county());

            if (optionalFuel.isPresent()) {
                Fuel existingFuelData = optionalFuel.get();
                existingFuelData.setGasolinePrice(fuelDto.gasolinePrice());
                existingFuelData.setDieselPrice(fuelDto.dieselPrice());
                existingFuelData.setLpgPrice(fuelDto.lpgPrice());
                updatedFuelList.add(fuelRepository.save(existingFuelData));
            } else {
                Fuel newFuelData = Fuel.builder()
                        .city(fuelDto.city())
                        .county(fuelDto.county())
                        .gasolinePrice(fuelDto.gasolinePrice())
                        .dieselPrice(fuelDto.dieselPrice())
                        .lpgPrice(fuelDto.lpgPrice())
                        .build();
                updatedFuelList.add(fuelRepository.save(newFuelData));
            }
        }

        List<FuelDto> updatedFuelDtos = fuelMapper.convertToDto(updatedFuelList);
        return String.format("Güncellenen Fuel Data sayısı: %d", updatedFuelDtos.size());
    }

    public TravelCarConsumptionResponse getCalculateCarConsumption(TravelCarConsumptionRequest travelCarConsumptionRequest) {
        Optional<Fuel> fuel = fuelRepository.findByCityAndCounty(travelCarConsumptionRequest.city(), travelCarConsumptionRequest.county());
        Double price = null;
        if (fuel.isPresent()) {
            if (Objects.nonNull(travelCarConsumptionRequest.fuelType())) {
                FuelCalculator calculator = fuelCalculatorFactory.createCalculator(travelCarConsumptionRequest.fuelType());
                price = calculator.calculatePrice(fuel.get(), travelCarConsumptionRequest.distance());
            } else {
                throw new ResourceNotFoundException("Invalid fuel type");
            }
            return TravelCarConsumptionResponse.builder().price(price).build();
        } else {
            throw new ResourceNotFoundException("Invalid City Or County");
        }
    }
}
