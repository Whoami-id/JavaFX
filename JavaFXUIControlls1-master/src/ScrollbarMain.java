import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ScrollbarMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final HBox root = new HBox(10);

        final ScrollBar scrollbar = new ScrollBar();
        scrollbar.setOrientation(Orientation.VERTICAL);
        scrollbar.setPrefHeight(300);
        scrollbar.setValue(50);

        final Label label = new Label();

        scrollbar.valueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> {
            final int i = newValue.intValue();
            label.setText("Wert: " + i);

        });

        root.getChildren().addAll(scrollbar, label);
        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);

    }

}
