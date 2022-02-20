package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewMain extends Application {

    // Variablen
    Button selectAll = new Button("Select All");
    Button clearAll = new Button("Clear All");
    Button selectFirst = new Button("selectFirst");
    Button selectLast = new Button("selectLast");
    Button selectNext = new Button("selectNext");
    Button selectPrevios = new Button("selectPrevios");

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final HBox root = new HBox(40);
        final Scene scene = new Scene(root, 600, 400);

        // ListView - Liste erstellen
        final ListView<String> listView = new ListView<>();

        // Liste erstellen - ObservableList
        final ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll("Berlin", "Hamburg", "Bremen", "München", "Düsseldorf", "Nürnberg");

        // ListView Methoden
        listView.setItems(observableList);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // listView.setOrientation(Orientation.HORIZONTAL);

        // Tracking der User Interaktion - Wo hat der User geklickt
        // listView.getSelectionModel().getSelectedIndex(); // Index des geklickten items
        // listView.getSelectionModel().getSelectedItem(); // Item / Inhalt welches gegklickt wurde
        // listView.getFocusModel().getFocusedIndex(); // Index des fokussierten items
        // listView.getFocusModel().getFocusedItem(); // Item / Inhalt welches fokussiert wurde

        // Eventhanlding - Tracking
        listView.setOnMouseClicked(arg0 -> {
            System.out.println("Index: " + listView.getSelectionModel().getSelectedIndex());
            System.out.println("Inhalt: " + listView.getSelectionModel().getSelectedItem());
            System.out.println("Index Fokus: " + listView.getFocusModel().getFocusedIndex());
            System.out.println("Inhalt Fokus: " + listView.getFocusModel().getFocusedItem());
        });

        listView.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.SECONDARY)) {
                System.out.println("Kopieren");
            }

        });

        // Buttongröße dynamisch anpassen
        final VBox vBox = new VBox();
        vBox.getChildren().addAll(selectAll, clearAll, selectFirst, selectLast, selectNext, selectPrevios);

        selectAll.setMaxWidth(Double.MAX_VALUE);
        clearAll.setMaxWidth(Double.MAX_VALUE);
        selectFirst.setMaxWidth(Double.MAX_VALUE);
        selectLast.setMaxWidth(Double.MAX_VALUE);
        selectNext.setMaxWidth(Double.MAX_VALUE);
        selectPrevios.setMaxWidth(Double.MAX_VALUE);

        selectAll.setOnAction(arg0 -> listView.getSelectionModel().selectAll());

        clearAll.setOnAction(arg0 -> listView.getSelectionModel().clearSelection());

        selectFirst.setOnAction(arg0 -> listView.getSelectionModel().selectFirst());

        selectLast.setOnAction(arg0 -> listView.getSelectionModel().selectLast());

        selectNext.setOnAction(arg0 -> listView.getSelectionModel().selectNext());

        selectPrevios.setOnAction(arg0 -> listView.getSelectionModel().selectPrevious());

        // Button Eventhandling

        // Eventhandling mit der Liste
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());
        // listView.setCellFactory(ComboBoxListCell.forListView());
        // listView.setCellFactory(ChoiceBoxListCell.forListView());

        listView.setOnEditCommit(event -> {
            System.out.println("Test");
            final String newValue = event.getNewValue();
            final int index = event.getIndex();
            System.out.println("neuer Wert: " + newValue + " Index: " + index);
            listView.getItems().set(index, newValue);
        });

        listView.setOnEditStart(arg0 -> System.out.println("Start von Edit"));

        listView.setOnEditCancel(arg0 -> {
            System.out.println("Cancel von Edit");
            final Stage stage = new Stage();
            final StackPane root1 = new StackPane();
            final Button button = new Button("Sind Sie sicher?");
            root1.getChildren().add(button);

            button.setOnAction(arg01 -> stage.close());

            final Scene scene1 = new Scene(root1, 200, 100);
            stage.setScene(scene1);
            stage.show();
        });

        // Elemente hinzufügen - Root Box
        root.getChildren().addAll(listView, vBox);

        root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 4;"
                + "-fx-border-radius: 5;" + "-fx-border-color: red;");

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);
    }
}
