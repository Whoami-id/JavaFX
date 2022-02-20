
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderMain extends Application {

    // Variablen
    Slider sliderOpacity = new Slider(0, 1, 1);
    Slider sliderSepia = new Slider(0, 1, 1);
    Slider sliderScale = new Slider(0.5, 1, 1);

    Label labeblOpacity = new Label("Opacity Level");
    Label labelSepia = new Label("Sepia Tone");
    Label labelScale = new Label("Scale Factor");

    Label opactiyValue = new Label(Double.toString(sliderOpacity.getValue()));
    Label sepiaValue = new Label(Double.toString(sliderSepia.getValue()));
    Label scalingValue = new Label(Double.toString(sliderScale.getValue()));

    SepiaTone sepiaTone = new SepiaTone();

    Image image = new Image(getClass().getResourceAsStream("images/image1.jpg"));

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final HBox root = new HBox(40);
        final Scene scene = new Scene(root, 600, 400);

        final GridPane gridPane = new GridPane();
        scene.setRoot(gridPane);

        gridPane.setVgap(10);
        gridPane.setHgap(70);
        gridPane.setPadding(new Insets(10));

        // Elemente in das GridPane hinzufügen
        final VBox labelCaption = new VBox(5);
        final VBox slider = new VBox(5);
        final VBox labelValue = new VBox(5);

        final HBox hBox = new HBox(30);

        labelCaption.getChildren().addAll(labeblOpacity, labelSepia, labelScale);
        slider.getChildren().addAll(sliderOpacity, sliderSepia, sliderScale);
        labelValue.getChildren().addAll(opactiyValue, sepiaValue, scalingValue);

        hBox.getChildren().addAll(labelCaption, slider, labelValue);

        // gridPane.add(labeblOpacity, 0, 1);
        // gridPane.add(labelSepia, 0, 2);
        // gridPane.add(labelScale, 0, 3);

        // gridPane.add(sliderOpacity, 1, 1);
        // gridPane.add(sliderSepia, 1, 2);
        // gridPane.add(sliderScale, 1, 3);
        //
        // gridPane.add(opactiyValue, 2, 1);
        // gridPane.add(sepiaValue, 2, 2);
        // gridPane.add(scalingValue, 2, 3);

        gridPane.add(hBox, 0, 1);

        final ImageView imageView = new ImageView(image);
        gridPane.add(imageView, 0, 0);

        imageView.setEffect(sepiaTone);

        // Listener
        sliderOpacity.valueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> {
            imageView.setOpacity(newValue.doubleValue());
            opactiyValue.setText(String.format("%.2f", newValue));
        });

        sliderSepia.valueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> {
            sepiaTone.setLevel(newValue.doubleValue());
            sepiaValue.setText(String.format("%.2f", newValue));

        });

        sliderScale.valueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> {
            scalingValue.setText(String.format("%.2f", newValue));
            imageView.setScaleX(newValue.doubleValue());
            imageView.setScaleY(newValue.doubleValue());
        });

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }

}
