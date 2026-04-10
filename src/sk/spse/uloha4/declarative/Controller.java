package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import java.util.Random;
import java.util.Locale;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vbox3;
    @FXML
    private VBox vbox4;

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    
    private Random rand = new Random();

    private String getRandomColor() {
        int color = (int) (Math.random() * 0x1000000);
        return String.format("#%06X", color);
    }

    private double getRandomRotate() {
        return rand.nextDouble() * 360.0;
    }

    private double getRandomScale() {
        return 0.5 + rand.nextDouble() * 1.5;
    }

    private String getRandomOpaque() {
        double x = rand.nextDouble();
        String s = String.format(Locale.ROOT, "%.2f", x);
        return s;
    }

    @FXML
    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpaque());
        vbox2.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpaque());
        vbox3.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpaque());
        vbox4.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpaque());

        img1.setStyle("-fx-rotate: " + getRandomRotate());
        img2.setStyle("-fx-scale-x: " + getRandomScale());
        img3.setStyle("-fx-scale-y: " + getRandomScale());
        img4.setStyle("-fx-scale-x: " + getRandomScale() + "; -fx-scale-y: " + getRandomScale() + "; -fx-rotate: " + getRandomRotate());
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}
