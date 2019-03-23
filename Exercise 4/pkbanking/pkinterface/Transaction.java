package pkbanking.pkinterface;
import pkbanking.pkexception.InsufficientFundsException;

public interface Transaction 
{
	public double minbalance=500;
	public void withdraw(double a) throws InsufficientFundsException;
	public void deposit(double b) throws IllegalArgumentException;
}

