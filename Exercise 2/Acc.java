import java.util.Scanner;

abstract class Account
{
	protected 
	int accno;
	double balance;

	public
	Account()
	{
		accno=0;
		balance=0;
	}

	Account(int a, double b)
	{
		accno=a;
		balance = b;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
		
	}
}

class SBAccount extends Account
{

	public

	SBAccount(int a, double b)
	{
		super(a,b);
	}

	void deposit(double a)
	{
		balance =balance+ a;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
	}

	void withdraw(double b)
	{
		if((balance-b)>0)
		{
			balance =balance-b;
			System.out.println("The Account No is " + accno + " And the balance is " + balance );
		}
		else 
		{
			System.out.println("Not enough balance in the account");
		}
		
	}
	
	void calcint()
	{
		double interest;
		interest=balance*4/100;
		balance=balance+interest;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
	}

}

class FDAccount extends Account
{
	public int period;
	
	FDAccount(int acc, double balance, int per)
	{
		super(acc,balance);
		period=per;
		
	}

	double calcint()
	{
		double interest;
		interest = balance * 8.25/100;
		System.out.println("The Interest is " + interest);
		System.out.println(" for the Account No  " + accno + " And the balance is " + balance );
		return interest;
	
	}

	void close()
	{
		double interest = calcint();
		balance = balance + interest;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
	}


}

class Customer
{
	public int custid;
	String name, address;
	SBAccount sb;
	FDAccount fd;

	Customer(int cust, String n, String add)
	{
		custid= cust;
		name=n;
		address=add;
	}

	void createacc(int a)
	{
		Scanner scan= new Scanner(System.in);

		if(a==1)
		{
			int acc=scan.nextInt();
			double bal= scan.nextDouble();
			sb= new SBAccount(acc,bal);
		
		}
		else
		{
			int acc=scan.nextInt();
			double bal= scan.nextDouble();
			int per=scan.nextInt();
			fd= new FDAccount(acc,bal,per);
			
		}
	}

	void transaction()
	{
		sb.deposit(1000);
		sb.withdraw(500);
		sb.calcint();

		fd.calcint();
		fd.close();
	}
}
class BankDemo
{
	public static void main(String args[])
	{

		/*SBAccount s = new SBAccount(5,3000);
		s.deposit(5000);
		s.withdraw(1000);
		s.calcint();*/

		/*FDAccount fd = new FDAccount(10,4000,6);
		fd.calcint();
		fd.close();*/

		Customer cust[]= new Customer[2];
		
		for (int i=0; i<2;i++)
		{
			cust[i] = new Customer(10 , "Surya" ,"Neyveli ");
			cust[i].createacc(1);
			cust[i].createacc(2);
			cust[i].transaction();

		} 
		
	}
		
}
