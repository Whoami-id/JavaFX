
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventHandlingMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);

        final Scene scene = new Scene(root, 400, 400);
        final Text text = new Text("Login");
        root.add(text, 0, 0);

        final TextField textField = new TextField("Username");
        root.add(textField, 0, 1);

        final PasswordField passField = new PasswordField();
        root.add(passField, 0, 2);

        final Button button = new Button("Login");
        root.add(button, 0, 3);

        primaryStage.setScene(scene);
        primaryStage.show();

        final EventHandler<MouseEvent> eventHandler = event -> {
            final String username = textField.getText();
            final String password = passField.getText();
            if (username.equalsIgnoreCase("Janatan") && password.equals("1234")) {
                text.setText("Login erfolgreich");
                text.setFill(Color.GREEN);

            } else {
                text.setText("Login Fehlgescglagen");
                text.setFill(Color.RED);
            }

        };

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);

    }

    public static void main(final String[] args) {
        launch(args);

    }

}
