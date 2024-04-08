package com.aytugakin.carservice.service.factory;

import com.aytugakin.carservice.entity.FuelType;
import org.springframework.stereotype.Component;

@Component
public class FuelCalculatorFactory {
    public FuelCalculator createCalculator(FuelType fuelType) {
        return switch (fuelType) {
            case BENZIN -> new GasolineCalculator();
            case MAZOT -> new DieselCalculator();
            case GAZ -> new LpgCalculator();
        };
    }
}
