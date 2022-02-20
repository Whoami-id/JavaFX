import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PropertyMain {

    public static void main(final String... strings) {
        final IntegerProperty age = new SimpleIntegerProperty();
        age.set(32);
        System.out.println(age.get());

        age.addListener((observable, oldValue, newValue) -> {
            System.out.println("Age has changed");
            System.out.println("Age: " + oldValue + " new Age " + newValue);

        });

        age.set(40);
        age.set(300);
    }

}
