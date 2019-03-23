import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;



class Point implements Comparable
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

	double FindDistance(double a,double b)
	{
	double f=Math.sqrt(Math.pow((x-a),2)+Math.pow((y-b),2));

	return f;
	
	}

	double FindDistance(Point a)
	{
	double f=Math.sqrt(Math.pow((x-a.x),2)+Math.pow((y-a.y),2));
	return f;
	}


	void Display()
	{
	System.out.println(x);
	System.out.println(y);
	}
	
	public String toString()
	{
	return ("X : " + x + " Y : " + y );
	}
	
	public int compareTo(Object p)
	{
		
		double d1 = FindDistance(0,0);
		Point p1 = (Point)p;
		double d2 = p1.FindDistance(0,0);
		
		return (int)(d1-d2);
	}
	
}


class MyComp implements Comparator<Point> 
{
	public int compare(Point a,Point b)
	{
		
		
		double d1 = a.FindDistance(0,0);
		double d2 = b.FindDistance(0,0);
		return (int)(d1-d2);
		
	}
}
class Pot
{
	public static void main(String args[])
	{
	Scanner scan = new Scanner(System.in);
	double x,y;
	HashSet<Point> a = new HashSet<Point>();
	

	for(int i =0; i<5;i++)
	{
		System.out.println("Enter x value");

		x=scan.nextDouble();

		System.out.println("Enter y value");

		y=scan.nextDouble();
		a.add( new Point(x,y));
	}

	System.out.println(a);
	
	ArrayList<Point> aa = new ArrayList<Point>(a);
	
	
	Collections.sort(aa,new MyComp());
	
	System.out.println("After Sorted" );
	System.out.println(aa);
	
	}
	
	
	
}

