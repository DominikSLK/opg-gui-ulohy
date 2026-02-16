package sk.spse.uloha1.procedural;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    private double celsius = 0;
    private double fahrenheit = 0;

    @Override
    public void start(Stage stage) {
        Label labelCelsia = new Label("Stupne Celsia");
        Label labelFahrenheit = new Label("Stupne Fahrenheita");

        TextField celsiusField = new TextField("0");
        TextField fahrenheitField = new TextField("0");

        celsiusField.setOnKeyTyped(e -> {
            celsius = Double.parseDouble(celsiusField.getText());
            fahrenheit = (celsius * 9.0 / 5.0) + 32.0;

            fahrenheitField.setText(String.valueOf(fahrenheit));
        });

        fahrenheitField.setOnKeyTyped(e -> {
            fahrenheit = Double.parseDouble(fahrenheitField.getText());
            celsius = (fahrenheit - 32.0) * 5.0 / 9.0;

            celsiusField.setText(String.valueOf(celsius));
        });

        HBox celsiusBox = new HBox(20, labelCelsia, celsiusField);
        HBox fahrenheitBox = new HBox(20, labelFahrenheit, fahrenheitField);

        celsiusBox.setAlignment(Pos.CENTER_RIGHT);
        fahrenheitBox.setAlignment(Pos.CENTER_RIGHT);

        VBox root = new VBox(20, celsiusBox, fahrenheitBox);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);

        stage.setTitle("Procedural Application 1");
        stage.setScene(scene);
        stage.show();
    }
}