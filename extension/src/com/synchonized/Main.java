package com.synchonized;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tickets T = new Tickets(10);
		
		 new Consumer(T).start();
		new Producer(T).start();
		
	}

}
class Tickets{
	int number = 0 ;
	int size;
	boolean available =false;
	public Tickets(int size)
	{
		this.size=size;
	}
}
class Producer extends Thread{
	Tickets tickets =null;
	 public Producer(Tickets tickets) 
	 {
		// TODO Auto-generated constructor stub
		 this.tickets=tickets;
	}
	 @Override
	public void run() {
		// TODO Auto-generated method stub
		while(tickets.number <tickets.size) {
		
			synchronized (tickets) {
			System.out.println("Producer put ticket"+(++tickets.number));
			tickets.available =true;	
			}
			
			
		}
		//super.run();
	}
}
class Consumer extends Thread{
	Tickets tickets = null;
	int i =0 ;
	public Consumer(Tickets tickets) {
		this.tickets=tickets;
	}
	@Override
	public void run() {
		while(i<tickets.size) {
		
			synchronized (tickets) {
			if(tickets.available == true && i<= tickets.number) {
				System.out.println("Consumer buys ticket"+(++i));
			}
			if(i==tickets.number) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				tickets.available =false;
				System.out.println("no more tickets");
			}
		}
		
		
		}
		
	}
}
