package sk.spse.uloha1.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    private double celsius = 0;
    private double fahrenheit = 0;

    @FXML
    private TextField celsiusField;

    @FXML
    private TextField fahrenheitField;

    @FXML
    private void convertToCtoF() {
        celsius = Double.parseDouble(celsiusField.getText());
        fahrenheit = (celsius * 9.0 / 5.0) + 32.0;

        fahrenheitField.setText(String.valueOf(fahrenheit));
    }

    @FXML
    private void convertToFtoC() {
        fahrenheit = Double.parseDouble(fahrenheitField.getText());
        celsius = (fahrenheit - 32.0) * 5.0 / 9.0;

        celsiusField.setText(String.valueOf(celsius));
    }
}
