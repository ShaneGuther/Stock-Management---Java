/**
 * Is This working
 * 
 * */
package finalproject;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Pat
 */
public class Crop {
    //private int itemId  = 0;
    //private String itemName;
    private final SimpleIntegerProperty itemId;
    private final SimpleStringProperty itemName;
    //private String itemType;
    private final SimpleStringProperty itemType;
    //private char fieldSection;
    private final SimpleStringProperty fieldSection;
    //private int itemQuantity;
    private final SimpleIntegerProperty itemQuantity;
    //private boolean itemAvailability;
    private final SimpleDoubleProperty pricePerPound;
    //private double pricePerPound;

//    public Crop(String name, String itemType, int itemQuantity, double pricePerPound, char fieldSection) {
//        //this.itemId = itemId;
//        this.itemName = name;
//        this.itemType = itemType;
//        this.itemQuantity = itemQuantity;
//       // this.itemAvailability = itemAvailability;
//        this.pricePerPound = pricePerPound;
//        this.fieldSection = fieldSection;
//    }    
    public Crop(Integer itemId, String itemType, String itemName, Integer itemQuantity, Double pricePerPound, String fieldSection){
        this.itemId = new SimpleIntegerProperty(itemId);
        this.itemName = new SimpleStringProperty(itemName);
        this.itemType = new SimpleStringProperty(itemType);
        this.itemQuantity = new SimpleIntegerProperty(itemQuantity);
        this.pricePerPound = new SimpleDoubleProperty(pricePerPound);
        this.fieldSection = new SimpleStringProperty(fieldSection);
    }

    public void setFieldSection(String section) {
        fieldSection.set(section);
    }

    public void setItemId(int itemId) {
        this.itemId.set(itemId);
    }

    public void setItemName(String name) {
        itemName.set(name);
    }

    public void setItemType(String type) {
        itemType.set(type);
    }

    public void setItemQuantity(Integer quantity) {
        itemQuantity.set(quantity);
    }

//    public void setItemAvailability(boolean itemAvailability) {
//        this.itemAvailability = itemAvailability;
//    }

    public void setPricePerPound(Double price) {
        pricePerPound.set(price);
    }

    public String getFieldSection() {
        return fieldSection.get();
    }

    public Integer getItemId() {
        return itemId.get();
    }

    public String getItemName() {
        return itemName.get();
    }

    public String getItemType() {
        return itemType.get();
    }

    public Integer getItemQuantity() {
        return itemQuantity.get();
    }

//    public boolean isItemAvailability() {
//        return itemAvailability;
//    }

    public Double getPricePerPound() {
        return pricePerPound.get();
    }

    @Override
    public String toString() {
        return itemId + "," + itemName + "," + itemType +"," + itemQuantity + "," + pricePerPound + "," + pricePerPound + "," + fieldSection;
    }

   /* public String cropImage(){
        String imageSource="";
        switch (itemType){
            case "Nightshade":
                imageSource="/images.corn."
                        break;
            case "Legume":
                
            
        }
    }*/

}
