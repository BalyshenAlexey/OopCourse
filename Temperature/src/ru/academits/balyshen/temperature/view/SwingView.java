package ru.academits.balyshen.temperature.view;

import ru.academits.balyshen.temperature.controller.Controller;

import javax.swing.*;

public class SwingView implements View {
    private final Controller controller;
    private JLabel resultLabel;
    private JFrame frame;
    private JComboBox<String> conversionScale;

    public SwingView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            frame = new JFrame("Конвертер температур");
            frame.setSize(400, 300);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

            JPanel referenceScalePanel = new JPanel();
            JPanel conversionScalePanel = new JPanel();
            JPanel inputPanel = new JPanel();
            JPanel resultPanel = new JPanel();

            String[] temperatureScales = {"Цельсия", "Кельвина", "Фаренгейта"};
            JComboBox<String> referenceScale = new JComboBox<>(temperatureScales);
            conversionScale = new JComboBox<>(temperatureScales);

            JTextField temperatureTextField = new JTextField(20);

            referenceScalePanel.add(new JLabel("Исходная шкала:"));
            referenceScalePanel.add(referenceScale);

            conversionScalePanel.add(new JLabel("Конвертируемая шкала:"));
            conversionScalePanel.add(conversionScale);

            inputPanel.add(new JLabel("Введите температуру:"));
            inputPanel.add(temperatureTextField);

            resultLabel = new JLabel();
            resultPanel.add(resultLabel);

            panel.add(referenceScalePanel);
            panel.add(conversionScalePanel);
            panel.add(inputPanel);

            JButton convertButton = new JButton("Конвертировать");
            convertButton.addActionListener(e -> {
                try {
                    if (referenceScale.getItemAt(referenceScale.getSelectedIndex()).equals("Цельсия")) {
                        if (conversionScale.getItemAt(conversionScale.getSelectedIndex()).equals("Кельвина")) {
                            String celsiusTemperatureText = temperatureTextField.getText();
                            double celsiusTemperature = Double.parseDouble(celsiusTemperatureText);
                            controller.convertCelsiusToKelvin(celsiusTemperature);
                        } else if (conversionScale.getItemAt(conversionScale.getSelectedIndex()).equals("Фаренгейта")) {
                            String celsiusTemperatureText = temperatureTextField.getText();
                            double celsiusTemperature = Double.parseDouble(celsiusTemperatureText);
                            controller.convertCelsiusToFahrenheit(celsiusTemperature);
                        } else {
                            String celsiusTemperatureText = temperatureTextField.getText();
                            double celsiusTemperature = Double.parseDouble(celsiusTemperatureText);
                            controller.returnCelsiusTemperature(celsiusTemperature);
                        }
                    } else if (referenceScale.getItemAt(referenceScale.getSelectedIndex()).equals("Кельвина")) {
                        if (conversionScale.getItemAt(conversionScale.getSelectedIndex()).equals("Цельсия")) {
                            String kelvinTemperatureText = temperatureTextField.getText();
                            double kelvinTemperature = Double.parseDouble(kelvinTemperatureText);
                            controller.convertKelvinToCelsius(kelvinTemperature);
                        } else if (conversionScale.getItemAt(conversionScale.getSelectedIndex()).equals("Фаренгейта")) {
                            String kelvinTemperatureText = temperatureTextField.getText();
                            double kelvinTemperature = Double.parseDouble(kelvinTemperatureText);
                            controller.convertKelvinToFahrenheit(kelvinTemperature);
                        } else {
                            String kelvinTemperatureText = temperatureTextField.getText();
                            double kelvinTemperature = Double.parseDouble(kelvinTemperatureText);
                            controller.returnKelvinTemperature(kelvinTemperature);
                        }
                    } else {
                        if (conversionScale.getItemAt(conversionScale.getSelectedIndex()).equals("Цельсия")) {
                            String fahrenheitTemperatureText = temperatureTextField.getText();
                            double fahrenheitTemperature = Double.parseDouble(fahrenheitTemperatureText);
                            controller.convertFahrenheitToCelsius(fahrenheitTemperature);
                        } else if (conversionScale.getItemAt(conversionScale.getSelectedIndex()).equals("Кельвина")) {
                            String fahrenheitTemperatureText = temperatureTextField.getText();
                            double fahrenheitTemperature = Double.parseDouble(fahrenheitTemperatureText);
                            controller.convertFahrenheitToKelvin(fahrenheitTemperature);
                        } else {
                            String fahrenheitTemperatureText = temperatureTextField.getText();
                            double fahrenheitTemperature = Double.parseDouble(fahrenheitTemperatureText);
                            controller.returnFahrenheitTemperature(fahrenheitTemperature);
                        }
                    }
                } catch (NumberFormatException exception) {
                    showError("Температура должна быть числом");
                }
            });

            panel.add(resultPanel);
            panel.add(convertButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    @Override
    public void updateTemperature(double temperature) {
        resultLabel.setText("Температура в шкале " + conversionScale.getItemAt(conversionScale.getSelectedIndex()) + " " + temperature);
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
