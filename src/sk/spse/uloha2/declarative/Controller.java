package sk.spse.uloha2.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button closeButton;

    @FXML
    private ToggleGroup pohlavieGroup;

    @FXML
    private void register() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registrácia užívateľa");
        alert.setHeaderText("Registrácia prebehla úspešne");
        alert.setContentText("Uživateľ " + usernameField.getText() + " (" + ((RadioButton)pohlavieGroup.getSelectedToggle()).getText() + ") s heslom " + passwordField.getText() + " bol pridaný do systému");
        alert.showAndWait();
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}
