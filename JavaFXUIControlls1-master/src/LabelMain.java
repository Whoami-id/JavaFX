import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final VBox root = new VBox();

        // label mit text
        final Label label1 = new Label();

        label1.setText("erste Label");
        label1.setTextFill(Color.web("#007a63"));
        label1.setFont(new Font("Arial", 50));

        // label mit Bild und text
        final Image image = new Image(getClass().getResourceAsStream("images/facebook.png"));
        final Label label2 = new Label("Einloggen: ", new ImageView(image));

        // label mit Bild
        final Label label3 = new Label();
        final Image image2 = new Image(getClass().getResourceAsStream("images/facebook.png"));
        label3.setGraphic(new ImageView(image2));
        label3.setTranslateX(100);
        // Effekt hinzufügen
        label3.setOnMouseEntered(event -> {
            label3.setScaleX(1.5);
            label3.setScaleY(1.5);

        });

        root.getChildren().addAll(label1, label2, label3);
        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);

    }

}
