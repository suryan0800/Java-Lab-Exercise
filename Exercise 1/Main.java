class Point
{
	public
	double x,y;
	
	Point()
	{
	x=0;
	y=0;
	}
	
	Point(double a,double b)
	{
	x=a;
	y=b;
	}
	
	Point( Point c)
	{
	x=c.x;
	y=c.y;
	}
	
	void FindDistance(double a, double b)
	{
	double f=Math.sqrt(Math.pow((x-a),2)+Math.pow((y-b),2));
	System.out.println("The Distance between these Points are " + f);
	}

	void FindDistance(Point c)
	{
	double f=Math.sqrt(Math.pow((x-c.x),2)+Math.pow((y-c.y),2));
	System.out.println("The Distance between these Points are " + f);
	}

	void display()
	{
	System.out.println("("+x + " ," + y+")");
	}

}

class Main
{
	public static void main(String args[])
	{
	Point p1=new Point(3.25,7.89);
	Point p2=new Point(5.37,18.12);
	Point p3=new Point(p2);
	p1.FindDistance(7.9,16.25);
	p1.FindDistance(p3);
	p1.display();
	p2.display();
	}
}
