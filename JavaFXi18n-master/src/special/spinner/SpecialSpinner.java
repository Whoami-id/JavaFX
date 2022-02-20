
package special.spinner;

/**
*
* @author Eduard Gabriel Frinculeasa
*
*     That class create a special spinner
*
*/
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class SpecialSpinner {
    // Members
    private final TextField textField = new TextField("0");
    boolean isSmaller = false;
    private final int max;

    /**
     * Constructor.
     *
     * @param max Set the max limit of Special Spinner
     */

    public SpecialSpinner(final int max) {
        this.max = max;
    }

    /**
     * Function witch create a Special Spinner
     *
     * @return It return a GridPane
     */
    public GridPane createSpecialSpinner() {
        final Button up = new Button("\u25B4"); // Create a Up Button
        final Button down = new Button("\u25BE");// Create a down Button

        // Create a Horizontal Box
        final HBox arrows = new HBox();
        arrows.getChildren().addAll(up, down); // Add the buttons up and down

        // Create a GridPane
        final GridPane mySpinner = new GridPane();
        mySpinner.add(textField, 0, 0); // Add the textField at the position 0,0
        mySpinner.add(arrows, 1, 0);// Add the arrows at the position 1,0

        // Add a listener for the textField
        textField.textProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) { // Are allowed just numbers
                textField.setText(newValue.replaceAll("[^\\d]", "")); // If you try to write something else then it will
                                                                      // not allow it
            }
            if (textField.getText().equals("")) { // It not allows to you to have a empty String in the textField
                textField.setText("0"); // If the string is empty it will put a 0 automatical
            }
            checkIfBiggerThanLimit();// Check if the value is bigger than max
        });
        // Action when do you click on the UP button
        up.setOnAction(event -> {
            try {
                final int actualValue = Integer.parseInt(textField.getText());// actualValue will be the contet from
                                                                              // textField convertet as integer
                if (actualValue >= max) { // If it is bigger than maximal value allowed
                    textField.setText("0"); // Set text 0

                } else {
                    final int newValue = Math.abs(actualValue) + 1; // actualValue + 1
                    textField.setText("" + newValue); // newValue will be visible in the TextField
                }
            } catch (final NumberFormatException e) { // Catch NumberFormatException
                textField.setText("0"); // Set text 0
            }

        });
        // Action when do you click on the DOWN button
        down.setOnAction(event -> {
            try {
                final int actualValue = Integer.parseInt(textField.getText());// actualValue will be the contet from
                                                                              // textField convertet as integer
                if (actualValue > max) {// if actualValue is bigger than max
                    textField.setText("" + max); // Set Text max value
                }
                if (actualValue <= 0) {// if actualValue is smaller or equals with 0
                    textField.setText("" + max); // Set Text max value

                } else {
                    final int newValue = Math.abs(actualValue) - 1; // actualValue - 1
                    textField.setText("" + newValue);// newValue will be visible in the TextField

                }
            } catch (final NumberFormatException e) {// Catch NumberFormatException
                textField.setText("0"); // Set text 0
            }
        });

        return mySpinner; // Return GridPane
    }

    /**
     * Function to set inside the Spinner numbers
     *
     * @param time It is the function witch will be used on UpdateStock to write inside the spinner the actual time
     */
    public void setInsideNumber(final int time) {
        textField.setText("" + time);// Set text time
    }

    /**
     * Function to set the size of spinner
     *
     * @param width Set width
     * @param height Set height
     */
    public void setSize(final int width, final int height) {
        textField.setPrefSize(width, height); // Set Pref size
    }

    /**
     * Function for reseting the spinner to the value 0
     */
    public void setReset() {
        textField.setText("0");// Set Text 0
    }

    /**
     * Function for getting the value inside the spinner
     *
     * @return Return value inside the spinner
     */
    public int getValue() {
        return Integer.parseInt(textField.getText()); // return the content from textField as integer
    }

    /**
     * Function witch check if the number is bigger than limit and if it is then re-write it as max limit
     */
    public void checkIfBiggerThanLimit() {
        if (Integer.parseInt(textField.getText()) > max) {// check if the contet from textfield is bigger than limit
            textField.setText("" + max); // Set text max

        }

    }

}
