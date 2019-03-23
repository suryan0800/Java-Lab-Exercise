package pkbanking.pkinterface;

public interface Transaction
{
	public double minbalance=500;
	public void withdraw(double a);
	public void deposit(double b);
}

