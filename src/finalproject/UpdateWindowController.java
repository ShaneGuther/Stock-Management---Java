/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rajiv
 */
public class UpdateWindowController implements Initializable {
    
    //private FXMLDocumentController doc = new FXMLDocumentController();

    @FXML
    private TextField tfID;
    @FXML
    private Button acptBtn;
    @FXML
    private Button cancelBtn;
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
    private TextField tfFieldSection;
      FileManagement manager = new FileManagement();
    private static FXMLDocumentController FXMLDoc;
    private static UpdateWindowController updDoc;
    private ObservableList<Crop> list;
      FXMLLoader loader = new FXMLLoader();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLDoc = FXMLDocumentController.getController();
    }    
     public void setData(ObservableList<Crop> list){ 
        this.list = list;
    }

    @FXML
    private void acptBtnHandler(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
        Crop temp = list.get(Integer.parseInt(tfID.getText()));
        Integer i = Integer.parseInt(tfID.getText());
        manager.itemUpdating(list, temp.getItemType(), temp.getItemName(), 
                temp.getItemQuantity(), temp.getPricePerPound(), temp.getFieldSection());
    }

    @FXML
    private void cancelBtnHandler(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void setAdd(FXMLDocumentController aThis) {
        
    }
    
}
