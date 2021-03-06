package com.url;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
/*
 * 数据报服务器线程
 * 
 * */
public class QuoteServerThread extends Thread {
	protected DatagramSocket socket =null;
	protected BufferedReader in =null;
	protected boolean moreQuotes =true;
	public QuoteServerThread ()throws IOException{
		this("QuoteServerThread");
	}
	public QuoteServerThread(String name)throws IOException{
		super(name);
		socket=new DatagramSocket(4445);
		try {
			in= new BufferedReader(new FileReader("one-liners.txt"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public String getNextQuote() {
		String returnValue = null;
		try {
			if((returnValue = in.readLine())==null) {
				in.close();
				moreQuotes=false;
				returnValue ="no more  quotes.goodbye";
			}
		} catch (Exception e) {
			// TODO: handle exception
			returnValue = "IOException occurred in server";
		}
		return returnValue;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public void run() {
		while(moreQuotes) {
			try {
				byte[] buf = new byte[256];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String dString =  null;
				if(in==null) dString = new Date().toString();
				else dString = getNextQuote();
				buf=dString.getBytes();
				
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buf, buf.length,address,port);
				socket.send(packet);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				moreQuotes =false;
			}
			socket.close();
		}
	}

}
