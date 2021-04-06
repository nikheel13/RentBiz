package RentBiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class ClientViewController implements Initializable {

    //configure the Table

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> addressColumn;
    @FXML
    private TableColumn<Person, String> phoneColumn;
    @FXML
    private TableColumn<Person, String> emailColumn;


    //These are used to create new persons

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextfield;



    //This will allow to double click and edit

    public void changeNameCellEvent(TableColumn.CellEditEvent edittedCell){

        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setName(edittedCell.getNewValue().toString());

    }

    public void changeAddressCellEvent(TableColumn.CellEditEvent edittedCell){

        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setAddress(edittedCell.getNewValue().toString());

    }

    public void changePhoneCellEvent(TableColumn.CellEditEvent edittedCell){

        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setPhone(edittedCell.getNewValue().toString());

    }

    public void changeEmailCellEvent(TableColumn.CellEditEvent edittedCell){

        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setEmail(edittedCell.getNewValue().toString());

    }


    public void changeScreenButtonPushed(ActionEvent event) throws IOException {

        Parent clientSceneParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene clientScene = new Scene(clientSceneParent);

        //To get the Stage info

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(clientScene);
        window.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Set up the columns in the table

        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

        //load dummy data
        tableView.setItems(getPeople());

        //update table

        tableView.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        // This will allow the delete function.

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    // This method will delete the person

    public void deleteButtonPushed(){

        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();

        // This gives us the selected rows

        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for(Person person : selectedRows){
            allPeople.remove(person);
        }
    }



    // Adding new people

    public void newPersonButtonPushed(){

        Person newPerson = new Person(nameTextField.getText(),
                                      addressTextField.getText(),
                                      phoneTextField.getText(),
                                      emailTextfield.getText());


        //Get all the items and then add the new one.

        tableView.getItems().add(newPerson);

        clearForm();
    }

    private void clearForm() {

        nameTextField.clear();
        addressTextField.clear();
        phoneTextField.clear();
        emailTextfield.clear();
    }


    public ObservableList<Person> getPeople() {

        ObservableList<Person> people = FXCollections.observableArrayList();

        people.add(new Person("Richard Hendricks", "SlutWay st", "998-009-5454", "Rh@gmail.com"));
        people.add(new Person("Gavin Belson", "DickWay st", "998-009-0054", "gb@gmail.com"));
        people.add(new Person("Harry Potter", "OneWay st", "000-009-5454", "hp@gmail.com"));



        return people;

    }

}




