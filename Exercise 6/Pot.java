import java.util.Scanner;
import java.util.*;


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

	Point(Point c)
	{
	x=c.x;
	y=c.y;
	}

	void FindDistance(double a,double b)
	{
	double f=Math.sqrt(Math.pow((x-a),2)+Math.pow((y-b),2));
	System.out.println(f);
	}

	void FindDistance(Point a)
	{
	double f=Math.sqrt(Math.pow((x-a.x),2)+Math.pow((y-a.y),2));
	System.out.println(f);
	}


	void Display()
	{
	System.out.println(x);
	System.out.println(y);
	}
	
	public String toString()
	{
	return ("X : " + x + "Y : " + y );
	}
	
}

class Pot
{
	public static void main(String args[])
	{
	Scanner scan = new Scanner(System.in);
	double x,y;
	ArrayList<Point> a = new ArrayList<Point>();
	

	for(int i =0; i<5;i++)
	{
		System.out.println("Enter x value");

		x=scan.nextDouble();

		System.out.println("Enter y value");

		y=scan.nextDouble();
		a.add( new Point(x,y));
	}

	System.out.println(a);
	
	for(int i = 0; i<a.size()-1; i++)
	{
		for(int j = i +1 ; j<a.size();j++)
		{
			Point p1 = a.get(i);
			Point p4 = a.get(j);
			
			p1.FindDistance(p4);
			
		}
	}
	
	

	}
}

