import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final HBox root = new HBox();
        root.setSpacing(10);
        root.setPadding(new Insets(20));

        final ComboBox<String> coBox = new ComboBox<>();
        coBox.setItems(FXCollections.observableArrayList("Der Anfang", "Der Mitte", "Der Rest"));
        coBox.getItems().addAll("Der Ende", "Der Nichts");

        coBox.setPromptText("Der Nichts");
        coBox.setEditable(true);
        final Button button = new Button("OK");

        button.setOnMouseClicked(event -> primaryStage.setTitle(coBox.getValue()));

        root.getChildren().addAll(coBox, button);

        final Scene scene = new Scene(root, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {

        launch(args);

    }

}
