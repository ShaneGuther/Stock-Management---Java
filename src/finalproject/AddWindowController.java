/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class AddWindowController implements Initializable {

    @FXML
    private Button acptBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField tfID;
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
    private FXMLDocumentController doc = new FXMLDocumentController();
    
    FileManagement manager = new FileManagement();
    String[] cbArray = {"Root", "Fruits", "Vine", "Plant", "Stems", "Beans", "Leaves"};
    @FXML
    private ComboBox<String> cbName;
    //cbName.getItems().addAll(cbArray);
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //doc.list.get(doc.list.size()).setItemId(doc.list.size());
        //tfID.setText(doc.list.get(doc.list.size()).toString());
        
    }    

    @FXML
    private void acptBtnHandler(ActionEvent event) {
        try{
    manager.fileWriting(doc.list, tfName.getText(), tfType.getText(), 
            Integer.parseInt(tfQuantity.getText()), Double.parseDouble(tfPrice.getText()), 
            tfSection.getText());
    }catch(Exception e){
        System.out.println("Error Occurred" + e);
    }finally{
        tfID.setText("");
        tfName.setText(""); 
        tfType.setText("");
        tfQuantity.setText("");
        tfPrice.setText("");
        tfSection.setText("");
        
        }
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelBtnHandler(ActionEvent event) {
       
    }
    
    void setAdd(FXMLDocumentController aThis) {
        
    }
    
}
