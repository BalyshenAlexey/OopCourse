package ru.academits.balyshen.temperature.controller;

import ru.academits.balyshen.temperature.model.scales.TemperatureScale;
import ru.academits.balyshen.temperature.view.View;

public interface Controller {
    void setView(View view);

    TemperatureScale[] getScales();

    void convertTemperature(double initialTemperature, TemperatureScale initialScale, TemperatureScale resultingScale);
}
