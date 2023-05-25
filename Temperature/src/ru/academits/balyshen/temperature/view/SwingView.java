package ru.academits.balyshen.temperature.view;

import ru.academits.balyshen.temperature.controller.Controller;
import ru.academits.balyshen.temperature.model.scales.TemperatureScale;

import javax.swing.*;
import java.awt.*;

public class SwingView implements View {
    private final Controller controller;
    private JLabel resultLabel;
    private JFrame frame;
    private JComboBox<TemperatureScale> resultingScalesComboBox;

    public SwingView(Controller controller) {
        this.controller = controller;
        controller.setView(this);
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            frame = new JFrame("Конвертер температур");
            frame.setSize(340, 280);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            c.gridwidth = 3;
            c.insets = new Insets(10, 0, 10, 0);
            panel.add(new JLabel("Выберите шкалы для конвертации"), c);

            JPanel initialScalePanel = new JPanel();
            initialScalePanel.add(new JLabel("Исходная шкала:"));
            JComboBox<TemperatureScale> initialScalesComboBox = new JComboBox<>(controller.getScales());
            initialScalePanel.add(initialScalesComboBox);

            c.gridy = 1;
            c.insets = new Insets(0, 10, 0, 0);
            panel.add(initialScalePanel, c);

            JPanel resultingScalePanel = new JPanel();
            resultingScalePanel.add(new JLabel("Результирующая шкала:"));
            resultingScalesComboBox = new JComboBox<>(controller.getScales());
            resultingScalePanel.add(resultingScalesComboBox);

            c.gridy = 2;
            c.insets = new Insets(0, 10, 0, 0);
            panel.add(resultingScalePanel, c);

            c.gridy = 3;
            c.insets = new Insets(20, 0, 0, 0);
            panel.add(new JLabel("Введите температуру:"), c);

            JTextField temperatureTextField = new JTextField(30);
            c.gridy = 4;
            c.insets = new Insets(0, 0, 0, 0);
            panel.add(temperatureTextField, c);

            JButton convertButton = new JButton("Конвертировать");
            convertButton.addActionListener(e -> {
                try {
                    String celsiusTemperatureText = temperatureTextField.getText();
                    double celsiusTemperature = Double.parseDouble(celsiusTemperatureText);
                    controller.convertTemperature(
                            celsiusTemperature,
                            (TemperatureScale) initialScalesComboBox.getSelectedItem(),
                            (TemperatureScale) resultingScalesComboBox.getSelectedItem());
                } catch (NumberFormatException exception) {
                    showError("Температура должна быть числом");
                }
            });

            c.gridy = 5;
            c.insets = new Insets(10, 0, 0, 0);
            panel.add(convertButton, c);

            c.gridy = 6;
            c.insets = new Insets(20, 0, 0, 0);
            panel.add(new JLabel("Результат:"), c);

            resultLabel = new JLabel();
            c.gridy = 7;
            c.insets = new Insets(0, 0, 0, 0);
            panel.add(resultLabel, c);

            frame.add(panel, BorderLayout.PAGE_START);
            frame.setVisible(true);
        });
    }

    @Override
    public void updateTemperature(double temperature) {
        resultLabel.setText("Температура в шкале " + resultingScalesComboBox.getItemAt(resultingScalesComboBox.getSelectedIndex()) + ": " + temperature);
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}