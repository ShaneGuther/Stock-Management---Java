/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import finalproject.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
    
    FileManagement manager = new FileManagement();
    
    
    FXMLLoader loader = new FXMLLoader();
    @FXML
    FXMLDocumentController doc = new FXMLDocumentController();
    
        
 
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       try {
//              root =(Parent) loader.load();
//            loader.setLocation(getClass().getResource("fxmldocument.fxml"));
//        } catch (IOException ex) {
//            Logger.getLogger(DeleteWindowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    

    @FXML
    private void acptBtnHandler(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
        manager.itemDeleting(doc.getList(), Integer.parseInt(tfID.getText()));
    }
     
    @FXML
    private void cancelBtnHandler(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void setAdd(FXMLDocumentController aThis)throws IOException {
    }
//    public void deleteSelected(){
//        try{
////            
////            rootLayout = loader.load( getClass().getResource( "BorderPane.fxml").openStream());
////            BorderPaneController bpc = (BorderPaneController) loader.getController();
//        FXMLLoader loader = new FXMLLoader();
//        Parent root = loader.load(getClass().getResource("../FXMLDocument.fxml").openStream());
//        FXMLDocumentController dac = (FXMLDocumentController) loader.getController();
//        Crop selectedCrop = dac.tableView.getSelectionModel().getSelectedItem();
//        tfName.setText(selectedCrop.getItemName());
//        tfType.setText((selectedCrop.getItemQuantity().toString()));
//        tfQuantity.setText(selectedCrop.getItemType());
//        tfPrice.setText((selectedCrop.getPricePerPound().toString()));
//        tfSection.setText((selectedCrop.getFieldSection()));
//        tfID.setText((selectedCrop.getItemId().toString()));
//        }catch(IOException e){
//            System.out.println("error" + e);
//        }
//    }
    
}
