package com.aytugakin.carservice.service.factory;

import com.aytugakin.carservice.entity.Fuel;

public class DieselCalculator implements FuelCalculator{

    @Override
    public Double calculatePrice(Fuel fuel, double distance) {
        return fuel.getDieselPrice() * distance;
    }
}
