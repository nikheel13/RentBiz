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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RentController implements Initializable {

    @FXML
    private TableView<Rent> tableView;
    @FXML
    private TableColumn<Rent, String> nameColumn;
    @FXML
    private TableColumn<Rent, String> titleColumn;

    @FXML
    private TableColumn<Rent, String> statusColumn;
    @FXML
    private TableColumn<Rent, String> typeColumn;


    @FXML
    private TextField nameTextField;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField statusTextField;
    @FXML
    private TextField typeTextField;




    public void homeScreenButtonPushed(ActionEvent event) throws IOException {

        Parent rentSceneParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene rentScene = new Scene(rentSceneParent);

        //To get the Stage info

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(rentScene);
        window.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("name"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("title"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("status"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("type"));


        //load dummy data
        tableView.setItems(getInformation());


    }


    //Renting DVD

    public void newRentalButtonPushed(){

        Rent newRental = new Rent(nameTextField.getText(),
                                titleTextField.getText(),
                                statusTextField.getText(),
                                typeTextField.getText());



        tableView.getItems().add(newRental);

        clearForm();
    }

    private void clearForm() {

        nameTextField.clear();
        titleTextField.clear();
        statusTextField.clear();
        typeTextField.clear();

    }

    public ObservableList<Rent> getInformation() {

        ObservableList<Rent> information = FXCollections.observableArrayList();

        information.add(new Rent("Richard Hendricks", "Get Hard", "Rented","Movie"));
        information.add(new Rent("Gavin Belson", "Sillicon Valley(Season 3)", "Returned", "Series"));
        information.add(new Rent("Harry Potter", "Mission Impossible", "Rented","Movie"));


        return information;
    }

}
