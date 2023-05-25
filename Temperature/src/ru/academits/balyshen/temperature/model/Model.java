package ru.academits.balyshen.temperature.model;

import ru.academits.balyshen.temperature.model.scales.TemperatureScale;

public interface Model {
    TemperatureScale[] getScales();

    double convertTemperature(double initialTemperature, TemperatureScale initialScale, TemperatureScale resultingScale);
}
