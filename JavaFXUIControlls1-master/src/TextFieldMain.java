
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextFieldMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Layout Container
        // HBox root = new HBox(10);
        // root.setPadding(new Insets(20));
        final GridPane root = new GridPane();
        root.setPadding(new Insets(40));
        root.setVgap(10);
        root.setHgap(10);

        // TextField erstellen
        // TextField textField = new TextField("Name...");
        // textField.setPrefColumnCount(10);
        // Label label = new Label("Name:");
        // label.setPadding(new Insets(5));

        final TextField textField = new TextField("Name...");
        root.add(textField, 0, 0);

        final TextField textField2 = new TextField("Passwort...");
        root.add(textField2, 0, 1);

        final Button button = new Button("OK");
        button.setMaxSize(100, 100);
        root.add(button, 1, 0);

        final Button button2 = new Button("Clear");
        button2.setMaxSize(100, 100);
        root.add(button2, 1, 1);

        final Label label = new Label("Test");
        root.add(label, 0, 2);

        // Listener / Eventhandling
        button2.setOnAction(arg0 -> {
            textField.clear();
            textField2.clear();
            label.setText("");
        });

        button.setOnAction(arg0 -> {
            if (textField.getText() != null && !textField2.getText().isEmpty()) {
                label.setText(textField.getText() + " " + textField2.getText());
            } else {
                label.setText("Keine Werte eingeben");
            }

        });

        // Elemente (Nodes) hinzufügen
        // root.getChildren().addAll(label,textField);

        // Scene erstellen und anzeigen
        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);
    }
}
