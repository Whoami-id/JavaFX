import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final VBox root = new VBox();

        final CheckBox cBox = new CheckBox();

        cBox.setText("FullScreen");

        root.getChildren().add(cBox);

        cBox.setOnMouseClicked(event -> primaryStage.setFullScreen(true));

        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);

    }

}
