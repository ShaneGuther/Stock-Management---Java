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
import javafx.scene.image.ImageView;
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
    private TableView<Crop> tableView;
    private LoginWindowController loginWindow;
    private static FXMLDocumentController controller;
    
    FileManagement manager = new FileManagement();
    
    ObservableList<Crop> list = FXCollections.observableArrayList();
 
    private static AddWindowController add;

    private static DeleteWindowController delete;
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
    @FXML
    private ImageView itemImage;
    
    public void setName(String name) {
       loginName.setText(name);
    }
    
    public void setType(String type) {
       loginType.setText(type);
    }
    
    public void disableAddBtn(){
       addBtn.setDisable(true);
    }
    
    public void disableUpdBtn(){
       updBtn.setDisable(true);
    }
    
    public void disableDelBtn(){
       delBtn.setDisable(true);
    }
   
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        delete = DeleteWindowController.getControllerTwo();
       //loginName.setText(loginWindow.getName());
        getSelected();
        showData();
//       onEdit();
       //list.setAdd();
    }    
//    public void setList(ObservableList list){
//        this.list = list;
//    }
//    public ObservableList getList(){
//        return list;
//    }
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
        add.setData(list);
        addBtn.setDisable(true);
        stage.setOnCloseRequest(e -> {
        addBtn.setDisable(false); 
        });
        stage.setOnHidden(e-> {
            addBtn.setDisable(false);
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
        update.setData(list);
        stage.setOnCloseRequest(e -> {
        updBtn.setDisable(false); 
        });
        stage.setOnCloseRequest(e -> {
        addBtn.setDisable(false); 
        });
        stage.setOnHidden(e -> {
        updBtn.setDisable(false); 
        showData();   
        });
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
        delete = loader.getController();
        delete.setAdd(this);
        delBtn.setDisable(true);
        Crop g = new Crop(1, "g", "h", 5, 6.0, "d");
        delete.setCrops(g);
        delete.setData(list);
        
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
//     public void onEdit() {
//         Crop selectedCrop = null;
//        
//     }
    // check the table's selected item and get selected item
    public Crop getSelected(){
        Crop f = new Crop(1, "h","g",3,4.1,"h");
   if (tableView.getSelectionModel().getSelectedItem() != null){
        Crop selectedCrop = tableView.getSelectionModel().getSelectedItem();
        sideName.setText(selectedCrop.getItemName());
        sideQuantity.setText((selectedCrop.getItemQuantity().toString()));
        sideType.setText(selectedCrop.getItemType());
        sidePrice.setText((selectedCrop.getPricePerPound().toString()));
        sideFieldSection.setText((selectedCrop.getFieldSection()));
        sideID.setText((selectedCrop.getItemId().toString()));
        //deleteControl.setData(list);
       return selectedCrop;
   }    
        return f;
        
}
//     public void setList(){
//         this.list=manager.fileReading();
//         
//     }
//    public void setData(Integer id, String name, String type, Integer itemQuantity, Double pricePerPound,String fieldSection){
//        Crop newCrop= new Crop(id,name,type,itemQuantity,pricePerPound,fieldSection);
//        list.add(newCrop);
//        manager.fileWriting(list);
//        tableView.setItems(list);
//    }
//    public ObservableList getData(){
//        return list;
//    }
    
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
    
    void setAdd(LoginWindowController aThis) {  
    }

    public static FXMLDocumentController getController(){
        return controller;
    }
}

//itemImage.setImage(selectedCrop.getImage());

