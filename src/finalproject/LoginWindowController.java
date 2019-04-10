/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rajiv
 */
public class LoginWindowController implements Initializable {

    @FXML
    private Button adminBtn;
    @FXML
    private Button userBtn;
    @FXML
    private FXMLDocumentController FXMLDoc;
    
    Label name = new Label();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FXMLDoc = FXMLDocumentController.getController();
    }    

    @FXML
    private void adminBtnHandler(ActionEvent event) throws IOException {
        //FXMLDoc.setType("Admin: ");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Agricultural Stock Management");
        stage.show();
        FXMLDoc = loader.getController();
        FXMLDoc.setAdd(this);
        adminBtn.setDisable(true);
        stage.setOnCloseRequest(e -> {
         adminBtn.setDisable(false); 
           
        });
        FXMLDoc.setName("Administrator");
        FXMLDoc.setType("Admin: ");
    }

    @FXML
    private void userBtnHandler(ActionEvent event) throws IOException {
        boolean validInput = false;
        //FXMLDoc.setType("User: ");
        //FXMLDoc.setName("User");
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter a Username");
        dialog.setHeaderText("Your username must be a maximum of 12 characters.");
        dialog.setContentText("Please enter a username: ");
        dialog.showAndWait();
        String result = dialog.getResult();
        if(result.length() < 13){
            validInput = true;
        }else if(result.isEmpty() == true){
            validInput = true;
        }else{
            validInput = false;
        }

        
        if(validInput == true){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Agricultural Stock Management");
            stage.show();
            FXMLDoc = loader.getController();
            FXMLDoc.setAdd(this);
            userBtn.setDisable(true);
            stage.setOnCloseRequest(e -> {
             userBtn.setDisable(false);     
            });
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR); 
            alert.setTitle("Error logging in");
            alert.setHeaderText("You entered an invalid username!");
            alert.setContentText("Please enter a valid username!(Maximum 12 characters)"); 
            alert.showAndWait();
        }
        FXMLDoc.setName(dialog.getResult());
        FXMLDoc.setType("User:");
    }
    
}
