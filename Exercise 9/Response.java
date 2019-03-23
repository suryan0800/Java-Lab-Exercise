import java.awt.event.*;

import java.awt.*;

public class Response extends Frame implements ActionListener{
	
	Label reg,nam,gend,deg,bran,yer,db,add,emal,curr,ent;
	Button submit,cancel;
	TextField regno,name,email,address;
	List activities;
	Choice degree,branch,study,year,month,date;
	TextArea entered;
	Checkbox hobby,stamp,novel,tennis,male,female;
	CheckboxGroup g;
	
	Panel self,about,act,contact,college,service,all;
	
	String result;

	
	
	
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
		
		
		
		
		self = new Panel();
	
		
		
		
		self.add(reg);
		self.add(regno);
		
		self.add(nam);
		self.add(name);
		
		about = new Panel();
		
		about.add(gend);
		about.add(male);
		about.add(female);
		
		about.add(db);
		about.add(date);
		about.add(month);
		about.add(year);
		
		contact = new Panel();
		
		
		contact.add(add);
		contact.add(address);
		
		contact.add(emal);
		contact.add(email);
		
		act = new Panel();
		
		
		act.add(hobby);
		act.add(stamp);
		act.add(novel);
		act.add(tennis);
		
		
		
		act.add(curr);
		act.add(activities);
		
		college = new Panel();
		
		college.add(deg);
		college.add(degree);
		
		college.add(bran);
		college.add(branch);
		
		
		college.add(yer);
		college.add(study);
		
		
		service = new Panel();

		service.add(ent);
		service.add(entered);
		
		
		service.add(submit);
		service.add(cancel);
		
		
		
		all = new Panel();
		
		all.add(self);
		all.add(about);
		all.add(contact);
		all.add(act);
		all.add(college);
		all.add(service);
		
		
		add(all);
	
		
		
		
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
		
		r.setSize(800,700);
		r.setBackground(Color.lightGray);
		r.setVisible(true);
		
	}

}
