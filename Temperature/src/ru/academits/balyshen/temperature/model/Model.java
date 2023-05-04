package ru.academits.balyshen.temperature.model;

public interface Model {
    String[] getScales();

    double convertTemperature(double initialTemperature, String initialScale, String resultingScale);
}
