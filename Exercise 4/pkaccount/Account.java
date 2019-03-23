package pkaccount;
import pkbanking.pkexception.InsufficientFundsException;

abstract public class Account
{

	public int accno;
	public double balance;

	public
	Account()
	{
		accno=0;
		balance=0;
	}

	public Account(int a, double b)
	{
		accno=a;
		balance = b;
		System.out.println("The Account No is " + accno + " And the balance is " + balance );
		
	}

	public void deposit(double a){}
	public void withdraw(double b) throws  InsufficientFundsException{}
	public void calcint1(){}
	public double calcint(){return 0;}
	public void close(){}
}