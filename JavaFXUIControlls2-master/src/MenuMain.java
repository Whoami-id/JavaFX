
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuMain extends Application {

    // Variablen
    private final Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final FlowPane root = new FlowPane();
        final Scene scene = new Scene(root, 800, 500);
        root.setPadding(new Insets(10));
        root.setHgap(20);

        // Ein Menü besteht aus drei Teilen -> MenuBar -> Menu -> MenuItmes
        // 1. MenüBar erstellen
        final MenuBar menuBar = new MenuBar();

        // 2. Menü erstellen
        final Menu menu = new Menu("Datei");
        final Menu menu2 = new Menu("Bearbeiten");

        // 3. MenüItem zum Menü hinzufügen
        final MenuItem item1 = new MenuItem("Öffnen");
        final MenuItem item2 = new MenuItem("Speichern");
        final MenuItem item3 = new MenuItem("Speichern unter");
        final MenuItem item4 = new MenuItem("Laden");
        final MenuItem item5 = new MenuItem("Exit");

        final MenuItem item6 = new MenuItem("Bearbeiten");
        final MenuItem item7 = new MenuItem("Rückgänig");
        final MenuItem item8 = new MenuItem("Kopieren");
        final MenuItem item9 = new MenuItem("Einfügen");

        menu.getItems().addAll(item1, item2, new SeparatorMenuItem(), item5);
        menu2.getItems().addAll(item6, item7, item8, item9);

        menuBar.getMenus().addAll(menu, menu2);

        // MenüItem Aktion ausführen
        item5.setOnAction(event -> Platform.exit());

        item1.setOnAction(event -> {
            final FileChooser fileChooser = new FileChooser();
            final File file = fileChooser.showOpenDialog(primaryStage);

            if (file != null) {
                openFile(file);
            }

        });

        // Elemente hinzufügen
        root.getChildren().addAll(menuBar);

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

    public static void main(final String[] args) {
        // Locale.setDefault(Locale.GERMAN);
        launch(args);
    }
}
