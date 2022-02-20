
package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewMain extends Application {

    // Variablen

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final Group root = new Group(); // Layout -> alle Elmente haben die Position 0/0
        final Scene scene = new Scene(root, 550, 450);

        // TableView erstellen
        final Label label = new Label("Adressen: ");
        label.setFont(new Font(20));
        final TableView<Person> tableView = new TableView<>();

        // Tabellenspalten erstellen
        final TableColumn<Person, String> userNameCol = new TableColumn<>("Username");
        userNameCol.setMinWidth(100);
        userNameCol.setMaxWidth(150);
        final TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(200);
        emailCol.setMaxWidth(200);

        final TableColumn<Person, String> fullNameCol = new TableColumn<>("Full Name");

        final TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setMinWidth(100);

        final TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setMinWidth(100);

        // Spalten gruppieren
        fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);

        tableView.getColumns().addAll(userNameCol, emailCol, fullNameCol);

        // Spalten vorbereiten zum füllen mit Daten
        // Erhalten die Daten aus den Person Objekten
        userNameCol.setCellValueFactory(new PropertyValueFactory("userName"));
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));

        // Daten in die Tabelle einfügen - setItems
        final ObservableList<Person> list = getUserList();
        tableView.setItems(list);

        // Sortierung innerhalb der Spalte aktivieren
        userNameCol.setSortable(true);
        userNameCol.setSortType(SortType.ASCENDING); // ASCENDING = AUFSTEIGEND / DESCENDING = ABSTEIGEND

        // Daten in einer Tabelle editieren
        tableView.setEditable(true);

        userNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());

        userNameCol.setOnEditCommit(event -> {
            final String newValue = event.getNewValue();
            final TablePosition<Person, String> position = event.getTablePosition();

            System.out.println(
                    "Neuer Wert: " + newValue + " Spalte: " + position.getColumn() + " Zeile: " + position.getRow());

            final Person person = event.getTableView().getItems().get(position.getRow());
            person.setUserName(newValue);

        });

        // Elemente hinzufügen
        final VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().addAll(label, tableView);

        root.getChildren().addAll(vBox);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // Personen erstellen
    private ObservableList<Person> getUserList() {
        final Person person = new Person("smith", "Peter", "Müller", "PeterMüller@gmail.com");
        final Person person2 = new Person("angle", "Peter", "Müller", "PeterMüller@gmail.com");
        final Person person3 = new Person("xrow", "Peter", "Müller", "PeterMüller@gmail.com");
        final Person person4 = new Person("lofi", "Peter", "Müller", "PeterMüller@gmail.com");
        final Person person5 = new Person("huhu", "Peter", "Müller", "PeterMüller@gmail.com");
        final Person person6 = new Person("berd", "Peter", "Müller", "PeterMüller@gmail.com");
        final ObservableList<Person> list = FXCollections.observableArrayList(person, person2, person3, person4,
                person5, person6);

        return list;
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
