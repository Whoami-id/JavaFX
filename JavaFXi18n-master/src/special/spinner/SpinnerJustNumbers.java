
package special.spinner;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SpinnerJustNumbers extends Application {

    // hier fällt die kommentare

    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        final TextField textField = new TextField("0");

        final Button up = new Button("\u25B4");
        final Button down = new Button("\u25BE");

        final HBox arrows = new HBox();
        arrows.getChildren().addAll(up, down);

        final GridPane mySpinner = new GridPane();
        mySpinner.add(textField, 0, 0);
        mySpinner.add(arrows, 1, 0);

        textField.textProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        final int startValue = Integer.parseInt(textField.getText());

        if (startValue > 59) {
            textField.setText("" + 59);
        }

        up.setOnAction(event -> {
            try {
                final int actualValue = Integer.parseInt(textField.getText());

                final String newValue = String.valueOf(Math.abs(actualValue) + 1);
                textField.setText(newValue);
                if (actualValue >= 59) {
                    textField.setText("0");
                } else {
                    textField.setText(newValue);
                }
            } catch (final NumberFormatException e) {
                textField.setText("0");
            }

        });

        down.setOnAction(event -> {
            try {
                final int actualValue = Integer.parseInt(textField.getText());

                if (actualValue <= 0) {
                    textField.setText("" + 59);
                } else {
                    final String newValue = String.valueOf(Math.abs(actualValue) - 1);
                    textField.setText(newValue);
                }
            } catch (final NumberFormatException e) {
                textField.setText("0");
            }
        });
        final BorderPane pane = new BorderPane();
        pane.setCenter(mySpinner);

        final Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
