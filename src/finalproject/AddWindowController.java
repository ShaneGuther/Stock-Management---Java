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
    @FXML
    private FXMLDocumentController doc = new FXMLDocumentController();
    
    FileManagement manager = new FileManagement();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //doc.cropList.get(doc.cropList.size()).setItemId(doc.cropList.size());
        //tfID.setText(doc.cropList.get(doc.cropList.size()).toString());
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
        tfName.setText(""); 
        tfType.setText("");
        tfQuantity.setText("");
        tfPrice.setText("");
        tfSection.setText("");
        
        }
        doc.showData();
    }

    @FXML
    private void cancelBtnHandler(ActionEvent event) {
    }
    
    @FXML
    void setAdd(FXMLDocumentController aThis) {
        
    }
    
}
