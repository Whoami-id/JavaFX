
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CirclePropertyMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final Pane root = new Pane();

        final Circle circle = new Circle();

        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setFill(Color.BLUE);

        circle.centerYProperty().bind(root.widthProperty().divide(2));
        circle.centerXProperty().bind(root.heightProperty().divide(2));
        circle.radiusProperty().bind(root.widthProperty().divide(4));

        final TextField textField = new TextField();
        textField.setMaxWidth(300);

        final Label label = new Label();
        label.setFont(new Font(20));
        label.setLayoutX(100);
        label.setLayoutY(100);

        label.textProperty().bind(textField.textProperty());

        root.getChildren().addAll(circle, textField, label);

        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);

    }

}
