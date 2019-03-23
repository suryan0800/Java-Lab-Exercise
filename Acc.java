class Account
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

	Account(int a,double b)
	{
	accno=a;
	balance = b;
	}
}

public class SBAccount extends Account
{

	public

	SBAccount(int a,double b)
	{
	super(a,b);
	}

	void deposit(double a)
	{
	super.balance =super.balance+ a;
	}

	void withdraw(double b)
	{
	super.balance =super.balance-b;
	}
	