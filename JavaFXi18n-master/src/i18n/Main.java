
package i18n;

import java.util.List;
import java.util.Locale;

import javafx.application.Application;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
    private final I18nUISupport i18nui = I18nUISupport.getInstance();

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        /**
         * Changes the languages.
         */
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.isMetaDown()
                    && (event.getText().equals("L") || event.isShiftDown() && event.getText().equalsIgnoreCase("l"))) {
                final I18nSupport i18n = i18nui.i18n();
                final List<Locale> locales = i18n.getSupportedLocales();
                final int idxCur = locales.indexOf(i18n.getLocale());
                if (idxCur == -1) {
                    return;
                }
                final int idxNext = (idxCur + 1) % locales.size();
                i18n.setLocale(locales.get(idxNext));
            }
        });

        // final Button buttonStocktaking = i18nui.newButton("stock_taking");

    }

}
