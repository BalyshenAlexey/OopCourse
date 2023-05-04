package ru.academits.balyshen.temperature.model;

public class TemperatureModel implements Model {
    private final static double ABSOLUTE_ZERO_IN_CELSIUS = -273.15;
    private final static double ABSOLUTE_ZERO_IN_KELVIN = 0;
    private final static double ABSOLUTE_ZERO_IN_FAHRENHEIT = -459.67;

    public final String[] scales = {"Цельсия", "Кельвина", "Фаренгейта"};

    public String[] getScales() {
        return scales;
    }

    public double convertTemperature(double initialTemperature, String initialScale, String resultingScale) {
        double epsilon = 1.0e-10;
        double celsiusTemperature = initialTemperature;

        if (initialScale.equals("Кельвина")) {
            if (initialTemperature + epsilon <= ABSOLUTE_ZERO_IN_KELVIN) {
                throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                        ABSOLUTE_ZERO_IN_KELVIN + "). Текущее значение: " + initialTemperature);
            }

            celsiusTemperature = initialTemperature - 273.15;
        } else if (initialScale.equals("Фаренгейта")) {
            if (initialTemperature + epsilon <= ABSOLUTE_ZERO_IN_FAHRENHEIT) {
                throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                        ABSOLUTE_ZERO_IN_FAHRENHEIT + "). Текущее значение: " + initialTemperature);
            }

            celsiusTemperature = (initialTemperature - 32) / 1.8;
        }

        if (initialTemperature + epsilon <= ABSOLUTE_ZERO_IN_CELSIUS) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_CELSIUS + "). Текущее значение: " + initialTemperature);
        }

        if (resultingScale.equals("Кельвина")) {
            return celsiusTemperature + 273.15;
        } else if (resultingScale.equals("Фаренгейта")) {
            return celsiusTemperature * 1.8 + 32;
        }

        return celsiusTemperature;
    }
}
