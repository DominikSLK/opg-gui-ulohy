package sk.spse.uloha3.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.net.URI;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setPrefSize(607, 344);

        Text title = new Text("Stredná priemyselná škola elektrotechnická, Prešov");
        title.setFont(new Font(20));
        title.setWrappingWidth(445.42);
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);

        ImageView obrazok = new ImageView();
        Image image = new Image(getClass().getResourceAsStream("/sk/spse/uloha3/spse.png"));
        obrazok.setImage(image);
        obrazok.setFitWidth(200);
        obrazok.setFitHeight(150);
        obrazok.setPreserveRatio(true);
        BorderPane.setAlignment(obrazok, Pos.CENTER);
        root.setLeft(obrazok);

        TextArea textArea = new TextArea(
                "Vážení rodičia a milí žiaci základných škôl,\n\n" +
                        "radi by sme Vás privítali v priestoroch našej školy\n" +
                        "dňa 10.02.2026 (utorok) od 13.00 do 17.00 h na\n" +
                        "Dni otvorených dverí, kde by sme Vám chceli\n" +
                        "predstaviť naše študijné odbory."
        );
        textArea.setEditable(false);
        textArea.setFocusTraversable(false);
        textArea.setWrapText(true);
        textArea.setPrefSize(427, 211);
        textArea.setFont(new Font(17));

        Hyperlink hyperlink = new Hyperlink("https://www.spse-po.sk");
        hyperlink.setFocusTraversable(false);
        hyperlink.setFont(new Font(15));
        hyperlink.setOnAction(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.spse-po.sk"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox centerBox = new VBox(5, textArea, hyperlink);
        centerBox.setAlignment(Pos.CENTER_LEFT);
        centerBox.setPadding(new Insets(0, 0, 0, 10));
        root.setCenter(centerBox);

        Slider slider = new Slider();
        slider.setOnMouseDragged(e -> obrazok.setRotate(slider.getValue()));
        slider.setOnMouseReleased(e -> obrazok.setRotate(slider.getValue()));

        Button button = new Button("Beriem na vedomie");
        button.setPrefSize(136, 27);
        button.setFont(new Font(14));
        button.setOnAction(e -> Platform.exit());

        HBox bottomBox = new HBox(10, slider, button);
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        bottomBox.setPadding(new Insets(10, 0, 0, 0));
        root.setBottom(bottomBox);

        Scene scene = new Scene(root);

        stage.setTitle("Procedural Application 3");
        stage.setScene(scene);
        stage.show();
    }
}