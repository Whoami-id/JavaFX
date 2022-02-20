
package application;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    private final SimpleStringProperty userName;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;

    public Person(final String uName, final String fName, final String lName, final String email) {
        this.userName = new SimpleStringProperty(uName);
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(final String fName) {
        firstName.set(fName);
    }

    public void setUserName(final String uName) {
        firstName.set(uName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(final String fName) {
        lastName.set(fName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(final String fName) {
        email.set(fName);
    }

    public String getUserName() {
        return userName.get();
    }

}
