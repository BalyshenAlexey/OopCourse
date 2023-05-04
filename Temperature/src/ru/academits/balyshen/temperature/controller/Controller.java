package ru.academits.balyshen.temperature.controller;

import ru.academits.balyshen.temperature.view.View;

public interface Controller {
    void setView(View view);

    String[] getScales();

    void convertTemperature(double initialTemperature, String initialScale, String resultingScale);
}
