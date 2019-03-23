import java.awt.*;
import java.awt.event.*;


public class Calculator extends Frame implements ActionListener
{
	TextField display;
	Button but[] = new Button[24];
	String parse,butname[];
	double memory;
	String operator;
	
	
	Calculator()
	{
		super("Calculator");
		
		memory = 0;
		
		
		display = new TextField(20);
		display.setText("0.0");
		
		String name[] = {"M+","M-","MC","MR",
						 "C","CE","<-","Sqrt",
						 "1","2","3","+",
						 "4","5","6","-",
						 "7","8","9","*",
						 "0",".","=","/"};
		
		butname = name;
		
		for(int i = 0;i<24;i++)
		{
			but[i] = new Button(butname[i]);					
		}
		
		
		
		
		setLayout(new BorderLayout(5,5));
		Panel p = new Panel(new GridLayout(6,4,5,5));
		
		for(int i = 0;i<24; i++)
		{
			p.add(but[i]);
		}
		
		add(display,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		for(int i = 0 ;i<24; i++)
		{
			but[i].addActionListener(this);
		}
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String str = a.getActionCommand();
		double calc = 0;
	
		
		
		
		if(str.contentEquals("M+"))
		{
			calc = Double.parseDouble(display.getText());
			memory = memory + calc;
		}
			
		else if(str.contentEquals("M-"))
		{
			calc = Double.parseDouble(display.getText());
			memory = memory-calc;
		}
			
		else if(str.contentEquals("MC"))
		{
			memory = 0;
		}
			
		else if(str.contentEquals("MR"))
		{
			display.setText(""+memory);
		}
			
			
		else if(str.contentEquals("C"))
		{
			
			memory = 0;
			display.setText("0.0");
		}
			
		else if(str.contentEquals("CE"))
		{
			display.setText("0.0");
		}
			
		else if(str.contentEquals("<-"))
		{
			display.setText
			(display.getText().substring
			(0,display.getText().length()-1));
		}
			
		else if(str.contentEquals("Sqrt"))
		{

			memory = Math.sqrt
					(Double.parseDouble(display.getText()));
			display.setText(""+ memory);
		}
			
		else if(str.contentEquals("."))
		{
			display.setText(display.getText() + ".");
		}
			
		else if(str.contentEquals("+"))
		{
			memory = Double.parseDouble(display.getText());
			operator = "+";
			
			display.setText("0.0");
			
		}
			
		else if(str.contentEquals("-"))
		{
	
		
			memory = Double.parseDouble(display.getText());
		
			operator = "-";
			display.setText("0.0");
		}
			
		else if(str.contentEquals("*"))
		{
			memory = Double.parseDouble(display.getText());
			operator = "*";
			display.setText("0.0");
		}
			
		else if(str.contentEquals("/"))
		{
			memory = Double.parseDouble(display.getText());
			operator = "/";
			display.setText("0.0");
		}
			
		else if(str.contentEquals("="))
		{
			calc = Double.parseDouble(display.getText());
			
			if(operator == "+")
			{
				memory = memory + calc;
			}
			
			if(operator == "-")
			{
				memory = memory - calc;
			}
			
			if(operator == "*")
			{
				memory = memory * calc;
			}
			
			if(operator == "/")
			{
				memory = memory / calc;
			}
			
			
			display.setText("" + memory);
		}
			
		else
		{
			if(!display.getText().contentEquals("0.0"))
			{
			display.setText(display.getText() + str);
			}
			else
			{
				display.setText(str);
			}
											
		}
	}
	
	
	
	public static void main(String args[])
	{
		Calculator c = new Calculator();
		
		c.setSize(200,300);
		c.setBackground(Color.darkGray);
		c.setVisible(true);
		
		
	}

	

}
