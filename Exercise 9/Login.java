import java.awt.*;
import java.awt.event.*;



public class Login extends Frame implements ActionListener{
	Button ok,cancel;
	Label sastra,user,pass,rest;
	TextField user1,pass1;
	TextField result;
	
	Login()
	{
		super("Login");
		
		ok = new Button("Ok");
		cancel = new Button("Cancel");
		sastra = new Label("SASTRA University Login");
		user = new Label("Enter User Name");
		pass = new Label("Enter Password");
		rest = new Label("Result :          ");
		user1 = new TextField(20);
		pass1 = new TextField(20);
		result  = new TextField(20);
		
		pass1.setEchoChar('*');
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(sastra);
		
		add(user);
		add(user1);
		
		add(pass);
		add(pass1);
		
		add(ok);
		add(cancel);
		
		add(rest);
		add(result);
		
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String str = e.getActionCommand();
		
		switch(str)
		{
		case "Ok":
			String usr = user1.getText();
			String pss = pass1.getText();
			
			
			
			if(usr.contentEquals("Admin"))
			{
				if(pss.contentEquals("pass"))
				{
					result.setText("You are Logged In");
				}
				else
				{
					result.setText("Wrong PassWord");
				}
			}
			else
			{
				result.setText("Wrong User");
			}
			break;
			
		case "Cancel":
			user1.setText("");
			pass1.setText("");
			result.setText("Canceled");
		}
		
	}
	
	public static void main(String args[])
	{
		Login l = new Login();
		l.setSize(200,300);
		l.setBackground(Color.lightGray);
		l.setVisible(true);
		
	}

}
