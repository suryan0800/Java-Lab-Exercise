import pkcustomer.Customer;


class BankDemo
{
	public static void main(String args[])
	{

		/*Account s = new SBAccount(5,3000);
		s.deposit(5000);
		s.withdraw(1000);
		s.calcint1();

		Account fd = new FDAccount(10,4000,6);
		fd.calcint();
		fd.close(); */

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
