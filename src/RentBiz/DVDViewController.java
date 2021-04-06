package RentBiz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DVDViewController implements Initializable {

    //configure the Table

    @FXML
    private TableView<DVD> tableView;
    @FXML
    private TableColumn<DVD, String> titleColumn;
    @FXML
    private TableColumn<DVD, String> releaseDateColumn;
    @FXML
    private TableColumn<DVD, String> typeColumn;
    @FXML
    private TableColumn<DVD, String> genreColumn;


    //These are used to create new persons

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField releaseDateTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private TextField genreTextfield;


    //This will allow to double click and edit

    public void changeTitleCellEvent(TableColumn.CellEditEvent edittedCell){

        DVD dvdSelected = tableView.getSelectionModel().getSelectedItem();
        dvdSelected.setTitle(edittedCell.getNewValue().toString());

    }

    public void changeReleaseDateCellEvent(TableColumn.CellEditEvent edittedCell){

        DVD dvdSelected = tableView.getSelectionModel().getSelectedItem();
        dvdSelected.setReleaseDate(edittedCell.getNewValue().toString());

    }

    public void changeTypeCellEvent(TableColumn.CellEditEvent edittedCell){

        DVD dvdSelected = tableView.getSelectionModel().getSelectedItem();
        dvdSelected.setType(edittedCell.getNewValue().toString());

    }

    public void changeGenreCellEvent(TableColumn.CellEditEvent edittedCell){

        DVD dvdSelected = tableView.getSelectionModel().getSelectedItem();
        dvdSelected.setGenre(edittedCell.getNewValue().toString());

    }



    public void homeScreenButtonPushed(ActionEvent event) throws IOException {

        Parent dvdSceneParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene dvdScene = new Scene(dvdSceneParent);

        //To get the Stage info

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(dvdScene);
        window.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Set up the columns in the table

        titleColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("title"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("releaseDate"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("type"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("genre"));

        //load dummy data
        tableView.setItems(getDvds());


        //update table

        tableView.setEditable(true);
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        releaseDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        genreColumn.setCellFactory(TextFieldTableCell.forTableColumn());



    }


    // This method will delete the person

    public void deleteDvdButtonPushed(){

        ObservableList<DVD> selectedRows, allDvd;
        allDvd = tableView.getItems();

        // This gives us the selected rows

        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for(DVD dvd : selectedRows){
            allDvd.remove(dvd);
        }
    }

    // Adding new people

    public void newDVDButtonPushed(){

        DVD newDvd = new DVD(titleTextField.getText(),
                             releaseDateTextField.getText(),
                             typeTextField.getText(),
                             genreTextfield.getText());


        //Get all the items and then add the new one.

        tableView.getItems().add(newDvd);

        clearForm();
    }

    private void clearForm() {

        titleTextField.clear();
        releaseDateTextField.clear();
        typeTextField.clear();
        genreTextfield.clear();
    }

    public ObservableList<DVD> getDvds() {

        ObservableList<DVD> dvds = FXCollections.observableArrayList();

        dvds.add(new DVD("Mission Impossible", "08/24/2004", "Movie", "Action Thriller"));
        dvds.add(new DVD("Game of Thrones (Season 10)", "09/02/2002", "Series", "Drama"));
        dvds.add(new DVD("Get Hard", "12/14/2015", "Movie", "Comedy"));


        return dvds;
    }
}