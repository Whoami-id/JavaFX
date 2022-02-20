
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ScrollbarMain2 extends Application {

    // Variablen
    final ScrollBar scrollbar = new ScrollBar();
    final String[] images = { "images/bild0.jpg", // 0
            "images/bild1.jpg", "images/bild3.jpg", "images/bild4.jpg", "images/bild5.jpg", };

    DropShadow shadow = new DropShadow();
    final VBox vbox = new VBox();

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final Group root = new Group();
        final Scene scene = new Scene(root, 400, 400);
        root.getChildren().addAll(vbox, scrollbar);

        // Effekt
        shadow.setColor(Color.BLACK);
        shadow.setOffsetX(10);
        shadow.setOffsetY(10);

        // VBox
        vbox.setLayoutX(5);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));

        // Scrollbar
        scrollbar.setLayoutX(scene.getWidth() - scrollbar.getWidth());
        scrollbar.setOrientation(Orientation.VERTICAL);
        scrollbar.setPrefHeight(400);
        scrollbar.setMax(2000);

        // Bilder
        for (int i = 0; i < images.length; i++) {
            final ImageView imageView = new ImageView(new Image(images[i]));
            imageView.setEffect(shadow);
            vbox.getChildren().add(imageView);
        }

        // Eventhanlding / Listener
        scrollbar.valueProperty().addListener((ChangeListener<Number>) (observableValue, oldValue, newValue) -> vbox
                .setLayoutY(-newValue.doubleValue()));

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);
    }
}
