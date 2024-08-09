/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import data.Member;
import management.ClassManagement;
import management.MemberManagement;

/**
 *
 * @author Gia Huy
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassManagement cL= new ClassManagement();
        
        
        cL.mM.loadFromFile(".\\Members.txt");
        cL.eM.loadFromFile(".\\Equipment.txt");
        cL.loadFromFile(".\\Classes.txt");
        cL.mM.saveToFile(".\\Members.txt");
        cL.eM.saveToFile(".\\Equipment.txt");
        cL.saveToFile(".\\Classes.txt");
        cL.displayAllClasses();
    }
    
}
