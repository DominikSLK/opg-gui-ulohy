package sk.spse.uloha4.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    private VBox vbox1;
    private VBox vbox2;
    private VBox vbox3;
    private VBox vbox4;

    private String getRandomColor() {
        int color = (int) (Math.random() * 0x1000000);
        return String.format("#%06X", color);
    }

    private VBox createImageBox(String color, Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        VBox box = new VBox(imageView);
        box.setAlignment(Pos.CENTER);
        box.setPrefSize(100, 200);
        box.setStyle("-fx-background-color: " + color + ";");

        return box;
    }

    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox2.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox3.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox4.setStyle("-fx-background-color: " + getRandomColor() + ";");
    }

    @Override
    public void start(Stage stage) {
        Image image = new Image(getClass().getResourceAsStream("/sk/spse/uloha4/soup2.png"));

        vbox1 = createImageBox("#0000ff", image);
        vbox2 = createImageBox("#ffff00", image);
        vbox3 = createImageBox("#008000", image);
        vbox4 = createImageBox("#ff0000", image);

        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(4);
        tilePane.setPrefSize(602, 200);
        tilePane.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);

        HBox topBox = new HBox(tilePane);

        Label quoteLabel = new Label("\"In the future, everyone will be world-famous for 15 minutes\"");
        Label authorLabel = new Label("- Andy Warhol");

        VBox textBox = new VBox(quoteLabel, authorLabel);
        textBox.setPrefWidth(382);

        Button randomizeButton = new Button("Randomize");
        randomizeButton.setOnAction(e -> randomize());

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> Platform.exit());

        HBox buttonsBox = new HBox(5, randomizeButton, closeButton);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        buttonsBox.setPrefWidth(200);

        HBox.setHgrow(textBox, Priority.ALWAYS);

        HBox bottomBox = new HBox(textBox, buttonsBox);
        bottomBox.setPadding(new Insets(10));
        bottomBox.setPrefHeight(55);

        VBox root = new VBox(topBox, bottomBox);
        root.setPrefSize(600, 248);

        Scene scene = new Scene(root);

        stage.setTitle("Procedural Application 4");
        stage.setScene(scene);
        stage.show();
    }
}