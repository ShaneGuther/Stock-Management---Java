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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private FXMLDocumentController doc = new FXMLDocumentController();
    @FXML
    private AnchorPane deleteWindow;
    
    private ObservableList<Crop> list;
    FileManagement file = new FileManagement();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    public void setData(ObservableList list){
        this.list = list;
    }
    public ObservableList getData(){
        return list;
    }
    @FXML
    private ObservableList acptBtnHandler(ActionEvent event) {
        
        return file.itemDeleting(doc.getData(), 1);
        
    }

    @FXML
    private void cancelBtnHandler(ActionEvent event) {
    }
    
    void setAdd(FXMLDocumentController aThis) {
        
    }
    
}
