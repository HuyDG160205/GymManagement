/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import data.Member;
import management.ClassManagement;
import management.MemberManagement;
import ui.Menu;

/**
 *
 * @author Gia Huy
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassManagement cL = new ClassManagement();

        cL.mM.loadFromFile(".\\Members.txt");
        cL.eM.loadFromFile(".\\Equipment.txt");
        cL.loadFromFile(".\\Classes.txt");

        Menu BigMenu = new Menu("_________Gym Management_________");
        Menu MemberMenu = new Menu("_________Member Mangement_________");
        Menu EquipmentMenu = new Menu("_________Equipment Management_________");
        Menu ClassMenu = new Menu("_________Class Menu_________");
        Menu dataMenu = new Menu("_________Data Mangement_________");
        BigMenu.addNewOption("Member Management");
        BigMenu.addNewOption("Equipment Management");
        BigMenu.addNewOption("Class Management");
        BigMenu.addNewOption("Data Management");
        MemberMenu.addNewOption("Create a new member");
        MemberMenu.addNewOption("Sort and print the list of members ascending by name");
        MemberMenu.addNewOption("View and update existing member information");
        MemberMenu.addNewOption("Delete a member");
        MemberMenu.addNewOption("Count member and print");
        EquipmentMenu.addNewOption("Add new equipment");
        EquipmentMenu.addNewOption("Sort and print the equipment list descending by name.");
        EquipmentMenu.addNewOption("Update and manage equipment inventory");
        EquipmentMenu.addNewOption("Remove equipment");
        ClassMenu.addNewOption("Create a new class");
        ClassMenu.addNewOption("Update class information");
        ClassMenu.addNewOption("Remove a class");
        ClassMenu.addNewOption("Display all class");

        while (true) {
            BigMenu.print();
            switch (BigMenu.getChoice()) {
                case 1: {
                    MemberMenu.print();
                    switch (MemberMenu.getChoice()) {
                        case 1: {
                            cL.mM.addMember();
                            break;
                        }
                        case 2: {
                            cL.mM.sortNPrintInOrd();
                            break;
                        }
                        case 3: {
                            cL.mM.updateMember();
                            break;
                        }
                        case 4: {
                            cL.removeMember();
                            break;
                        }
                        case 5 :{
                            cL.mM.countMemberShipType();
                        }
                    }
                    break;
                }
                case 2: {
                    EquipmentMenu.print();
                    switch (EquipmentMenu.getChoice()) {
                        case 1: {
                            cL.eM.addEquipment();
                            break;
                        }
                        case 2: {
                            cL.eM.sortNPrintInOrd();
                            break;
                        }
                        case 3: {
                            cL.eM.updateEquipment();
                            break;
                        }
                        case 4: {
                            cL.removeEquipment();
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    ClassMenu.print();
                    switch (ClassMenu.getChoice()) {
                        case 1: {
                            cL.addNewClass();
                            break;
                        }
                        case 2: {
                            cL.updateClasses();
                            break;
                        }
                        case 3: {
                            cL.removeClass();
                            break;
                        }
                        case 4: {
                            cL.displayAllClasses();
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    cL.saveToFile(".//Classes.txt");
                    cL.mM.saveToFile(".//Members.txt");
                    cL.eM.saveToFile(".//Equipment.txt");
                    break;
                }

            }
        }

    }

}
