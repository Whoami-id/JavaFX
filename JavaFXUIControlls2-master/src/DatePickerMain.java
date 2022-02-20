
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class DatePickerMain extends Application {

    // Variablen
    // yyyy -> 2018
    // yy -> 18
    // MM -> 04
    // M -> 4
    // dd -> 02
    // d -> 2
    private final String pattern = "yyyy-MM-dd";

    @Override
    public void start(final Stage primaryStage) throws Exception {

        // Scene / root
        final FlowPane root = new FlowPane();
        final Scene scene = new Scene(root, 800, 500);
        root.setPadding(new Insets(10));
        root.setHgap(20);

        // DatePicker erstellen
        final DatePicker datePicker = new DatePicker();
        // datePicker.setValue(LocalDate.of(2018, 4, 20)); // Anfangsdatum setzen
        datePicker.setShowWeekNumbers(true); // Wochennummer an / aus

        // Methoden
        // datePicker.setValue(LocalDate.MIN);
        // datePicker.setValue(LocalDate.MAX);
        // datePicker.setValue(LocalDate.now()); // Aktuelles Datum

        // Datum formatieren

        /*
         * yyyy = Jahr vierstellig z.B. 2018
         * yy = Jahr zweistellig z.B. 18
         * MM = Monat zweistellig z.B. 02
         * M = Monat einstellig z.B. 2
         * dd = Tag im Monat zB. 22
         */

        final StringConverter<LocalDate> converter = new StringConverter<>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(final LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(final String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };

        datePicker.setConverter(converter);

        root.getChildren().addAll(datePicker);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        Locale.setDefault(Locale.GERMAN);
        launch(args);
    }

}
