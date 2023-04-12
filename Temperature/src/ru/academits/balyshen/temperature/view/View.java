package ru.academits.balyshen.temperature.view;

public interface View {
    void start();

    void updateTemperature(double temperature);

    void showError(String message);
}
