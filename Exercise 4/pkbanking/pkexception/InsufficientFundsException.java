package pkbanking.pkexception;

public class InsufficientFundsException extends Exception
{
	String description;

	public InsufficientFundsException()
	{
		description="Insufficient Funds";
	}

	public InsufficientFundsException(String a)
	{
		description=a;
	}
	
	public String toString()
	{
		return description;
	}
}