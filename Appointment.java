package packag2;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable  {
	private Customer customer;
	private Serivce serivce;
	private Date date;
	private double totalPrice;

	public Appointment(Customer customer, Serivce serivce,Date date,double totalPrice) {
		this.customer=customer;
		this.serivce=serivce;
		this. date=date;
		this.totalPrice=totalPrice;
	}
//////////////////////////////////////////////////////////////////////// set & get Customer
	public void setCustomer(Customer customer) {this.customer=customer;}
	public Customer getCustomer() {return this.customer;}
	///////////////////////////////////////////////////////////////////set & get serivce
	public void setSerivce(Serivce serivce) {this.serivce=serivce;}
	public Serivce getSerivce() {return serivce;}
	///////////////////////////////////////////////////////////////////set & get  date
	public void setDate(Date date) {this.date=date;}
	public Date getDate() {return date;}
	////////////////////////////////////////////////////////////////// set & get totalprice
	public void setTotlprice(double totalPrice) {this.totalPrice=totalPrice;}
	public double getTotlprice() {return totalPrice;}
	/////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer:"+customer+"\t"+"Serivce:"+serivce+"\t"+"Date:"+date+"\t"+"Total Price:"+totalPrice+"\n";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
