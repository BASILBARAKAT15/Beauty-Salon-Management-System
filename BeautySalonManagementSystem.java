package packag2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
//import java.util.Scanner;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Scanner;

import javax.swing.* ;

public class BeautySalonManagementSystem extends JFrame{
	

	public static void main(String[] args) {
		
		BeautySalonGUI z= new BeautySalonGUI();
		Customer r=null;
		Serivce s=null;
	//	z.addAppointment();
		JFrame main =new JFrame();
		 main.setTitle("Beauty Salon Management System");
		 main.setSize(1000,600);
		 main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 main.setVisible(true);
		 main.setLocationRelativeTo(null);
	//	 main.setLayout(new FlowLayout());
		 
 String [] function= {"Add Customer","Edite Customer","Delet Customer","Add Serivce","Edite Serivce","Delete Serivce","view Appointments","View Customer","Save The Change"};
		
 
        JButton[] button=new JButton[function.length];
		JPanel keys=new JPanel();
		keys.setLayout(new GridLayout(4,2));
	
		for(int i=0 ; i<function.length ; i++) {
			
			button[i]=new JButton(function[i]);
			button[i].setSize(100,100);
			//button[i].setBackground(Color.ORANGE);
			keys.add(button[i]);
			
		}
		/////////////////////////////////////////////////////////////////////////Add Customer Dialog
		
		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
if(e.getSource() == button[0]) {z.addCustomerDialog();}				
			}
			
		});
/////////////////////////////////////////////////////////////////////////////////Edite Customer Dialog
		
		button[1].addActionListener(new ActionListener() {
		 Customer r=null;
		 
			@Override
			public void actionPerformed(ActionEvent e) {
if(e.getSource() == button[1])
	
	z. selectEditCustomerDialoge();
	

			}
			
		});
	/////////////////////////////////////////////////////////////////////////////Delete Customer
		button[2].addActionListener(new ActionListener() {
			Customer r=null;
			@Override
			public void actionPerformed(ActionEvent e) {
if(e.getSource() == button[2])
	
	z.selsctedDeleteCustomerDialog();
			
			}
			
		});
/////////////////////////////////////////////////////////////////////////////Add Serivce
		button[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
if(e.getSource() == button[3])z.addSerivceDialog();				
			}
			
		});
///////////////////////////////////////////////////////////////////////////Edite Serivce
		 
		button[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				z. selectEditeSerivceDialog();
			}
			
		});
		///////////////////////////////////////////////////////////////////Delete Serivce
		button[5].addActionListener(new ActionListener() {
			Serivce s1=null;
			@Override
			public void actionPerformed(ActionEvent e) {
				z.selectDeletSerivceDialod();

			
			}
		});	
		///////////////////////////////////////////////////////////////////view Appointment
		button[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
z.viewAppointment();				
			}
			
		});
		///////////////////////////////////////////////////////////////////View Customer
		button[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
if(e.getSource() == button[7])z.viewCustomerDialog();				
			}
			
		});
////////////////////////////////////////////////////////////////////////////////	
	button[8].addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button[8])	z.saveToFile();		
		}
		
	});
/////////////////////////////////////////////////////////////////////////////		
JPanel date=new JPanel();
//JLabel label = new JLabel(" Date");
//date.add(label);
date.setLayout(new GridLayout(8,7));
String [] times={"9:00","10:00","11:00","12:00","1:00","2:00","3:00","4:00","5:00"};
String [] days = z.getDate();
for(String str : days)
{
	date.add(new JLabel(str, SwingConstants.CENTER));
}

JButton[][] button1=new JButton[7][7];
for(int i=0; i<7;i++) {
	int a=i;
	for(int j=0; j<7 ;j++) {
		int b=j;
	button1[i][j] =new JButton(times[i]);
	button1[i][j].setSize(100,100);
	button1[i][j].setBackground(Color.GREEN);
	date.add(button1[i][j]);
	///////////
	button1[i][j].addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean v;
		v=	z.addAppointment(Date.valueOf(days[a]),times[a]);
		if(v)	button1[a][b].setBackground(Color.RED);
		}
		
	});
	/////////
	
	}
}

/*for(int i=0; i<7 ;i++) {
	for(int j=0; j<7; j++) {

		button1[i]=new JButton(times[i]);
		//button1[i].set
		button1[i].setSize(100,100);
		date.add(button1[i]);
		button1[i].setBackground(Color.GREEN);
		
		
		button1[i].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button1[0]) {z.addAppointment();	button1[1].setBackground(Color.RED);}		
			}
			
		});
	
	}
}
	*/
		main.add(date,BorderLayout.CENTER);
		main.add(keys,BorderLayout.WEST);
		
		
		
	
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	
		
	BeautySalonGUI z= new BeautySalonGUI();
		
		Scanner input = new Scanner(System.in);
		int c;
		Customer r=null;
		Serivce s=null;
		c=input.nextInt();
		while(c !=11) {
			
		switch(c) {
		case 1:z.addCustomerDialog();
		break;
		
		
		
		case 2:
		z.editCustomerDialog();
		break;
		
		
		case 3: z.deleteCustomerDialog();
		break;
		
		
		case 4:r=z.selectCustomerDialoge();break;
		
		case 5:z.deleteCustomerDialog();break;
		
		
		case 6:z.addSerivceDialog();break;
		
		case 7:s=z.selectSerivceDialog();break;
		
		case 8:z.deleteSerivceDialog();break;
		
		case 9: z.editSerivceDialog();
		
		case 10:z.viewCustomerDialog();
		
		
		
		
		}
		c=input.nextInt();

		}
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
