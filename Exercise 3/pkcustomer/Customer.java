package pkcustomer;

import java.util.Scanner;
import pkaccount.sb.*;
import pkaccount.fd.*;

public class Customer
{
	public int custid;
	public String name, address;
	SBAccount sb;
	FDAccount fd;

	public Customer(int cust, String n, String add)
	{
		custid= cust;
		name=n;
		address=add;
	}

	public void createacc(int a)
	{
		Scanner scan= new Scanner(System.in);

		if(a==1)
		{
			System.out.println("Enter Account NO : ");
			int acc=scan.nextInt();
			System.out.println("Enter Balance: ");
			double bal= scan.nextDouble();
			
			sb= new SBAccount(acc,bal);
		
		}
		else
		{
			System.out.println("Enter Account NO : ");
			int acc=scan.nextInt();
			System.out.println("Enter Balance : ");
			double bal= scan.nextDouble();
			System.out.println("Enter Period : ");
			int per=scan.nextInt();
			fd= new FDAccount(acc,bal,per);
			
		}
	}

	public void transaction()
	{
		sb.deposit(1000);
		sb.withdraw(500);
		sb.calcint1();

		fd.calcint();
		fd.close();
	}
}