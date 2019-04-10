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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rajiv
 */
public class DeleteWindowController implements Initializable {

    @FXML
    private Button acptBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfQuantity;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextField tfAvailability;
    @FXML
    private TextField tfSection;
    private FXMLDocumentController doc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        deleteSelected();
        
    }    

    @FXML
    private void acptBtnHandler(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelBtnHandler(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void setAdd(FXMLDocumentController aThis) {
    }
    public void deleteSelected(){
    Crop selectedCrop = doc.tableView.getSelectionModel().getSelectedItem();
        tfName.setText(selectedCrop.getItemName());
        tfType.setText((selectedCrop.getItemQuantity().toString()));
        tfQuantity.setText(selectedCrop.getItemType());
        tfPrice.setText((selectedCrop.getPricePerPound().toString()));
        tfSection.setText((selectedCrop.getFieldSection()));
        tfID.setText((selectedCrop.getItemId().toString()));
    }
    
}
