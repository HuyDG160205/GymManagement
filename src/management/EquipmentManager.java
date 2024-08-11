/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import data.Equipment;
import data.Member;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import utils.Inputter;

/**
 *
 * @author Gia Huy
 */
public class EquipmentManager extends HashMap<String, Equipment> {

    public boolean loadFromFile(String url) {
        File f = new File(url);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String type = st.nextToken().trim();
                int quantity = Integer.parseInt(st.nextToken().trim());
                String condition = st.nextToken().trim();

                this.put(id, new Equipment(id, name, type, quantity, condition));
                
                
                line = reader.readLine();
            }

            return true;
        } catch (Exception e) {
            System.out.println("Load from file fail" + e);
            return false;
        }
    }

    public void addEquipment() {
        String id;
        do {
            id = Inputter.getString("Please input a new equipment id E---", "This field is required E---", "E\\d{3}");

            if (this.containsKey(id)) {
                System.out.println("This id already exised");
            }
        } while (this.containsKey(id));
        String name = Inputter.getString("Please input a new name", "This field is required");
        String type = Inputter.getString("Please input a new type", "This field is required");
        int quantity = Inputter.getAnInteger("Please input quantity", "Must be higher than 0", 0, Integer.MAX_VALUE);
        String condition = Inputter.getString("Please input equipment condition", "This field is required");

        this.put(id, new Equipment(id, name, type, quantity, condition));

    }

    public void updateEquipment() {
        String id;
        do {
            id = Inputter.getString("Please input equipment id E---", "This field is required E---", "E\\d{3}");

            if (!this.containsKey(id)) {
                System.out.println("This id already existed");
            }
        } while (!this.containsKey(id));
        
        System.out.println("The Equipment information");
        System.out.println(this.get(id));
        
        String name = Inputter.getString("Please input a name, leave blank", "This field is required", ".*");
        if(!name.isEmpty()){
            this.get(id).setEquipmentName(name);
        }
        String type = Inputter.getString("Please input a new type, leave blank", "This field is required", ".*" );
        if(!type.isEmpty()){
            this.get(id).setType(type);
        }
        String quantity = Inputter.getString("Please input quantity, leave blank", "Must be a number higher than 0", "^\\d*$");
        if(!quantity.isEmpty()){
            this.get(id).setQuantity(Integer.parseInt(quantity));
        }
        String condition = Inputter.getString("Please input equipment condition", "This field is required", ".*");
        if(!condition.isEmpty()){
            this.get(id).setCondition(condition);
        }

    }
    
    
    public void sortNPrintInOrd(){
        ArrayList<Equipment> tmp = new ArrayList<>(this.values());
        if(tmp.size() == 0) return;
        Collections.sort(tmp);
        
        for (Equipment equipment : tmp) {
            System.out.println(equipment);
        }
    }
    
    public boolean saveToFile(String url){
        File f = new File(url);
        try{
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Equipment value : this.values()) {
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
