import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonMain extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final VBox root = new VBox(10);

        final RadioButton rButton = new RadioButton();
        rButton.setText("Facebook");

        final RadioButton rButton2 = new RadioButton();
        rButton2.setText("Twitter");

        final RadioButton rButton3 = new RadioButton();
        final Image image = new Image(getClass().getResourceAsStream("images/googleplus.png"));
        rButton3.setGraphic(new ImageView(image));

        final ToggleGroup tgroup = new ToggleGroup();
        rButton.setToggleGroup(tgroup);
        rButton2.setToggleGroup(tgroup);
        rButton3.setToggleGroup(tgroup);
        rButton3.setSelected(true);

        // property listener
        final ImageView iView = new ImageView();

        rButton.setUserData("images/facebook.png");
        rButton2.setUserData("images/twitter.png");
        rButton3.setUserData("images/googleplus.png");

        tgroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (tgroup.getSelectedToggle() != null) {
                final Image im = new Image(
                        getClass().getResourceAsStream(tgroup.getSelectedToggle().getUserData().toString()));
                iView.setImage(im);
            }

        });

        root.getChildren().addAll(rButton, rButton2, rButton3, iView);
        final Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);

    }

}
