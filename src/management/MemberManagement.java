/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import data.Member;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.swing.text.html.HTML;
import utils.Inputter;

/**
 *
 * @author Gia Huy
 */
public class MemberManagement extends HashMap<String, Member>{
    
    public boolean loadFromFile(String url){
        File f = new File(url);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while(line != null){
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String address = st.nextToken().trim();
                String phone = st.nextToken().trim();
                String type = st.nextToken().trim();
                
                this.put(id, new Member(id, name, address, phone, type));
                
                line = reader.readLine();
            }
            
            return true;
        }catch(Exception e){
            System.out.println("Load from file fail" + e);
            return false;
        }
    }
    
    public void addMember(){
        String id;
        do{
            id = Inputter.getString("Please input new id M---", "This field is required", "M\\d{3}");
            
            if(this.containsKey(id)){
                System.out.println("This id already existed");
            }
        }while(this.containsKey(id));
        
        String name = Inputter.getString("Please input new member name", "This field is required");
        String address = Inputter.getString("Please input new address", "This field is required");
        String phone = Inputter.getString("Please input name phone", "This field is required");
        String type = Inputter.getString("Please input a Type (standard/premium)", "Please input either standard/premium");
        
        this.put(id, new Member(id, name, address, phone, type));
    }
    
    public void DisplayAllMember(){
        this.forEach((key,value) -> {
            System.out.println(value);
        });
    }
    public ArrayList<Member> returnAllMember(){
         ArrayList<Member> member = new ArrayList<>(this.values());
        
         return member;
    }
    
    public void updateMember(){
        String id;
        do{
            id = Inputter.getString("Please input id to update M---", "This field is required");
            
            if(!this.containsKey(id)){
                System.out.println("This id doesnt exist");
            }
        }while(!this.containsKey(id));
        
        System.out.println("The Member information");
        System.out.println(this.get(id));
        
        String name = Inputter.getString("Please input member name to update, leave blank", "This field is required", ".*");
        if(!name.isEmpty()){
            this.get(id).setMemberName(name);
        }
        String address = Inputter.getString("Please input new address to update, leave blank", "This field is required", ".*");
        if(!address.isEmpty()){
            this.get(id).setAddress(address);
        }
        String phone = Inputter.getString("Please input phone, leave blank", "This field is required", ".*");
        if(!phone.isEmpty()){
            this.get(id).setContactInformation(phone);
        }
        String type = Inputter.getString("Please input a Type (standard/premium)", "Please input either standard/premium", ".*");
        if(!type.isEmpty()){
            this.get(id).setMembershipType(type);
        }
    }
    
    public void sortNPrintInOrd(){
        ArrayList<Member> member = new ArrayList<>(this.values());
        if(member.size() == 0) return;
        Collections.sort(member);
        
        for (Member member1 : member) {
            System.out.println(member1);
        }
    }
    
    public boolean saveToFile(String url){
        File f = new File(url);
        try{
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Member value : this.values()) {
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
