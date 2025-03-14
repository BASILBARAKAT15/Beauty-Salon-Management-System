package packag2;

import java.io.Serializable;

public class Serivce implements Serializable {
	private String name;
	private String duration;
	private double price;
	
	
	
	public Serivce(String name,String duration,double price) {
		this.name=name;
		this.duration=duration;
		this.price=price;
	}
//////////////////////////////////////////////////////////////////////set & get name
	public void setName(String name) {this.name=name;}
	public String getName() {return name;}
	/////////////////////////////////////////////////////////////////set& get duration
	public void setDuration(String duration) {this.duration=duration;}
	public String getDuration() {return duration;}
	/////////////////////////////////////////////////////////////////set & get price
	public void setPrice(double price) {this.price=price;}
	public double getPrice() {return price;}
	//////////////////////////////////////////////////////////////// toString
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:"+name+"\t"+"Duration:"+duration+"\t"+"Price:"+price+"\n";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
