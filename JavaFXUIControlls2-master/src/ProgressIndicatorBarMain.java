
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProgressIndicatorBarMain extends Application {

    // Variablen
    final Desktop desktop = Desktop.getDesktop();

    CopyTask copyTask = new CopyTask();

    final Label label = new Label("Kopiere Inhalte...");
    final ProgressBar progressBar = new ProgressBar();
    final ProgressIndicator progressIndicator = new ProgressIndicator();

    final Button startButton = new Button("Start");
    final Button cancelButon = new Button("Cancel");

    final Label statusLabel = new Label();

    List<String> copiedFilesAsString = new ArrayList<>();

    ListView<String> listView = new ListView<>();

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final FlowPane root = new FlowPane();
        final Scene scene = new Scene(root, 800, 500);
        root.setPadding(new Insets(10));
        root.setVgap(20);
        root.setHgap(20);

        // Start Button
        startButton.setOnAction(event -> {
            startButton.setDisable(true); // Button nicht mehr drückbar
            cancelButon.setDisable(false);
            progressBar.setProgress(0);
            progressIndicator.setProgress(0);

            // Statuslabel
            statusLabel.setTextFill(Color.BLUE);

            // ListView
            listView.setPrefSize(700, 400);

            // Binding - Ziel und Quelle
            progressBar.progressProperty().unbind();
            progressBar.progressProperty().bind(copyTask.progressProperty());

            progressIndicator.progressProperty().unbind();
            progressIndicator.progressProperty().bind(copyTask.progressProperty());

            statusLabel.textProperty().unbind();
            statusLabel.textProperty().bind(copyTask.messageProperty());

            // Aufgabe (Task)
            copyTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, event1 -> {
                final List<File> copiedList = copyTask.getValue();
                System.out.println("Liste korpierter Daten: " + copiedList);

                for (final File file : copiedList) {
                    copiedFilesAsString.add(file.toString());
                }

                final ObservableList<String> list = FXCollections.observableArrayList(copiedFilesAsString);
                listView.setItems(list);

            });

            // Kopiervorgang Start
            final Thread copyTaskThread = new Thread(copyTask);
            copyTaskThread.start();
        });

        cancelButon.setOnAction(event -> {
            startButton.setDisable(false);
            cancelButon.setDisable(true);
            copyTask.cancel(true); // Aufgabe beenden
            progressBar.progressProperty().unbind(); // Binding löschen
            progressIndicator.progressProperty().unbind();
            statusLabel.textProperty().unbind();

            progressBar.setProgress(0); // Auf 0 setzen
            progressIndicator.setProgress(0);

        });

        listView.setOnMouseClicked(event -> {
            final String fileName = listView.getSelectionModel().getSelectedItem();
            System.out.println(fileName);

            final File file = new File(fileName);

            try {
                desktop.open(file);
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        // Elemente hinzufügen
        root.getChildren().addAll(label, progressBar, progressIndicator, statusLabel, startButton, cancelButon,
                listView);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);
    }

}
