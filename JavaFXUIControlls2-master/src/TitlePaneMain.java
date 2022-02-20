
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TitlePaneMain extends Application {

    // Variablen

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final FlowPane root = new FlowPane();
        final Scene scene = new Scene(root, 800, 500);
        root.setPadding(new Insets(10));
        root.setVgap(20);
        root.setHgap(20);

        // TitledPane Button
        final TitledPane titledPane = new TitledPane();
        // titledPane.setContent(new Button("OK"));
        titledPane.setText("Button");

        final GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5));

        gridPane.add(new Label("Name: "), 0, 0);
        gridPane.add(new TextField(), 1, 0);

        gridPane.add(new Label("Nachname: "), 0, 1);
        gridPane.add(new TextField(), 1, 1);

        gridPane.add(new Label("Email: "), 0, 2);
        gridPane.add(new TextField(), 1, 2);

        titledPane.setContent(gridPane);

        // Elemente hinzufügen
        root.getChildren().addAll(titledPane);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        // Locale.setDefault(Locale.FRENCH);
        launch(args);
    }

}
