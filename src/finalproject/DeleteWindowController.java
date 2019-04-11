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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    ObservableList<Crop> list;
    Crop c;
    FXMLLoader loader = new FXMLLoader();
    @FXML
    private static FXMLDocumentController FXMLDoc;
    private static DeleteWindowController delCon;
    
        
 
    public void setData(ObservableList<Crop> list){ 
        this.list = list;
    }
    public void setCrops(Crop c){
        this.c = c;
    }
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    FXMLDoc = FXMLDocumentController.getController();
    tfName.setText(c.getItemName());
    
    }    

    @FXML
    private void acptBtnHandler(ActionEvent event) {
       // FXMLDoc = loader.getController();
//        FXMLDoc.setAdd(this);
//        Stage stage = (Stage) cancelBtn.getScene().getWindow();
//        stage.close();
          manager.itemDeleting(list, Integer.parseInt(tfID.getText()));
//        System.out.println(list);
          //FXMLDoc = loader.getController();
          //list.remove(list.get(Integer.parseInt(tfID.getText())));
          //FXMLDoc.resetList(list);
    }
    public ObservableList getData(){
        return list;
    }
    @FXML
    private void cancelBtnHandler(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
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
    public static DeleteWindowController getControllerTwo(){
        return delCon;
    }
    void setAdd(FXMLDocumentController aThis){
        
    }
    }
