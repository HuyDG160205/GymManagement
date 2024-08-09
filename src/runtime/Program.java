/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import data.Member;
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
        MemberManagement mM = new MemberManagement();
        mM.loadFromFile(".\\Members.txt");
        
        mM.DisplayAllMember();
        
    }
    
}
