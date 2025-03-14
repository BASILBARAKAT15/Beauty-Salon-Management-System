package packag2;

import java.io.Serializable;

public class Customer implements Serializable {
private String name;
private String phoneNumber;
private String membershipType;


public Customer(String name,String phoneNumber,String membershipType) {
	this.name=name;
	this.phoneNumber=phoneNumber;
	this.membershipType=membershipType;
	
	
}
//////////////////////////////////////////////////////////////////////////////// set&get Name
public void setName(String name) {this.name=name;}
public String getName() {return name;}
////////////////////////////////////////////////////////////////////////////////set&get Phone Number
public void setPhoneNumber(String phoneNumber) {this.phoneNumber=phoneNumber;}
public String getphoneNumber() {return phoneNumber;}
///////////////////////////////////////////////////////////////////////////////set&get membership
public void setmembershipType(String membershipType) {this.membershipType=membershipType;}
public String getmemberhipType() {return membershipType;}
//////////////////////////////////////////////////////////////////////////////
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Name:"+name+"\t"+"Phone Numaber:"+phoneNumber+"\t"+"Membership Type:"+membershipType+"\n";
}











}
