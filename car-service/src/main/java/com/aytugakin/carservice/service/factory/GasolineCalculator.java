package com.aytugakin.carservice.service.factory;

import com.aytugakin.carservice.entity.Fuel;

public class GasolineCalculator implements FuelCalculator{
    @Override
    public Double calculatePrice(Fuel fuel, double distance) {
        return fuel.getGasolinePrice() * distance;
    }
}
