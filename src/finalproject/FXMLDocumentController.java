/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

/**
 *
 * @author Rajiv, Shane, Patrick
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button addBtn;
    @FXML
    private Button updBtn;
    @FXML
    private TableColumn<?, ?> pricePerPound;
    @FXML
    private TableColumn<?, ?> fieldSection;
    @FXML
    private TableColumn<?, ?> itemID;
    @FXML
    private TableColumn<?, ?> itemName;
    @FXML
    private Label loginType;
    @FXML
    private Label loginName;
    @FXML
    private Button delBtn;
    @FXML
    private TableColumn<?, ?> itemType;
    @FXML
    private TableColumn<?, ?> itemQuantity;
    @FXML
    private TableColumn<?, ?> itemAvailability;
    @FXML
    public ArrayList<Crop> cropList = new ArrayList<>();
    @FXML
    private AddWindowController add;
    @FXML
    private DeleteWindowController delete;
    @FXML
    private UpdateWindowController update;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBtnHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddWindow.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Window Controller");
        stage.show();
        add = loader.getController();
        add.setAdd(this);
        addBtn.setDisable(true);
        
        stage.setOnCloseRequest(e -> {
           addBtn.setDisable(false); 
        });
        
    }


    @FXML
    private void updBtnHandler(ActionEvent event) {
    }

    @FXML
    private void delBtnHandler(ActionEvent event) {
    }
    
}
