package ru.academits.balyshen.temperature.scales;

public class FahrenheitScale implements TemperatureScale {
    private final static double ABSOLUTE_ZERO_IN_FAHRENHEIT = -459.67;
    private final static double EPSILON = 1.0e-10;

    @Override
    public double convertToCelsius(double temperature) {
        if (temperature + EPSILON <= ABSOLUTE_ZERO_IN_FAHRENHEIT) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_FAHRENHEIT + "). Текущее значение: " + temperature);
        }

        return (temperature - 32) / 1.8;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return celsiusTemperature * 1.8 + 32;
    }

    @Override
    public String toString() {
        return "Фаренгейта";
    }
}
