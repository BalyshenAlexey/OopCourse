package ru.academits.balyshen.temperature.scales;

public interface TemperatureScale {
    double convertToCelsius(double temperature);

    double convertFromCelsius(double celsiusTemperature);
}
