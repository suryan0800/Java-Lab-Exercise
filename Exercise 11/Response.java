import java.awt.event.*;

import java.awt.*;
import java.io.*;

public class Response extends Frame implements ActionListener{
	
	Label reg,nam,gend,deg,bran,yer,db,add,emal,curr,ent;
	Button submit,cancel;
	TextField regno,name,email,address;
	List activities;
	Choice degree,branch,study,year,month,date;
	TextArea entered;
	Checkbox hobby,stamp,novel,tennis,male,female;
	CheckboxGroup g;

	
	String result;

	BufferedWriter fp;
	
	
	Response(String st)
	{
		super(st);
		
		
		submit = new Button("Submit");
		cancel = new Button("Cancel");
		
		reg = new Label("Register No.");
		nam = new Label("Name ");
		gend = new Label("Gender ");
		deg = new Label("Degree ");
		bran = new Label("Branch");
		yer = new Label("Year of Study");
		db = new Label("Date of Birth");
		add = new Label("Address");
		emal = new Label("E-Mail ID");
		
		curr = new Label("Extra Curriculum Activities");
		ent = new Label("You Entered");
		
		regno = new TextField(20);
		name = new TextField(20);
		email = new TextField(20);
		
		address = new TextField(50);
		entered = new TextArea(20,50);
		
		activities = new List(3,false);
		activities.add("Tennis");
		activities.add("Cricket");
		activities.add("Basket Ball");
		
		degree = new Choice();
		degree.add("B.Tech");
		degree.add("M.Tech");
		
		branch = new Choice();
		branch.add("CSE");
		branch.add("IT");
		
		study = new Choice();
		study.add("1st Year");
		study.add("2nd Year");
		study.add("3rd Year");
		study.add("4th Year");
		
		date = new Choice();
		for(int i = 1;i<=31;i++)
		{
			String str = String.valueOf(i);
			date.add(str);
		}
		
		year = new Choice();
		for(int i = 1990; i <=2005; i++)
		{
			String str = String.valueOf(i);
			year.add(str);
		}
		
		month = new Choice();
		for(int i = 1; i<=12; i++)
		{
			String str = String.valueOf(i);
			month.add(str);
		}
		
		hobby = new Checkbox("Hobby");
		stamp = new Checkbox("Stamp Collection");
		novel = new Checkbox("Reading Novels");
		tennis = new Checkbox("Playing Tennis");
		
		g = new CheckboxGroup();
		male = new Checkbox("Male",g,true);
		female = new Checkbox("Female",g,false);
		
		
		
		setLayout(null);
		
		
		
		add(reg);
		reg.setBounds(10,80,100,30);
		add(regno);
		regno.setBounds(150,80,150,30);
		
		add(nam);
		nam.setBounds(400,80,100,30);
		add(name);
		name.setBounds(550,80,150,30);
		
		
		add(gend);
		gend.setBounds(10,140,100,30);
		add(male);
		male.setBounds(150,140,100,30);
		add(female);
		female.setBounds(250,140,100,30);
		
		add(db);
		db.setBounds(10,200,100,30);
		add(date);
		date.setBounds(150,200,50,30);
		add(month);
		month.setBounds(250,200,70,30);
		add(year);
		year.setBounds(350,200,100,30);
		
	
		
		
		add(add);
		add.setBounds(10,260,100,30);
		add(address);
		address.setBounds(150,260,200,30);
		
		add(emal);
		emal.setBounds(400,260,100,30);
		add(email);
		email.setBounds(550,260,150,30);
			
		add(hobby);
		hobby.setBounds(10,320,100,30);
		add(stamp);
		stamp.setBounds(150,320,150,30);
		add(novel);
		novel.setBounds(350,320,150,30);
		add(tennis);
		tennis.setBounds(550,320,150,30);
		
		
		
		add(curr);
		curr.setBounds(10,380,250,30);
		add(activities);
		activities.setBounds(300,380,150,60);
		
	
		add(deg);
		deg.setBounds(10,460,100,30);
		add(degree);
		degree.setBounds(150,460,100,30);
		
		add(bran);
		bran.setBounds(300,460,100,30);
		add(branch);
		branch.setBounds(400,460,100,30);
		
		add(yer);
		yer.setBounds(550,460,100,30);
		add(study);
		study.setBounds(650,460,100,30);

		add(ent);
		ent.setBounds(10,500,100,30);
		add(entered);
		entered.setBounds(150,500,300,150);
		
		
		add(submit);
		submit.setBounds(10,700,100,30);
		add(cancel);
		cancel.setBounds(150,700,100,30);
		
		
		
	
		
		
		
		

	
		
		
		
		submit.addActionListener(this);
		cancel.addActionListener(this);
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		Object o = a.getSource();
		
		
		if(o == submit)
		{
			
				
			try
			{
				Integer.parseInt(regno.getText());
			}
			catch(NumberFormatException e)
			{
				result = "Not a valid Register Number";
				entered.setText(result);
				return;
			}
			
			
			result = null;
			if(name.getText().isEmpty())
			{
				result = "Name Field cannot be Empty";
				entered.setText(result);
				return;
			}
			
			if(address.getText().isEmpty())
			{
				result = "Address Field cannot be Empty";
				entered.setText(result);
				return;
			}
			
			String s1 = email.getText();
			if(s1.indexOf('@') == -1)
			{
				result = "Not a Proper Email Id";
				entered.setText(result);
				return;
				
			}
			
			result = ("Your Reg NO : " + regno.getText() + "\n" +
			"Your Name : " + name.getText() + "\n") ;
			
			
			if(male.getState())
			{
				result = (result + "You are Male" + "\n");
			}
			else
			{
				result = (result + "You are Female" + "\n");
			}
			
			result = (result + "Your Date of Birth : " + date.getSelectedItem() 
			+ " " + month.getSelectedItem() + " " + year.getSelectedItem() + "\n");
			
			result = (result + "Your Address : " + address.getText() + "\n");
			
			result = (result + "Your Email Id : " + email.getText() + "\n");
			
			if(hobby.getState())
			{
				result = (result + "You hava a Hobby " + "\n");
				
			}
			
			if(stamp.getState())
			{
				result = (result + "You collect Stamps " + "\n");
			}
			
			if(novel.getState())
			{
				result = (result + "You read Novels " + "\n");
			}
			
			if(tennis.getState())
			{
				result = (result + "I Play Tennis " + "\n");
			}
			
			result = (result + "Extra Curricular Activities : " 
			+ activities.getSelectedItem()+ "\n");
			
			result = (result + "Your Degree : " + degree.getSelectedItem() + "\n");
				
			result = (result + "Your Branch : " + branch.getSelectedItem()+ "\n");
			
			result = (result + "Year of Study : " + study.getSelectedItem()+ "\n");
			
			entered.setText(result);
			result = result + "\n" + "\n";
			try {
				fp = new BufferedWriter(new FileWriter("Response.txt",true));
				fp.write(result);
			
				fp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		if(o == cancel)
		{
		result = null;
		entered.setText("");
		regno.setText("");
		name.setText("");
		address.setText("");
		email.setText("");
		}
	}
	
	public static void main(String args[])
	{
		Response r = new Response("Student Response Form");
		
		r.setSize(800,800);
		r.setBackground(Color.lightGray);
		r.setVisible(true);
		
	}

}
