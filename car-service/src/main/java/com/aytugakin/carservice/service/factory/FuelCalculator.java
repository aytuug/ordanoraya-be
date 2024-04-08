package com.aytugakin.carservice.service.factory;

import com.aytugakin.carservice.entity.Fuel;

public interface FuelCalculator {
    Double calculatePrice(Fuel fuel, double distance, double carConsumption);
}
