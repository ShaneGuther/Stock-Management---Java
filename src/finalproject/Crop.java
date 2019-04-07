/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Pat
 */
public class Crop {

    private int itemId;
    private String fieldSection;
    private String itemName;
    private String itemType;
    private double itemQuantity;
    private boolean itemAvailability;
    private double pricePerPound;

    public Crop(int itemId, String name, String itemType, double itemQuantity, boolean itemAvailability, double pricePerPound, String fieldSection) {
        this.itemId = itemId;
        this.itemName = name;
        this.itemType = itemType;
        this.itemQuantity = itemQuantity;
        this.itemAvailability = itemAvailability;
        this.pricePerPound = pricePerPound;
        this.fieldSection = fieldSection;
    }

    public void setFieldSection(String fieldSection) {
        this.fieldSection = fieldSection;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.itemName = name;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemAvailability(boolean itemAvailability) {
        this.itemAvailability = itemAvailability;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    public String getFieldSection() {
        return fieldSection;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public boolean isItemAvailability() {
        return itemAvailability;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    @Override
    public String toString() {
        return "Crop{" + "id=" + itemId + ", name=" + itemName + ", itemType=" + itemType +", quantity="+itemQuantity+", availability="+itemAvailability+", price="+pricePerPound+", field="+fieldSection+ '}';
    }


}
