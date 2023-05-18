package ru.academits.balyshen.temperature.scales;

public class KelvinScale implements TemperatureScale {
    private final static double ABSOLUTE_ZERO_IN_KELVIN = 0;
    private final static double EPSILON = 1.0e-10;

    @Override
    public double convertToCelsius(double temperature) {
        if (temperature + EPSILON <= ABSOLUTE_ZERO_IN_KELVIN) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_KELVIN + "). Текущее значение: " + temperature);
        }

        return temperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }

    @Override
    public String toString() {
        return "Кельвина";
    }
}
