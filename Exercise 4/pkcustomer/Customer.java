package pkcustomer;

import java.util.Scanner;
import pkaccount.sb.*;
import pkaccount.fd.*;
import pkbanking.pkexception.InsufficientFundsException;

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

	public void transaction(int a)
	{
		Scanner scan= new Scanner(System.in);
		try
		{
		switch(a)
		{
		case 1: 
		System.out.println("Enter the Deposit Amount : \n");
		double amount = scan.nextDouble();
		sb.deposit(amount);
		break;
		
		case 2:
		System.out.println("Enter the Withdrawal Amount : \n");
		double amt = scan.nextDouble();
		sb.withdraw(amt);
		break;

		case 3:
		sb.calcint1();
		break;
		
        case 4:
		fd.calcint();
		fd.close();
		break;
		
		default:
		System.out.println("Not a valid Choice \n");
		}
		}
		catch(InsufficientFundsException e)
		{
		System.out.println(e);
		}
		catch(IllegalArgumentException e)
		{
		System.out.println(e);
		}
	}
}
