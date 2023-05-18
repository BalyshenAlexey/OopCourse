package ru.academits.balyshen.temperature.model;

import ru.academits.balyshen.temperature.scales.TemperatureScale;

public class TemperatureModel implements Model {
    public TemperatureScale[] scales;

    public TemperatureModel(TemperatureScale[] scales) {
        this.scales = scales;
    }

    public TemperatureScale[] getScales() {
        return scales;
    }

    public double convertTemperature(double initialTemperature, TemperatureScale initialScale, TemperatureScale resultingScale) {
        return resultingScale.convertFromCelsius(initialScale.convertToCelsius(initialTemperature));
    }
}
