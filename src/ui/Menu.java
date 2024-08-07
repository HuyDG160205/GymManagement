
package ui;

import java.util.ArrayList;
import utils.Inputter;

/*
Menu: là 1 cái khuôn chuyên đúc ra anh quản lý danh sách các option 
có: danh sách các lựa chọn optionList
có: title: tên của menu
có: các method giúp xử lý optionList
addNewOption: them option vào optionList
print: in ra danh sách option kèm số cho người chọn
getChoice: thu thập lựa chọn chon người dùng
*/
public class Menu<T> {
    //danh sách cái option
    public ArrayList<String> optionList = new ArrayList<>();
    public String title; //tên của menu
    //constructor tạo menu bằng tên menu

    public Menu(String title) {
        this.title = title;
    }
    //addNewOption: hàm thêm Option vào optionList
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    //print: in ra danh sách optionlist kèm số để chọn
    public void print(){
        int count = 1;
        System.out.println("___________" + title + "________");
        for (String op : optionList) {
            System.out.println(count + ". " + op);
            count++;
        }
    }
    //getChoice: hàm thu thập lựa chọn
    public int getChoice(){
        int choice = Inputter.getAnInteger("Input your choice", 
                "Your choice must between 1 and" + optionList.size(), 
                1 , optionList.size());
        return choice;
    }
    //hàm ref_getchoice: là hàm nhận vào 1 danh sách chứa các <T>
    //mới em chọn và return T tương ứng vị trí đã chọn
    public T ref_getChoice(ArrayList<T> options){
        int choice = Inputter.getAnInteger("Input SEQ of brand: ", 
                "must be between 1 and " + options.size(),
                1, options.size());
        
        return options.get(choice - 1);
        
    }
}
