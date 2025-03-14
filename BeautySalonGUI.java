package packag2;

import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class BeautySalonGUI extends JFrame implements Serializable  {
	
	
	
//private static final Object BroderLayout = null;

private List<Customer> customers;
	
private List<Serivce> serivces;

private List<Appointment> appointments;

private Map<String,List<Appointment>> appointmentMap;

private SimpleDateFormat dateFormat;

private Date date;

private ObjectOutputStream output;

private ObjectInputStream input;


public BeautySalonGUI() {
	customers=new ArrayList<Customer>();
	serivces=new ArrayList<Serivce>();
	appointments=new ArrayList<Appointment>();
	appointmentMap=new HashMap<String,List<Appointment>>();
	Date date=new Date();
	dateFormat=new SimpleDateFormat("yyyy-MM-dd");
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
}

public String[] getDate() {
	String[] days = new String[7];
	Calendar calendar = Calendar.getInstance();
	
	for(int i=0;i<7;i++)
	{
		days[i] = dateFormat.format(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
	}
	return days;
}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Customer r=null;
Serivce s=null;
Appointment app=null;
boolean a=false;
/////////////////////////////////////////////////////////////////////////
public void addCustomerDialog() {
	
	
	 JFrame fr1= new JFrame();
	 fr1.setTitle("Add Customer");
	 fr1.setSize(300, 300);
	 fr1.setVisible(true);
	 fr1.setLocationRelativeTo(null);
	 fr1.setLayout(getLayout());
	 
 JLabel name,phoneNumber,Membership;
 JButton insert,cancel;
 final JTextField  name1,phone;
 JPanel panel1,panel3;
 JComboBox membershipType;
 //////////////////////////////////////////////////////

String [] mem= {"Silver","Gold","Platenium"};
 
 name=new JLabel("Name:");
 phoneNumber=new JLabel("Phone Number:");
 Membership=new JLabel("Membership Type:");
 insert=new JButton("  insert   ");
 
 ////////////////////////////////////////////////////////
 membershipType=new  JComboBox(mem);
 
 membershipType.addItemListener(new ItemListener() {

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getStateChange() == ItemEvent.SELECTED) {membershipType.getSelectedItem();}
	}
	 
 });

 
 //////////////////////////////////////////////////////
 name1=new JTextField(20);
 phone=new JTextField(10);

 insert.addActionListener( new ActionListener() {
	 
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()== insert)	{	
			 
			 Customer typ=new Customer(name1.getText(),phone.getText(),(String) membershipType.getSelectedItem());
			 customers.add(typ);
			 fr1.setVisible(false);
			 System.out.println(customers.getFirst());

			 JOptionPane.showMessageDialog(null, "Customer Added  "+name1.getText()+"  Successfully ");
			// saveCustomerToFile();
			
			 
		 }
		 
		 
	
	}
	 
 });
 /////////////////////////////////////////////
 cancel=new JButton("  cancel   ");
 
 cancel.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()== cancel)		fr1.setVisible(false);	
	}
	 
 });
  
 
//////////////////////////////////////// 


 /////////////////////////////////
 panel1=new JPanel(); panel1.add(name); panel1.add(name1);panel1.add(phoneNumber);panel1.add(phone);panel1.add(Membership);panel1.add(membershipType);
 panel3=new JPanel();panel3.add(insert);panel3.add(cancel);
 
 
 
 fr1.add(panel1,BorderLayout.CENTER);

  fr1.add(panel3,BorderLayout.SOUTH);
 
 
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Customer selsctedDeleteCustomerDialog() {
	 JFrame fr2= new JFrame();
	 fr2.setTitle("Select Customer");
	 fr2.setSize(500, 200);
	 fr2.setVisible(true);
	fr2.setLocationRelativeTo(null);
	fr2.setLayout(getLayout());
	
	//////////////////////////
	 
	 JPanel panel4,panel5;	 
	 JLabel label;
	 JButton ok,cancel;
	 JComboBox select;
	 /////////////////////////
	
	 
	 ///////////////////////
	 label=new JLabel("Select Customer");
	 ////////////////////////////////////////
	 select=new JComboBox();
	 for(int i=0;i<customers.size();i++) {
		 select.addItem(customers.get(i));

	 }
	 
	 select.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) { r= (Customer) select.getSelectedItem();}
		}
		 
	 });
/////////////////////////////////////////////
	 ok =new JButton("  OK  ");
	 ok.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			if(e.getSource()== ok) 
			{
				//r= (Customer) select.getSelectedItem(); 
				deleteCustomerDialog();
			}
			
			
			fr2.setVisible(false);
		}
		 
	 });
	 /////////////////////////////
 cancel =new JButton("  cancel  ");
 cancel.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		fr2.setVisible(false);
	}
	 
 });
	 
	 
	 //////////////////////////////////////
	 panel4=new JPanel();panel4.add(select);panel4.add(label);
	 panel5=new JPanel();panel5.add(ok);panel5.add(cancel);
	 fr2.add(panel4,BorderLayout.CENTER);
	fr2.add(panel5,BorderLayout.SOUTH);
	
    
	 

	System.out.println(r+"HO");
	return r= (Customer) select.getSelectedItem();
	
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Customer selectEditCustomerDialoge() {
	//Customer r=null;
	 JFrame fr2= new JFrame();
	 fr2.setTitle("Select Customer");
	 fr2.setSize(500, 200);
	 fr2.setVisible(true);
	 fr2.setLocationRelativeTo(null);
	fr2.setLayout(getLayout());
	
	//////////////////////////
	 
	 JPanel panel4,panel5;	 
	 JLabel label;
	 JButton ok,cancel;
	 JComboBox select;
	 /////////////////////////
	
	 
	 ///////////////////////
	 label=new JLabel("Select Customer");
	 ////////////////////////////////////////
	 select=new JComboBox();
	 for(int i=0;i<customers.size();i++) {
		 select.addItem(customers.get(i));

	 }
	 
	 select.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) { r= (Customer) select.getSelectedItem();}
		}
		 
	 });
/////////////////////////////////////////////
	 ok =new JButton("  OK  ");
	 ok.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			if(e.getSource()== ok) 
			{
				//r= (Customer) select.getSelectedItem(); 
				editCustomerDialog();
			}
			
			
			fr2.setVisible(false);
		}
		 
	 });
	 /////////////////////////////
 cancel =new JButton("  cancel  ");
 cancel.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		fr2.setVisible(false);
	}
	 
 });
	 
	 
	 //////////////////////////////////////
	 panel4=new JPanel();panel4.add(select);panel4.add(label);
	 panel5=new JPanel();panel5.add(ok);panel5.add(cancel);
	 fr2.add(panel4,BorderLayout.CENTER);
	fr2.add(panel5,BorderLayout.SOUTH);
	
    
	 

	System.out.println(r+"HO");
	return r= (Customer) select.getSelectedItem();
	
}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void editCustomerDialog() {
	
	
	
	 JFrame fr3= new JFrame();
	 fr3.setTitle("Edit Customer");
	 fr3.setSize(300, 300);
	 fr3.setVisible(true);
	 fr3.setLocationRelativeTo(null);
JLabel name,phoneNumber,Membership;
JButton insert,cancel;
 final JTextField  name1,phone;
JPanel panel6,panel7;
JComboBox membershipType;
//////////////////////////////////////////////////////

String [] mem= {"Silver","Gold","Platenium"};

name=new JLabel("Name:");
phoneNumber=new JLabel("Phone Number:");
Membership=new JLabel("Membership Type:");
insert=new JButton("  insert   ");

////////////////////////////////////////////////////////
membershipType=new  JComboBox(mem);

membershipType.addItemListener(new ItemListener() {

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getStateChange() == ItemEvent.SELECTED) {membershipType.getSelectedItem();}
	}
	 
});


//////////////////////////////////////////////////////


name1=new JTextField(r.getName(),20);
phone=new JTextField(r.getphoneNumber(),10);

insert.addActionListener( new ActionListener() {
	 
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()== insert)	{	
			 
 r.setName(name1.getText()); r.setPhoneNumber(phone.getText()); r.setmembershipType((String) membershipType.getSelectedItem());
			
			 fr3.setVisible(false);
			 System.out.println(customers.getFirst());

			 JOptionPane.showMessageDialog(null, "Customer Edite  "+name1.getText()+"  Successfully ");
			
			 
		 }
		 
		 
	
	}
	 
});
/////////////////////////////////////////////
cancel=new JButton("  cancel   ");

cancel.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()== cancel)		fr3.setVisible(false);	
	}
	 
});
 

////////////////////////////////////////


/////////////////////////////////
panel6=new JPanel(); panel6.add(name); panel6.add(name1);panel6.add(phoneNumber);panel6.add(phone);panel6.add(Membership);panel6.add(membershipType);
panel7=new JPanel();panel7.add(insert);panel7.add(cancel);



fr3.add(panel6,BorderLayout.CENTER);

 fr3.add(panel7,BorderLayout.SOUTH);
	
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void deleteCustomerDialog() {
	// selectCustomerDialoge();
	 
	 	 JFrame fr5= new JFrame();
	 fr5.setTitle("DELETE CUSTOMER");
	 fr5.setSize(400, 100);
	 fr5.setVisible(true);
	 fr5.setLocationRelativeTo(null);
	 JButton yes,no;
	 JPanel panel8,panel9;
	 JLabel label5;
	 
	 
	 
	 panel8=new JPanel();
	 label5=new JLabel("Are you sure you want to delete this customer");
	 panel8.add(label5);
	 fr5.add(panel8,BorderLayout.CENTER);
	 
	 
	 
	 yes=new JButton("YES");
	 yes.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			 if(e.getSource()== yes) customers.remove(r);
			
			 fr5.setVisible(false);
			 JOptionPane.showMessageDialog(null, "Customer Deleted  Successfully ");
		}
		 
	 });
	 
	 
	 no=new JButton("NO");
	 no.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
if(e.getSource() == no) fr5.setVisible(false);			
		}
		 
	 });
	
	 
	 panel9=new JPanel();panel9.add(yes);panel9.add(no);
	 
	 fr5.add(panel9,BorderLayout.SOUTH);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public  void addSerivceDialog() {
	
	
	 JFrame fr6= new JFrame();
	 fr6.setTitle("Add Serivce");
	 fr6.setSize(300, 300);
	 fr6.setVisible(true);
	 fr6.setLocationRelativeTo(null);
	 fr6.setLayout(getLayout());
	 
	 String [] time= {"30 Minutes","20 Minutes","1 Hour","1.5Hour","2 Hour"};
	 
	 JPanel panel10,panel11;
	 JLabel nameSerivce,duration,price;
	 final JTextField  nameSe,pric;
	 JButton ok,cancel;
	 JComboBox durat;
	 
	 nameSerivce=new JLabel("Name:");    
	 duration=new JLabel("Duration:");
	 price=new JLabel("Price:");
	 
	 nameSe=new JTextField(10);
	 pric=new JTextField(10);
	 
	 durat=new JComboBox(time);
	 durat.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) durat.getSelectedItem();
		}
		 
	 });
	 
	 
	 ok=new JButton("OK");
	 ok.addActionListener(new ActionListener() {
 
		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource()== ok) { Serivce typ2=new Serivce(nameSe.getText(),(String) durat.getSelectedItem(),Double.parseDouble(pric.getText()));
			serivces.add(typ2);
			System.out.println(serivces.getFirst());
			fr6.setVisible(false);
			 JOptionPane.showMessageDialog(null, "Serivce  Added  Successfully ");
		}

		}	 
	 });
//////////////////////////////////////////	 
	 cancel=new JButton("Cancel");
	 cancel.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource()==cancel)fr6.setVisible(false);			
		}
		 
	 });
	 //////////////////
	 
	 panel10=new JPanel(); panel10.add(nameSerivce);panel10.add(nameSe);panel10.add(duration);panel10.add(durat);panel10.add(price);panel10.add(pric);
	panel11=new JPanel(); panel11.add(ok);panel11.add(cancel);
	 
	 
	 fr6.add(panel10,BorderLayout.CENTER);
	 fr6.add(panel11,BorderLayout.SOUTH);
	 
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Serivce selectDeletSerivceDialod() {
	 JFrame fr7= new JFrame();
	 fr7.setTitle("Select Serivce");
	 fr7.setSize(500, 200);
	 fr7.setVisible(true);
	 fr7.setLocationRelativeTo(null);
	fr7.setLayout(getLayout());
	
	//////////////////////////
	 
	 JPanel panel12,panel13;	 
	 JLabel label;
	 JButton ok,cancel;
	 JComboBox select;
	 /////////////////////////
	
	 
	 ///////////////////////
	 label=new JLabel("Select Serivce");
	 ////////////////////////////////////////
	 select=new JComboBox();
	 for(int i=0;i<serivces.size();i++) {
		 select.addItem(serivces.get(i));

	 }
	 
	 select.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {  select.getSelectedItem();}
		}
		 
	 });
/////////////////////////////////////////////
	 ok =new JButton("  OK  ");
	 ok.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			if(e.getSource()== ok) 
			{
				s= (Serivce) select.getSelectedItem();
				editSerivceDialog();
			}
			
			
			fr7.setVisible(false);
		}
		 
	 });
	 /////////////////////////////
 cancel =new JButton("  cancel  ");
 cancel.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		fr7.setVisible(false);
	}
	 
 });
	 //////////////////////////////////////
	 panel12=new JPanel();panel12.add(select);panel12.add(label);
	 panel13=new JPanel();panel13.add(ok);panel13.add(cancel);
	 fr7.add(panel12,BorderLayout.CENTER);
	fr7.add(panel13,BorderLayout.SOUTH);
     s= (Serivce) select.getSelectedItem();
	System.out.println(s);
	
	return s= (Serivce) select.getSelectedItem();
	
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Serivce selectEditeSerivceDialog() {
	
	
	
	 JFrame fr7= new JFrame();
	 fr7.setTitle("Select Serivce");
	 fr7.setSize(500, 200);
	 fr7.setVisible(true);
	fr7.setLayout(getLayout());
	fr7.setLocationRelativeTo(null);
	//////////////////////////
	 
	 JPanel panel12,panel13;	 
	 JLabel label;
	 JButton ok,cancel;
	 JComboBox select;
	 /////////////////////////
	
	 
	 ///////////////////////
	 label=new JLabel("Select Serivce");
	 ////////////////////////////////////////
	 select=new JComboBox();
	 for(int i=0;i<serivces.size();i++) {
		 select.addItem(serivces.get(i));

	 }
	 
	 select.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {  select.getSelectedItem();}
		}
		 
	 });
/////////////////////////////////////////////
	 ok =new JButton("  OK  ");
	 ok.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			if(e.getSource()== ok) 
			{
				s= (Serivce) select.getSelectedItem();
				editSerivceDialog();
			}
			
			
			fr7.setVisible(false);
		}
		 
	 });
	 /////////////////////////////
 cancel =new JButton("  cancel  ");
 cancel.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		fr7.setVisible(false);
	}
	 
 });
	 //////////////////////////////////////
	 panel12=new JPanel();panel12.add(select);panel12.add(label);
	 panel13=new JPanel();panel13.add(ok);panel13.add(cancel);
	 fr7.add(panel12,BorderLayout.CENTER);
	fr7.add(panel13,BorderLayout.SOUTH);
     s= (Serivce) select.getSelectedItem();
	System.out.println(s);
	
	return s= (Serivce) select.getSelectedItem();
	
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void deleteSerivceDialog() {
	
		 
		 	 JFrame fr8= new JFrame();
		 fr8.setTitle("DELETE SERIVCE");
		 fr8.setSize(400, 100);
		 fr8.setVisible(true);
		 fr8.setLocationRelativeTo(null);
		 JButton yes,no;
		 JPanel panel14,panel15;
		 JLabel label5;
		 
		 
		 
		 panel14=new JPanel();
		 label5=new JLabel("Are you sure you want to delete this serivce");
		 panel14.add(label5);
		 fr8.add(panel14,BorderLayout.CENTER);
		 
		 
		 
		 yes=new JButton("YES");
		 yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()== yes) serivces.remove(s);
				 fr8.setVisible(false);
				 JOptionPane.showMessageDialog(null, "Servse Deleted Successfully ");
			}
			 
		 });
		 
		 
		 no=new JButton("NO");
		 no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
	if(e.getSource() == no) fr8.setVisible(false);			
			}
			 
		 });
		
		 
		 panel15=new JPanel();panel15.add(yes);panel15.add(no);
		 
		 fr8.add(panel15,BorderLayout.SOUTH);
	
}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void editSerivceDialog() {
	
	
	
	 JFrame fr9= new JFrame();
	 fr9.setTitle("Edite Serivce");
	 fr9.setSize(300, 300);
	 fr9.setVisible(true);
	 fr9.setLayout(getLayout());
	 fr9.setLocationRelativeTo(null);
	 
	 String [] time= {"30 Minutes","20 Minutes","1 Hour","1.5Hour","2 Hour"};
	 
	 JPanel panel10,panel11;
	 JLabel nameSerivce,duration,price;
	 final JTextField  nameSe,pric;
	 JButton ok,cancel;
	 JComboBox durat;
	 
	 nameSerivce=new JLabel("Name:");    
	 duration=new JLabel("Duration:");
	 price=new JLabel("Price:");
	 
	 nameSe=new JTextField(s.getName(),10);
	 pric=new JTextField(String.valueOf(s.getPrice()),10);
	 
	 durat=new JComboBox(time);
	 durat.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) durat.getSelectedItem();
		}
		 
	 });
	 
	 
	 ok=new JButton("OK");
	 ok.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource()== ok) { s.setName(nameSe.getText()); s.setDuration((String) durat.getSelectedItem()); s.setPrice(Double.parseDouble(pric.getText()));

			System.out.println(serivces.getFirst());
			fr9.setVisible(false);
			 JOptionPane.showMessageDialog(null, "Servce Deleted Successfully ");
		}

		}	 
	 });
//////////////////////////////////////////	 
	 cancel=new JButton("Cancel");
	 cancel.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource()==cancel)fr9.setVisible(false);			
		}
		 
	 });
	 //////////////////
	 
 panel10=new JPanel(); panel10.add(nameSerivce);panel10.add(nameSe);panel10.add(duration);panel10.add(durat);panel10.add(price);panel10.add(pric);
panel11=new JPanel(); panel11.add(ok);panel11.add(cancel);
	 
	 
	 fr9.add(panel10,BorderLayout.CENTER);
	 fr9.add(panel11,BorderLayout.SOUTH);
	
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void viewCustomerDialog() {
	
	 JFrame fr10= new JFrame();
	 fr10.setTitle("View Customer");
	 fr10.setSize(300, 300);
	 fr10.setVisible(true);
	 fr10.setLayout(getLayout());
	 fr10.setLocationRelativeTo(null);
	
	
	JTextArea view;
	
	Customer typ3;
	String c=null;
	for(int i=0; i< customers.size();i++) {
		typ3= customers.get(i);
		c+=typ3.getName()+"\t"+typ3.getphoneNumber()+"\t"+typ3.getmemberhipType()+"\n";
		//view=new JTextArea(c);
	}
	
	view=new JTextArea(c);
	fr10.add(view);
	
}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void viewAppointment() {
	JFrame fr10= new JFrame();
	 fr10.setTitle("View Appoitment");
	 fr10.setSize(600, 300);
	 fr10.setVisible(true);
	 fr10.setLayout(getLayout());
	 fr10.setLocationRelativeTo(null);

	
	JTextArea view;
	
/*	Customer typ3;
	Serivce typ4 ;
	String c=null;
	for(int i=0; i< customers.size();i++) {
		typ3= customers.get(i);
		for(int j=0;j<=i;j++ ) {
			typ4=serivces.get(j);
			c+=typ3.getName()+"/"+typ3.getphoneNumber()+"/"+typ3.getmemberhipType()+"\t"+typ4.getName()+"/"+typ4.getDuration()+"/"+typ4.getPrice()+"\n";
		}

		//view=new JTextArea(c);
	}
	*/
	String c=null;
	for(int i=0; i<appointments.size();i++) {
		c+=appointments.get(i);
	}
	view=new JTextArea(c);
	fr10.add(view);
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public boolean addAppointment( Date da, String tim) {
if(customers.isEmpty()||serivces.isEmpty()) {JOptionPane.showMessageDialog(null,"NO Customers OR Serivces","Waraing Maessage",JOptionPane.WARNING_MESSAGE);return false;}

	Date date1=new Date();
	System.out.println("Hi");
	 JFrame fr11= new JFrame();
	 fr11.setTitle("Add Appointment");
	 fr11.setSize(400, 200);
	 fr11.setVisible(true);
	 fr11.setLayout(getLayout());
	 fr11.setLocationRelativeTo(null);

	 
	 JLabel custom,serivc,date,time;
	 JComboBox cust,ser;
	 JButton ok,cancel;
	 
	 custom=new JLabel("Customer:");
	 serivc=new JLabel("Serivce:");
	 date=new JLabel("Date"+dateFormat.format(da));
	 time=new JLabel("Time:"+tim);
	 
	 
	 
	 ok=new JButton("OK");
	 cancel=new JButton("Cancel");
	 
	 
	 cust=new JComboBox();
	 for(int i=0;i<customers.size();i++) {
		 cust.addItem(customers.get(i));
	 }
	 
	 cust.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED)  cust.getSelectedItem();
			
		}
		 
	 });
	 
	 ser=new JComboBox();
	 for(int i=0;i<serivces.size();i++) {
		 ser.addItem(serivces.get(i));
	 }
	 
	 ser.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) ser.getSelectedItem();			
		}
		 
	 });
	 
	
	 
	 
	 
	 
	 ok.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource() ==ok)	{	
	
	r=(Customer) cust.getSelectedItem();	s=(Serivce)ser.getSelectedItem();
	app=new Appointment(r,s,da,s.getPrice());
	appointments.add(app);
	a=true;
}
fr11.setVisible(false);
		}
		 
	 });
/////////////////
	 cancel.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource()==cancel) fr11.setVisible(false);			
		}
		 
	 });
	 
	 JPanel panel1=new JPanel(); panel1.add(custom);panel1.add(cust);panel1.add(serivc);panel1.add(ser);panel1.add(date);panel1.add(time);
JPanel panel2=new JPanel();panel2.add(ok);panel2.add(cancel);
fr11.add(panel1,BorderLayout.CENTER);
fr11.add(panel2,BorderLayout.SOUTH);
	 return a;
}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
		public void saveToFile() {
			Appointment app;
			
			File f=new File("outputToday.ser");
			
			try {
				output = new ObjectOutputStream(new FileOutputStream(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			try {
				
				for(int i=0; i<appointments.size();i++) {
					app=new Appointment (appointments.get(i).getCustomer(),appointments.get(i).getSerivce(),appointments.get(i).getDate(),appointments.get(i).getTotlprice());
					output.writeObject( app );
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 JOptionPane.showMessageDialog(null, "Save The Change  Successfully ");
		}
		
		
		
	
	
	
}
