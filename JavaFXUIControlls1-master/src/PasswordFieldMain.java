
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PasswordFieldMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Layout Container
        final HBox root = new HBox(10);
        root.setPadding(new Insets(20));

        // PasswordField erstellen
        final PasswordField passwordField = new PasswordField();
        passwordField.setMaxSize(200, 30);

        final Label label = new Label();

        // Listener / Eventhandling
        passwordField.setOnAction(arg0 -> {
            if (passwordField.getText().equals("1234")) {
                label.setText("Passwort korrekt");
                label.setTextFill(Color.GREEN);
            } else {
                label.setText("Passwort falsch!");
                label.setTextFill(Color.RED);
            }
            passwordField.clear();
        });

        // Elemente (Nodes) hinzufügen
        root.getChildren().addAll(passwordField, label);

        // Scene erstellen und anzeigen
        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);
    }
}
