package ru.academits.balyshen.temperature.controller;

import ru.academits.balyshen.temperature.model.TemperatureModel;
import ru.academits.balyshen.temperature.view.View;

public class Controller {
    private final TemperatureModel temperatureModel;

    private View view;

    public Controller(TemperatureModel temperatureModel) {
        this.temperatureModel = temperatureModel;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void convertCelsiusToKelvin(double celsiusTemperature) {
        try {
            double kelvinTemperature = temperatureModel.convertCelsiusToKelvin(celsiusTemperature);
            view.updateTemperature(kelvinTemperature);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void convertCelsiusToFahrenheit(double celsiusTemperature) {
        try {
            double fahrenheitTemperature = temperatureModel.convertCelsiusToFahrenheit(celsiusTemperature);
            view.updateTemperature(fahrenheitTemperature);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void returnCelsiusTemperature(double celsiusTemperature) {
        try {
            view.updateTemperature(temperatureModel.returnCelsiusTemperature(celsiusTemperature));
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void convertKelvinToCelsius(double kelvinTemperature) {
        try {
            double celsiusTemperature = temperatureModel.convertKelvinToCelsius(kelvinTemperature);
            view.updateTemperature(celsiusTemperature);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void convertKelvinToFahrenheit(double kelvinTemperature) {
        try {
            double fahrenheitTemperature = temperatureModel.convertKelvinToFahrenheit(kelvinTemperature);
            view.updateTemperature(fahrenheitTemperature);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void returnKelvinTemperature(double kelvinTemperature) {
        try {
            view.updateTemperature(temperatureModel.returnKelvinTemperature(kelvinTemperature));
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void convertFahrenheitToCelsius(double fahrenheitTemperature) {
        try {
            double celsiusTemperature = temperatureModel.convertFahrenheitToCelsius(fahrenheitTemperature);
            view.updateTemperature(celsiusTemperature);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void convertFahrenheitToKelvin(double fahrenheitTemperature) {
        try {
            double kelvinTemperature = temperatureModel.convertFahrenheitToKelvin(fahrenheitTemperature);
            view.updateTemperature(kelvinTemperature);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    public void returnFahrenheitTemperature(double fahrenheitTemperature) {
        try {
            view.updateTemperature(temperatureModel.returnFahrenheitTemperature(fahrenheitTemperature));
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}
