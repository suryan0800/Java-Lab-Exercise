import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/* <applet>
 * code = "WaterTank.class" width = 300 height = 300>
 * <param name =fontname value = Courier>
 * </applet>
 */

public class WaterTank extends Applet implements Runnable,ActionListener{
	int x,y,w,h,i;
	Thread t;
	Button star,stop,resume;
	Boolean flag;
	
	public void init()
	{
		x = 11;
		y = 140;
		w = 89;
		h = 10;
		i = 0;
		star = new Button("Start");
		stop = new Button("Stop");
		resume = new Button("Resume");
		
		setLayout(new FlowLayout());
		
		add(star);
		add(stop);
		add(resume);
		
		star.addActionListener(this);
		stop.addActionListener(this);
		resume.addActionListener(this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String s = a.getActionCommand();
		
		switch(s)
		{
		case "Start": 
			
		
			start();
			t.start();
			
			break;
			
		case "Stop":
			
			flag = false;
			break;
			
		case "Resume":
			flag = true;
			
			break;
			
		}
	
	}
	
	
	public void start()
	{
		x = 11;
		y = 140;
		w = 89;
		h = 10;
		i = 0;
		flag = true;
		t = new Thread(this);
		
	
		
	
		
		
	}
	
	public void run()
	{
		synchronized(this)
		{
		
		for(i = 0;i<17;i++)
		{
			while(!flag)
			{
				try
				{
				wait(250);
				
				}
				catch(InterruptedException e)
				{
					
				}
			}
			if(i ==16)
			{
				i = 0;
				y = 140;
				h = 10;
				
			}
			repaint();
			try
			{
				Thread.sleep(500);
				
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			y = y -5;
			h = h +5;
		}
		}
	}
	
	public void paint(Graphics g)
	{
			g.setColor(Color.black);
			g.drawLine(10,50,10,150);
			g.drawLine(10, 150,100, 150);
			g.drawLine(100, 150, 100, 50);
			g.setColor(Color.blue);
			g.fillRect(x,y,w,h);
			
		
	}
	
	
	
}
