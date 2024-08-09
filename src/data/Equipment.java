/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Gia Huy
 */
public class Equipment implements Comparable<Equipment>{
    private String equipmentID;
    private String equipmentName;
    private String type;
    private int quantity;
    private String condition;

    public Equipment() {
    }

    public Equipment(String equipmentID, String equipmentName, String type, int quantity, String condition) {
        this.equipmentID = equipmentID;
        this.equipmentName = equipmentName;
        this.type = type;
        this.quantity = quantity;
        this.condition = condition;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCondition() {
        return condition;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        String str = String.format("%4s|%-30s|%-15s|%4d|%s", equipmentID, equipmentName, type, quantity, condition);

        return str;
    }

    @Override
    public int compareTo(Equipment o) {
        return this.getEquipmentName().compareTo(o.getEquipmentName());
    }
    
    
}
