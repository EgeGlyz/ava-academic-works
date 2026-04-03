package org.example.mycurrencyconverter;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CurrencyConverterCtrl {

    @FXML
    private ComboBox<String> fromCurrency, toCurrency;

    @FXML
    private TextField amountField;

    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        fromCurrency.getItems().addAll("EUR", "USD", "TRY");
        toCurrency.getItems().addAll("ISK (Iceland Krona)", "USD", "TRY");
        fromCurrency.setValue("EUR");
        toCurrency.setValue("ISK (Iceland Krona)");
    }

    @FXML
    public void convert() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            double rate = 139.25;
            double result = amount * rate;
            resultLabel.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }
}