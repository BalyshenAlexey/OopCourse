package ru.academits.balyshen.temperature.controller;

import ru.academits.balyshen.temperature.model.Model;
import ru.academits.balyshen.temperature.view.View;

public class TemperatureController implements Controller{
    private final Model model;

    private View view;

    public TemperatureController(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String[] getScales() {
        return model.getScales();
    }

    public void convertTemperature(double initialTemperature, String initialScale, String resultingScale) {
        try {
            double resultingTemperature = model.convertTemperature(initialTemperature, initialScale, resultingScale);
            view.updateTemperature(resultingTemperature);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}
