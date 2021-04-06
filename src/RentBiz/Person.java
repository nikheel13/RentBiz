package RentBiz;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.lang.String;



public class Person {

    private SimpleStringProperty name,address,phone,email;


    public Person( String name, String address, String phone, String email) {

        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty (address);
        this.phone = new SimpleStringProperty (phone);
        this.email = new SimpleStringProperty (email);
    }



    public String getName() {
        return name.get();
    }


    public void setName(String name) {

        this.name = new SimpleStringProperty(name);

    }

    public String getAddress() {
        return address.get();
    }


    public void setAddress(String address) {

        this.address = new SimpleStringProperty(address);

    }

    public String getPhone() {

        return phone.get();

    }

    public void setPhone(String phone) {

        this.phone = new SimpleStringProperty(phone);

    }

    public String getEmail() {

        return email.get();

    }

    public void setEmail(String email) {

        this.email = new SimpleStringProperty(email);

    }
}