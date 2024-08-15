/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import data.Classes;
import data.Equipment;
import data.Member;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import utils.Inputter;

/**
 *
 * @author Gia Huy
 */
public class ClassManagement {

    HashMap<String, Classes> cM = new HashMap<>();
    public MemberManagement mM = new MemberManagement();
    public EquipmentManager eM = new EquipmentManager();

    public boolean loadFromFile(String url) {
        File f = new File(url);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String schedule = st.nextToken().trim();
                int quantity = Integer.parseInt(st.nextToken().trim());
                String member = st.nextToken().trim();

                String equipment = st.nextToken().trim();

                cM.put(id, new Classes(id, name, schedule, quantity, listOfMember(member), listOfEquipment(equipment)));

                line = reader.readLine();
            }

            return true;
        } catch (Exception e) {
            System.out.println("Load from file fail" + e);
            return false;
        }
    }

    public ArrayList<Member> listOfMember(String member) {
        String[] membersID = member.split(",");
        ArrayList<Member> tmp = new ArrayList<>();
        for (String member1 : membersID) {
            if(mM.containsKey(member1)){
                tmp.add(mM.get(member1.trim()));
            }
        }
        return tmp;
    }

    public ArrayList<Equipment> listOfEquipment(String equipment) {
        String[] equipmentsID = equipment.split(",");
        ArrayList<Equipment> tmp = new ArrayList<>();

        for (String string : equipmentsID) {
            if(eM.containsKey(string)){
                tmp.add(eM.get(string.trim()));
            }
        }
        return tmp;
    }

    public void addNewClass() {
        String id;
        do {
            id = Inputter.getString("Please input a new class to add", "This field is requried", "C\\d{3}");
        } while (cM.containsKey(id));
        
        
        String name = Inputter.getString("Please input a new class name", "This field is required");
        String schedule = Inputter.getString("Please input schedule, if no then leave blank", "must be like XXX/XXX/... Xam/pm", "\\w{3}(/\\w{3})* \\d{1,2}(am|pm)");
        int quantity = Inputter.getAnInteger("Please input quantity", "must be higher than 0", 0, Integer.MAX_VALUE);
        String member;
        System.out.println("input member to add into class, leave blank if done");
        ArrayList<Member> memberList = new ArrayList<>();

        do {
            member = Inputter.getString("Please input a member ID", "This field is required", "(M\\d{3})*");

            if (memberList.size() == quantity) {
                System.out.println("Maximum amount of member exceeded");
                break;
            }
//            member cần tìm có ở trong class chưa,
//      có rồi thì k add
            if (!mM.containsKey(member)) {
                System.out.println("This member doesnt exist");
                continue;
            }
            if (memberList.contains(mM.get(member))) {
                System.out.println("Theres already this member in the class");
                continue;
            }

            memberList.add(mM.get(member));

        } while (!member.isEmpty());

        String equipment;
        ArrayList<Equipment> equipList = new ArrayList<>();
        do {
            equipment = Inputter.getString("Please input equipID to add, leave blank if done", "This field is required", "(E\\d{3})*");

            if (!eM.containsKey(equipment)) {
                System.out.println("This Equipment doesnt exist");
                continue;
            }
            if (equipList.contains(eM.get(equipment))) {
                System.out.println("Theres already this equipment in the class");
                continue;
            }
            equipList.add(eM.get(equipment));
        } while (!equipment.isEmpty());

        cM.put(id, new Classes(id, name, schedule, quantity, memberList, equipList));
    }

    public void displayAllClasses() {
        ArrayList<Classes> tmp = new ArrayList<>(cM.values());
        
        for (Classes classes : tmp) {
            System.out.println(classes);
        }
        
    }

    public void updateClasses() {

        displayAllClasses();

        String id;
        do {
            id = Inputter.getString("Please input a class id to update", "This field is required");

            if (!cM.containsKey(id)) {
                System.out.println("This id doesnt exist");
            }
        } while (!cM.containsKey(id));

        String name = Inputter.getString("Please input a new class name, leave blank", "This field is required", "\\.*");
        if(!name.isEmpty()){
            cM.get(id).setName(name);
        }
        String schedule = Inputter.getString("Please input schedule, if no then leave blank", "must be like XXX/XXX/... Xam/pm", "^(\\w{3}(/\\w{3})* \\d{1,2}(am|pm)){0,1}$");
        if(!schedule.isEmpty()){
            cM.get(id).setSchedule(schedule);
        }
        
        int quantity;
        do{
            quantity = Inputter.getAnInteger("Please input quantity", "must be higher than 0", 0, Integer.MAX_VALUE);
            
            if(quantity < cM.get(id).getMembers().size()){
                System.out.println("capacity must be higher than the current member in the class");
            }
        }while(quantity < cM.get(id).getMembers().size());
        cM.get(id).setCapacity(quantity);
        
        String member;
        System.out.println("input member to add into class, leave blank if done");
        ArrayList<Member> memberList = new ArrayList<>();

        do {
            member = Inputter.getString("Please input a member ID", "This field is required", "(M\\d{3})*");

            if (memberList.size() == quantity) {
                System.out.println("Maximum amount of member exceeded");
                break;
            }
//            member cần tìm có ở trong class chưa,
//      có rồi thì k add
            if (!mM.containsKey(member)) {
                System.out.println("This member doesnt exist");
                continue;
            }
            if (memberList.contains(mM.get(member))) {
                System.out.println("Theres already this member in the class");
                continue;
            }

            memberList.add(mM.get(member));

        } while (!member.isEmpty());
        cM.get(id).setMembers(memberList);

        String equipment;
        ArrayList<Equipment> equipList = new ArrayList<>();
        do {
            equipment = Inputter.getString("Please input equipID to add, leave blank if done", "This field is required", "(E\\d{3}){0,1}");

            if (!eM.containsKey(equipment)) {
                System.out.println("This Equipment doesnt exist");
                continue;
            }
            if (equipList.contains(eM.get(equipment))) {
                System.out.println("Theres already this equipment in the class");
                continue;
            }
            equipList.add(eM.get(equipment));
        } while (!equipment.isEmpty());
        cM.get(id).setEquipment(equipList);
    }
    
    
    
    public void removeMember(){
        
        
        String id;
        do{
            if(mM.isEmpty()) return;
        
            id = Inputter.getString("Please input an ID to remove", "This field is required");
            
            if(!mM.containsKey(id)){
                System.out.println("This id doesnt exist");
            }
        }while(!mM.containsKey(id));
        
        boolean isDup = false;
        for (Classes value : cM.values()) {
            if(value.getMembers().contains(mM.get(id))){
                isDup= true;
            }
        }
        if(isDup && Inputter.getString("Member exist in classes do you want to delete?, (Y/N)", "This field is required").equals("Y")){
            for (Classes value : cM.values()) {
                value.removeMemberInClass(mM.get(id));
            }
        }
        mM.remove(id);
        System.out.println("Successfuly removed");
    }
    
    public void removeEquipment(){
        
        
        String id;
        do{
            if(eM.isEmpty()) return;
        
            id = Inputter.getString("Please input an ID to remove", "This field is required");
            
            if(!eM.containsKey(id)){
                System.out.println("This id doesnt exist");
            }
        }while(!eM.containsKey(id));
        
        boolean isDup = false;
        for (Classes value : cM.values()) {
            if(value.getEquipment().contains(eM.get(id))){
                isDup= true;
                break;
            }
        }
        if(isDup && Inputter.getString("Equipment exist in classes do you want to delete?, (Y/N)", "This field is required").equals("Y")){
            for (Classes value : cM.values()) {
                value.removeEquipmentInClass(eM.get(id));
            }
        }
        eM.remove(id);
        System.out.println("Successfuly removed");
    }
    
    public void removeClass(){
        String id;
        do{
            id = Inputter.getString("Please input an ID to remove", "This field is required");
            
            if(!cM.containsKey(id)){
                System.out.println("This id doesnt exist");
            }
        }while(!cM.containsKey(id));
        
        if(Inputter.getString("Do you wish to delete this class? (Y/N)", "This field is requried").equalsIgnoreCase("y")){
            cM.remove(id);
        }
        System.out.println("Removed successfully");
        
    }
    
    
    
    public boolean saveToFile(String url){
        File f = new File(url);
        try{
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Classes value : cM.values()) {
                writer.write(value.toString());
                writer.write("\n");
            }
            writer.flush();
            
            return true;
        }catch(Exception e){
            System.out.println("Failed to save to file" + e);
            return false;
        }
    }

}
