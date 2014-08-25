/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

/**
 *
 * @author Keiko Nagano
 */
public class ItemBean {
    private int itemID;
    private String itemName;
    private double itemWeight;
    private int itemQuantity;
    
    public ItemBean( String itemName, double itemWeight, int itemQuantity){
     
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemQuantity = itemQuantity;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }
    
    
}
