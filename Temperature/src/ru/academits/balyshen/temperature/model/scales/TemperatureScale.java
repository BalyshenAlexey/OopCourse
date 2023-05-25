package ru.academits.balyshen.temperature.model.scales;

public interface TemperatureScale {
    double convertToCelsius(double temperature);

    double convertFromCelsius(double celsiusTemperature);
}
