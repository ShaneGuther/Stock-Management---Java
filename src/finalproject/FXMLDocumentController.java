/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private TableColumn<Integer, Integer> itemID;
    @FXML
    private TableColumn<Crop, String> itemName;
    @FXML
    private TableColumn<Crop, String> itemType;
    @FXML
    private TableColumn<Crop, Integer> itemQuantity;
    @FXML
    private TableColumn<Crop, Double> pricePerPound;
    @FXML
    private TableColumn<Crop, String> fieldSection;
    @FXML
    private Label loginType;
    @FXML
    private Label loginName;
    @FXML
    private Button delBtn;
    @FXML
    TableView<Crop> tableView;
    //private TableColumn<Crop, Boolean> itemAvailability;
    private static FXMLDocumentController controller;
    FileManagement manager = new FileManagement();
    
    ObservableList<Crop> list = FXCollections.observableArrayList();
    //new Crop("corn","wheat",1,2.2,'g')
    private AddWindowController add;
    private DeleteWindowController delete;
    private UpdateWindowController update;
    @FXML
    private Text sideName;
    @FXML
    private Text sideType;
    @FXML
    private Text sideQuantity;
    @FXML
    private Text sidePrice;
    @FXML
    private Text sideFieldSection;
    @FXML
    private Text sideID;
    
    FXMLLoader loader = new FXMLLoader();
    DeleteWindowController del;

    
    
    
    
 

//    public FXMLDocumentController(TableView t) {
//        tableView = t;
//    }
 
  
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showData();
       onEdit();
       //list.setAdd();
    }    
    public void setList(ObservableList list){
        this.list = list;
    }
    public ObservableList getList(){
        return list;
    }
    @FXML
    private void addBtnHandler(ActionEvent event) throws IOException {
        tableView.setItems(list);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddWindow.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Window Controller");
        stage.show();
        add = loader.getController();
        add.setAdd(this);
        addBtn.setDisable(true);
//        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
//        itemType.setCellValueFactory(new PropertyValueFactory<>("itemType"));
//        pricePerPound.setCellValueFactory(new PropertyValueFactory<>("pricePerPound"));
//        itemQuantity.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
//        fieldSection.setCellValueFactory(new PropertyValueFactory<>("fieldSection"));
//        list.add(new Crop("tomato", "plant", 10, 1.2, "h"));
        
//        tableView.setItems(list);
//        System.out.println(list);
        

       
        

       
          // tableView.getColumns().addAll(itemType, itemQuantity, pricePerPound, fieldSection);
//        //this.itemName.setCellValueFactory(cellData -> cellData.getValue().String());
//        this.itemName.setCellValueFactory(new PropertyValueFactory<Crop, String>("name"));
//        this.itemType.setCellValueFactory(cellData -> cellData.getValue().keyProperty());
//        this.itemQuantity.setCellValueFactory(cellData -> cellData.getValue().valueProperty());
        stage.setOnCloseRequest(e -> {
        addBtn.setDisable(false); 
        showData();
        });
      
        stage.setOnHidden(e -> {
        addBtn.setDisable(false); 
        showData();
            
        });
       
        
    }


    @FXML
    private void updBtnHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UpdateWindow.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Update Window Controller");
        stage.show();
        update = loader.getController();
        update.setAdd(this);
        updBtn.setDisable(true);
        
        stage.setOnCloseRequest(e -> {
        updBtn.setDisable(false); 
        showData();
        });
        stage.setOnHidden(e -> {
        updBtn.setDisable(false); 
        showData();
            
        });
    }
    
    void setAdd(FXMLDocumentController aThis){
        
    }

    @FXML
    private void delBtnHandler(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeleteWindow.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Delete Window Controller");
        stage.show();
        //DeleteWindowController delete = loader.getController();
        delete.setAdd(this);
        delBtn.setDisable(true);
        
        
        stage.setOnCloseRequest(e -> {
        delBtn.setDisable(false); 
        showData();
        });
        stage.setOnHidden(e -> {
        delBtn.setDisable(false); 
        showData();
        });
    }
    @FXML
     public Crop onEdit() {
         Crop selectedCrop = null;
    // check the table's selected item and get selected item
    if (tableView.getSelectionModel().getSelectedItem() != null) {
        selectedCrop = tableView.getSelectionModel().getSelectedItem();
        sideName.setText(selectedCrop.getItemName());
        sideQuantity.setText((selectedCrop.getItemQuantity().toString()));
        sideType.setText(selectedCrop.getItemType());
        sidePrice.setText((selectedCrop.getPricePerPound().toString()));
        sideFieldSection.setText((selectedCrop.getFieldSection()));
        sideID.setText((selectedCrop.getItemId().toString()));
        
    }
    return selectedCrop;
     }
    
    public void showData(){
        //Clear table, read from file and populate tableview with data from the observable list
        tableView.getItems().clear();
        manager.fileReading(list);
        itemID.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemType.setCellValueFactory(new PropertyValueFactory<>("itemType"));
        pricePerPound.setCellValueFactory(new PropertyValueFactory<>("pricePerPound"));
        itemQuantity.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
        fieldSection.setCellValueFactory(new PropertyValueFactory<>("fieldSection"));
        tableView.setItems(list);
        
  
    }
    
    
}
    
  
 

 




    

    


