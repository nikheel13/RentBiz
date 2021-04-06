package RentBiz;

import javafx.beans.property.SimpleStringProperty;



public class DVD {

    private SimpleStringProperty title,releaseDate,type,genre;



    public DVD( String title,String releaseDate, String type, String genre) {

        this.title = new SimpleStringProperty(title);
        this.releaseDate = new SimpleStringProperty (releaseDate);
        this.type = new SimpleStringProperty (type);
        this.genre = new SimpleStringProperty(genre);
    }



    public String getTitle() {
        return title.get();
    }


    public void setTitle(String title) {

        this.title = new SimpleStringProperty(title);

    }

    public String getReleaseDate() {
        return releaseDate.get();
    }


    public void setReleaseDate(String releaseDate) {

        this.releaseDate = new SimpleStringProperty(releaseDate);

    }

    public String getType() {

        return type.get();

    }

    public void setType(String type) {

        this.type = new SimpleStringProperty(type);

    }

    public String getGenre() {

        return genre.get();

    }

    public void setGenre(String genre) {

        this.genre = new SimpleStringProperty(genre);

    }
}