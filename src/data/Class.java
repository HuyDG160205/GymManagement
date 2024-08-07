/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Gia Huy
 */
public class Class {

    private String classId;
    private String name;
    private String schedule; // e.g., "Mon/Wed/Fri 6pm"
    private int capacity;
    private ArrayList<Member> members;
    private ArrayList<Equipment> equipment;

    public Class() {
    }

    public Class(String classId, String name, String schedule, int capacity, ArrayList<Member> members, ArrayList<Equipment> equipment) {
        this.classId = classId;
        this.name = name;
        this.schedule = schedule;
        this.capacity = capacity;
        this.members = members;
        this.equipment = equipment;
    }

    public String getClassId() {
        return classId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }
    
    public String getListOfMemberID(){
        StringBuilder str = new StringBuilder();
        
        for (Member member : members) {
            str.append(member.getMemberID()).append(",");
            
            str.substring(0, str.length()-2);
        }
        
        return str.toString();
    }
    public String getListOfEquipmentID(){
        StringBuilder str = new StringBuilder();
        
        for (Equipment equipment1 : equipment) {
            str.append(equipment1.getEquipmentID()).append(",");
            
            str.substring(0,str.length()-2);
        }
        
        return str.toString();
    }

    @Override
    public String toString() {
        String str = String.format("", classId,name,schedule,capacity,getListOfMemberID(),getListOfEquipmentID());
        
        return str;
    }

    
    
    
    
}
