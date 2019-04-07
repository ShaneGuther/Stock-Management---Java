/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

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
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBtnHandler(ActionEvent event) {
    }


    @FXML
    private void updBtnHandler(ActionEvent event) {
    }

    @FXML
    private void delBtnHandler(ActionEvent event) {
    }
    
}
