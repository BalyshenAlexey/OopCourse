package ru.academits.balyshen.temperature.model;

public class TemperatureModel {
    private final static double ABSOLUTE_ZERO_IN_CELSIUS = -273.15;
    private final static double ABSOLUTE_ZERO_IN_KELVIN = 0;
    private final static double ABSOLUTE_ZERO_IN_FAHRENHEIT = -459.67;


    public double convertCelsiusToKelvin(double celsiusTemperature) {
        if (celsiusTemperature <= ABSOLUTE_ZERO_IN_CELSIUS) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_CELSIUS + "). Текущее значение: " + celsiusTemperature);
        }

        return celsiusTemperature + 273.15;
    }

    public double convertCelsiusToFahrenheit(double celsiusTemperature) {
        if (celsiusTemperature <= ABSOLUTE_ZERO_IN_CELSIUS) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_CELSIUS + "). Текущее значение: " + celsiusTemperature);
        }

        return celsiusTemperature * 1.8 + 32;
    }

    public double returnCelsiusTemperature(double celsiusTemperature) {
        if (celsiusTemperature <= ABSOLUTE_ZERO_IN_CELSIUS) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_CELSIUS + "). Текущее значение: " + celsiusTemperature);
        }

        return celsiusTemperature;
    }

    public double convertKelvinToCelsius(double kelvinTemperature) {
        if (kelvinTemperature <= ABSOLUTE_ZERO_IN_KELVIN) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_KELVIN + "). Текущее значение: " + kelvinTemperature);
        }

        return kelvinTemperature - 273.15;
    }

    public double convertKelvinToFahrenheit(double kelvinTemperature) {
        if (kelvinTemperature <= ABSOLUTE_ZERO_IN_KELVIN) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_KELVIN + "). Текущее значение: " + kelvinTemperature);
        }

        return kelvinTemperature * 1.8 - 459.67;
    }

    public double returnKelvinTemperature(double kelvinTemperature) {
        if (kelvinTemperature <= ABSOLUTE_ZERO_IN_KELVIN) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_KELVIN + "). Текущее значение: " + kelvinTemperature);
        }

        return kelvinTemperature;
    }

    public double convertFahrenheitToCelsius(double fahrenheitTemperature) {
        if (fahrenheitTemperature <= ABSOLUTE_ZERO_IN_FAHRENHEIT) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_FAHRENHEIT + "). Текущее значение: " + fahrenheitTemperature);
        }

        return (fahrenheitTemperature - 32) / 1.8;
    }

    public double convertFahrenheitToKelvin(double fahrenheitTemperature) {
        if (fahrenheitTemperature <= ABSOLUTE_ZERO_IN_FAHRENHEIT) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_FAHRENHEIT + "). Текущее значение: " + fahrenheitTemperature);
        }

        return (fahrenheitTemperature + 459.67) / 1.8;
    }

    public double returnFahrenheitTemperature(double fahrenheitTemperature) {
        if (fahrenheitTemperature <= ABSOLUTE_ZERO_IN_FAHRENHEIT) {
            throw new IllegalArgumentException("Температура должна быть больше или равна абсолютного нуля (" +
                    ABSOLUTE_ZERO_IN_FAHRENHEIT + "). Текущее значение: " + fahrenheitTemperature);
        }

        return fahrenheitTemperature;
    }
}
