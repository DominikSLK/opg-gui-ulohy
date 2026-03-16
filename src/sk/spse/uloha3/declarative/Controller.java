package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URI;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    public ImageView obrazok;

    @FXML
    private Slider slider;

    @FXML
    private void openLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.spse-po.sk"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void rotuj(MouseEvent mouseEvent) {
        obrazok.setRotate(slider.getValue());
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}
