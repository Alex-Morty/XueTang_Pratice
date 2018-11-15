package com.NewCode;

public class Main implements Runnable {  
		  
	    int id;  
	    static int num = 1;  
	  
	    public Main(int id) {  
	        this.id = id;  
	    }  
	  
	    @Override  
	    public void run() {  
	        synchronized (Main.class)
	        {  
	            while (num <= 10) {  
	                if (num  % 2 == id) {   
	                    System.out.print(num++ + ",");   
	                    Main.class.notifyAll();  
	                } else {  
	                    try {  
	                        Main.class.wait();  
	                    } catch (InterruptedException e) {  
	                        e.printStackTrace();  
	                    }  
	                }  
	            }  
	        }  
	    }  
	  
	    public static void main(String[] args) {  
	  	    new Thread(new Main(0)).start();  
	        new Thread(new Main(1)).start();  
	        
	    }  
	}  
