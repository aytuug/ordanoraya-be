package com.aytugakin.carservice.service.factory;

import com.aytugakin.carservice.entity.Fuel;

public class DieselCalculator implements FuelCalculator{

    @Override
    public Double calculatePrice(Fuel fuel, double distance, double carConsumption) {
        return ((carConsumption / 100) * distance) * fuel.getDieselPrice();
    }
}
