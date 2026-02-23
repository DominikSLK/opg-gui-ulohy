package sk.spse.uloha2.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Užívateľské meno:");
        Label passwordLabel = new Label("Heslo:");
        Label genderLabel = new Label("Pohlavie:");

        TextField usernameField = new TextField();
        usernameField.setPromptText("zadaj meno");

        TextField passwordField = new TextField();
        passwordField.setPromptText("zadaj heslo");

        ToggleGroup pohlavieGroup = new ToggleGroup();

        RadioButton maleRadio = new RadioButton("Muž");
        maleRadio.setSelected(true);
        maleRadio.setToggleGroup(pohlavieGroup);

        RadioButton femaleRadio = new RadioButton("Žena");
        femaleRadio.setToggleGroup(pohlavieGroup);

        HBox genderBox = new HBox(10, maleRadio, femaleRadio);
        genderBox.setAlignment(Pos.CENTER_LEFT);

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);

        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);

        grid.add(genderLabel, 0, 2);
        grid.add(genderBox, 1, 2);

        Separator separator = new Separator();
        separator.setPadding(new Insets(0, -10, 0, -10));
        grid.add(separator, 0, 3, 2, 1);

        Button registerButton = new Button("Registrovať");
        Button closeButton = new Button("Zavrieť");

        HBox buttonsBox = new HBox(10, registerButton, closeButton);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        grid.add(buttonsBox, 0, 4, 2, 1);

        registerButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registrácia užívateľa");
            alert.setHeaderText("Registrácia prebehla úspešne");
            alert.setContentText("Uživateľ " + usernameField.getText() + " (" + ((RadioButton)pohlavieGroup.getSelectedToggle()).getText() + ") s heslom " + passwordField.getText() + " bol pridaný do systému");
            alert.showAndWait();
        });

        closeButton.setOnAction(e -> Platform.exit());

        Scene scene = new Scene(grid);

        stage.setTitle("Procedural Application 2");
        stage.setScene(scene);
        stage.show();
    }
}