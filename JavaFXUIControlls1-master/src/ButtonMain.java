import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final VBox root = new VBox();

        final Button button = new Button("Ok");
        final Image image = new Image(getClass().getResourceAsStream("images/ok.png"));
        button.setGraphic(new ImageView(image));

        root.getChildren().add(button);
        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);

    }

}
