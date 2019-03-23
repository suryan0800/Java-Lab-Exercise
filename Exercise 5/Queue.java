class Queue 
{
    
    int arr[];
    int front;
    int rear;
    boolean  full;
    boolean empty;
    
    Queue()
    {
        arr = new int[10];
       
        front = -1;
        rear = -1;
        full = false;
        empty= true;
    }
    
    synchronized int get()
    {
    	
    	try
    	{
    	
    	if(empty || front > rear)
    	{
    	
    	wait(500);
    	
    	
    	return front;
    	}
    	
    	}
    	catch ( InterruptedException e)
    	{
    	System.out.println(e);
    	}
    	
    	
    	System.out.println("Got : " + arr[front]);
    	front++;
    	
    	
    	if(front > rear)
    	{
    		empty = true;
    	}
    	notify();
    	return front;
        
    }
    
    synchronized void put(int n)
    {
    	
    	
    	
    	if(full)
    	{
    	notify();
    	return ;
    	}
    	
    	
    	
    	
    	
		if(rear<9)
		{
			if(front == -1)
			{
			front++;
			}
			
			empty = false;
			
			rear++;
			arr[rear]= n;
			System.out.println("Put : " + n);
				
		}  
		
		else 
		{
			
			full = true;
			
		}
	
    	
    	notify();
    	    	
    }
    
}

class Producer implements Runnable
{
	Queue q;
	Thread t;
	int n;
	
	Producer(Queue q)
	{
		this.q= q;
		n=0;
		t = new Thread(this,"Producer");
		t.start();
	}
	
	public void run()
	{
		try
		{
			for(n=0;n<10;n++)
			{
				q.put(n);
				t.sleep(1000);
			}
			
			
		}
		catch(InterruptedException e)
		{
		System.out.println(e);
		}
		
		
	}
	
}

class Consumer implements Runnable
{
	Queue q;
	Thread t;
	int n;
	
	Consumer(Queue q)
	{
		this.q = q;
	
		t = new Thread(this,"Consumer");
		t.start();
	}
	
	public void run()
	{
		try
		{
		n=0;
			for(;n<10;)
			{
				
				n= q.get();
				
				t.sleep(500);
			}
		}
		catch(InterruptedException e)
		{
		System.out.println(e);
		}
		
		
	}
	
}

class Demo
{
	public static void main(String args[])
	{
		Queue q = new Queue();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		try
		{
		System.out.println("Hello");
		p.t.join();
		c.t.join();
		System.out.println("Hell");
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
		System.out.println("End ");
		
	}
}

