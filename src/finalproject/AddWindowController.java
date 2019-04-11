/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rajiv
 */
public class AddWindowController implements Initializable {

    @FXML
    private Button acptBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfName;
    private TextField tfType;
    @FXML
    private TextField tfQuantity;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextField tfAvailability;
    @FXML
    private TextField tfSection;
    
    private static FXMLDocumentController FXMLDoc;
    private static AddWindowController addCon;
    ObservableList<Crop> list;
    Crop selected;
    FileManagement manager = new FileManagement();
    
    String[] cbArray = {"Root", "Fruits", "Vine", "Plant", "Stems", "Beans", "Leaves"};
    @FXML
    private ComboBox<String> cbType;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FXMLDoc = FXMLDocumentController.getController();
        //doc.list.get(doc.list.size()).setItemId(doc.list.size());
        //tfID.setText(doc.list.get(doc.list.size()).toString());
        cbType.getItems().addAll(cbArray);
        cbType.setValue("Corn");
    }    
    public void setData(ObservableList<Crop> list){ 
       this.list = list;
    }
    @FXML
    private void acptBtnHandler(ActionEvent event) {
       
            
    manager.fileWriting(list, cbType.getValue(), tfName.getText(),
            Integer.parseInt(tfQuantity.getText()), Double.parseDouble(tfPrice.getText()), 
            tfSection.getText());
   
      
    
        tfID.setText("");
       
        tfName.setText("");
        tfQuantity.setText("");
        tfPrice.setText("");
        tfSection.setText("");
        
        
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelBtnHandler(ActionEvent event) {
        
    }
    
    @FXML
    void setAdd(FXMLDocumentController aThis) {
        
    }
     public static AddWindowController getControllerThree(){
        
        return addCon;
    }
    
}
