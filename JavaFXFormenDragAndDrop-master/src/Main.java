import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final Group root = new Group();
        final Scene scene = new Scene(root, 400, 400);

        // Kreise erstellen
        final Circle circle = new Circle(50, Color.RED);
        circle.setCursor(Cursor.MOVE);
        circle.setTranslateX(100);
        circle.setTranslateY(100);
        circle.setOnMousePressed(circlePressed);
        circle.setOnMouseDragged(circelDragged);

        final Circle circle2 = new Circle(50, Color.BLACK);
        circle2.setCursor(Cursor.OPEN_HAND);
        circle2.setTranslateX(200);
        circle2.setTranslateY(200);
        circle2.setOnMousePressed(circlePressed);
        circle2.setOnMouseDragged(circelDragged);

        final Circle circle3 = new Circle(50, Color.BLUEVIOLET);
        circle3.setCursor(Cursor.HAND);
        circle3.setTranslateX(300);
        circle3.setTranslateY(300);
        circle3.setOnMousePressed(circlePressed);
        circle3.setOnMouseDragged(circelDragged);

        root.getChildren().addAll(circle, circle2, circle3);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Drag and drop
    EventHandler<MouseEvent> circelDragged = event -> {
        // System.out.println("Dragged");
        final double offSetX = event.getSceneX() - orgSceneX;
        final double offSetY = event.getSceneY() - orgSceneY;

        final double newTranslateX = orgTranslateX + offSetX;
        final double newTranslateY = orgTranslateY + offSetY;

        ((Circle) event.getSource()).setTranslateX(newTranslateX);
        ((Circle) event.getSource()).setTranslateY(newTranslateY);
    };

    // Gedrückt
    EventHandler<MouseEvent> circlePressed = event -> {
        // System.out.println("Gedrückt");
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();

        orgTranslateX = ((Circle) event.getSource()).getTranslateX();
        orgTranslateY = ((Circle) event.getSource()).getTranslateY();

    };

    public static void main(final String[] args) {
        launch(args);
    }

}
