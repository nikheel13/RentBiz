package RentBiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class Controller implements Initializable {


    public void changeScreenButtonPushed(ActionEvent event) throws IOException{

        Parent clientSceneParent = FXMLLoader.load(getClass().getResource("ClientView.fxml"));
        Scene clientScene = new Scene(clientSceneParent);

        //To get the Stage info

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(clientScene);
        window.show();


    }

    public void changeToDVDViewButtonPushed(ActionEvent event) throws IOException{

        Parent dvdSceneParent = FXMLLoader.load(getClass().getResource("DVDView.fxml"));
        Scene dvdScene = new Scene(dvdSceneParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(dvdScene);
        window.show();
    }

    public void changeToRentViewButtonPushed(ActionEvent event) throws IOException{

        Parent rentSceneParent = FXMLLoader.load(getClass().getResource("RentView.fxml"));
        Scene rentScene = new Scene(rentSceneParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(rentScene);
        window.show();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
