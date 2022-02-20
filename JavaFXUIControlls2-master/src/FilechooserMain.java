
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FilechooserMain extends Application {

    // Variablen
    private final Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final FlowPane root = new FlowPane();
        final Scene scene = new Scene(root, 800, 500);
        root.setPadding(new Insets(10));
        root.setHgap(20);

        // FileChooser erstellen
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Datei wählen");

        // Einzelne Datei wählen
        final Button button = new Button("Datei wählen");
        button.setOnAction(event -> {
            setupFilter(fileChooser);
            final File file = fileChooser.showOpenDialog(primaryStage); // Warte auf Eingabe vom User
            if (file != null) {
                // System.out.println(file.getAbsolutePath());
                // openFile(file);
                final ImageView imageView = loadImage(file); // Image geladen
                root.getChildren().add(imageView);
                saveImage(imageView); // Image gespeichert werden
            }
        });

        // Mehrere Dateien
        final Button button2 = new Button("Mehrere Dateien wählen");
        button2.setOnAction(event -> {
            setupFilter(fileChooser);
            final List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);

            if (list != null) {
                for (final File file : list) {
                    // System.out.println(file.getPath());
                    openFile(file);
                }
            }
        });

        // Elemente hinzufügen
        root.getChildren().addAll(button, button2);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Methode zum öffnen von beliebigen Dateien
    private void openFile(final File file) {
        try {
            desktop.open(file);
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Filtern einbauen
    private void setupFilter(final FileChooser fileChooser) {
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
    }

    // Methode - Bild in das Programm laden
    private ImageView loadImage(final File file) {
        final Image image = new Image(file.toURI().toString());
        final ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        return imageView;
    }

    // Methode - Speichern von Dateien / Bildern
    private void saveImage(final ImageView imageView) {
        final Stage secondStage = new Stage();
        // ContextMenü erstellen
        final ContextMenu contextMenu = new ContextMenu();

        // Menü Unterpunkte
        final MenuItem item1 = new MenuItem("Speichern");
        final MenuItem item2 = new MenuItem("Kopieren",
                new ImageView(new Image(getClass().getResourceAsStream("Images/ok.png"))));

        // ContextMenü anzeigen
        contextMenu.getItems().addAll(item1, item2);

        imageView.setOnContextMenuRequested(
                event -> contextMenu.show(imageView, event.getScreenX(), event.getScreenY()));

        // Menüpunkt klickbar machen
        item1.setOnAction(event -> {
            final FileChooser fileChooser = new FileChooser();
            final File file = fileChooser.showSaveDialog(secondStage);

            if (file != null) {
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(imageView.getImage(), null), "png", file); // Bild
                                                                                                      // speichern
                } catch (final IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });

    }

    public static void main(final String[] args) {
        // Locale.setDefault(Locale.GERMAN);
        launch(args);
    }
}
