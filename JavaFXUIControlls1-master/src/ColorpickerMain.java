import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ColorpickerMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final FlowPane root = new FlowPane();
        root.setPadding(new Insets(20));
        final Scene scene = new Scene(root, 400, 400);
        root.setVgap(20);
        root.setVgap(20);

        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);

        final Circle circle = new Circle(100);

        colorPicker.setOnAction(event -> circle.setFill(colorPicker.getValue()));

        root.getChildren().addAll(colorPicker, circle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);

    }

}
