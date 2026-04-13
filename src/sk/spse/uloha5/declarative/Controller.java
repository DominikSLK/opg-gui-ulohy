package sk.spse.uloha5.declarative;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller implements Initializable {

    @FXML
    private TableView<Jedlo> tabulka;
    @FXML
    private TableColumn<Jedlo, Integer> id;
    @FXML
    private TableColumn<Jedlo, String> nazovJedal;
    @FXML
    private TableColumn<Jedlo, Integer> kalorie;
    @FXML
    private TableColumn<Jedlo, Double> cena;

    private List<Jedlo> jedloList = new ArrayList<>();

    {
        jedloList.add(new Jedlo(0, "Chlieb", 200, 2.0));
        jedloList.add(new Jedlo(1, "Mlieko", 300, 0.65));
        jedloList.add(new Jedlo(2, "Kebab", 500, 12.5));
        jedloList.add(new Jedlo(3, "Coca Cola", 30, 1.39));
        jedloList.add(new Jedlo(4, "Jablko", 50, 0.99));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().id()).asObject());
        nazovJedal.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().nazov()));
        kalorie.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().kalorie()).asObject());
        cena.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().cena()).asObject());
        tabulka.getItems().setAll(jedloList);
    }

    @FXML
    public void delete() {
        Jedlo item = tabulka.getSelectionModel().getSelectedItem();
        jedloList.remove(item);
        tabulka.getItems().remove(item);
    }

    @FXML
    public void close() {
        Platform.exit();
    }
}
