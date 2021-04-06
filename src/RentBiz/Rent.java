package RentBiz;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Rent {

    private SimpleStringProperty name, title, status,type;



    public Rent(String name, String title, String status, String type) {


        this.name = new SimpleStringProperty(name);
        this.title = new SimpleStringProperty(title);
        this.status = new SimpleStringProperty(status);
        this.type = new SimpleStringProperty(type);

    }


    public String getTitle() {
        return title.get();
    }


    public void setTitle(String title) {

        this.title = new SimpleStringProperty(title);

    }

    public String getName() {
        return name.get();
    }


    public void setName(String name) {

        this.name = new SimpleStringProperty(name);

    }

    public String getStatus() {
        return status.get();
    }


    public void setStatus(String status) {

        this.status = new SimpleStringProperty(status);

    }

    public String getType() {
        return type.get();
    }


    public void setType(String type) {

        this.type = new SimpleStringProperty(type);

    }



}

