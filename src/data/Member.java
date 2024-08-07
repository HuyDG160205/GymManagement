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
public class Member implements Comparable<Member> {

    private String memberID;
    private String memberName;
    private String address;
    private String contactInformation;
    private String membershipType;

    public Member() {
    }

    public Member(String memberID, String memberName, String address, String contactInformation, String membershipType) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.address = address;
        this.contactInformation = contactInformation;
        this.membershipType = membershipType;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    @Override
    public String toString() {
        String str = String.format("%4s|%-30s|%-30s|%-15s|%s", memberID, memberName, address, contactInformation, membershipType);

        return str;
    }

    @Override
    public int compareTo(Member o) {
        return this.getMemberName().compareTo(o.getMemberName());
    }

}
