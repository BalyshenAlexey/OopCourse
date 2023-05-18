package ru.academits.balyshen.temperature.scales;

public class CelsiusScale implements TemperatureScale {
    private final static double ABSOLUTE_ZERO_IN_CELSIUS = -273.15;
    private final static double EPSILON = 1.0e-10;

    @Override
    public double convertToCelsius(double temperature) {
        if (temperature + EPSILON <= ABSOLUTE_ZERO_IN_CELSIUS) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_CELSIUS + "). Текущее значение: " + temperature);
        }

        return temperature;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return celsiusTemperature;
    }

    @Override
    public String toString() {
        return "Цельсия";
    }
}
