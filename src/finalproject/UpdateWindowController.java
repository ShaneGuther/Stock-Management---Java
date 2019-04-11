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
import javafx.scene.control.ComboBox;
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
    private TextField tfQuantity;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextField tfFieldSection;
      FileManagement manager = new FileManagement();
    private static FXMLDocumentController FXMLDoc;
    private static UpdateWindowController updDoc;
    private ObservableList<Crop> list;
      FXMLLoader loader = new FXMLLoader();
    
     String[] cbArray = {"Root", "Fruits", "Plant", "Stems", "Legumes", "Leaves", "Grain", "Other"};
     @FXML
    private ComboBox<String> cbType;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLDoc = FXMLDocumentController.getController();
        cbType.getItems().addAll(cbArray);
        cbType.setValue("Root");
    }    
     public void setData(ObservableList<Crop> list){ 
        this.list = list;
    }

    @FXML
    private void acptBtnHandler(ActionEvent event) {
        Crop c = new Crop(Integer.parseInt(tfID.getText()), cbType.getValue(), tfName.getText(), Integer.parseInt(tfQuantity.getText()), 
                Double.parseDouble(tfPrice.getText()), 
                tfFieldSection.getText());
        manager.itemUpdating(list, c, Integer.parseInt(tfID.getText()), cbType.getValue(), tfName.getText(), Integer.parseInt(tfQuantity.getText()), 
                Double.parseDouble(tfPrice.getText()), 
                tfFieldSection.getText());
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void cancelBtnHandler(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }   
    
    void setAdd(FXMLDocumentController aThis) {
        
    }
    
}
