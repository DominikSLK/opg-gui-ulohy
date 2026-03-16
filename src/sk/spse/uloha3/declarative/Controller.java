package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;

import java.awt.*;
import java.net.URI;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    @FXML
    private void openLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.spse-po.sk"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}
