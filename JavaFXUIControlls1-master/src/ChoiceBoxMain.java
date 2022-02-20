import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final VBox root = new VBox();

        final ChoiceBox<Object> chBox = new ChoiceBox<>();

        chBox.setItems(FXCollections.observableArrayList("Neues Dokument", "Öffnen", new Separator(), "Speichern"));
        chBox.getItems().add("Koppieren");
        chBox.getItems().add("Einfügen");
        chBox.getSelectionModel().select(0);

        chBox.setTooltip(new Tooltip("Menu Auswahl"));

        chBox.getSelectionModel().selectedIndexProperty()
                .addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> {
                    final String menuPoint = (String) chBox.getItems().get((int) newValue);
                    if (menuPoint.equals("Öffnen")) {
                        final Stage stage = new Stage();
                        stage.show();
                    }

                });

        root.getChildren().add(chBox);

        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);

    }

}
