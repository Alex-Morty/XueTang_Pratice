package com.url;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;


public class MulticastServerThread extends QuoteServerThread{
	private long FIVE_SECOND = 5000;
	public MulticastServerThread()throws IOException{
		super("MulticastServerThread");
	}
	public void run() {
		while (moreQuotes) {
			try {
				byte[] buf = new byte[256];
				
				String dString = null ;
				if(in==null) dString = new Date().toString();
				else dString = getNextQuote();
				buf = dString.getBytes();
				InetAddress group = InetAddress.getByName("230.0.0.1");
				DatagramPacket packet = new DatagramPacket(buf, buf.length,group,4446);
				socket.send(packet);
				try {
					sleep((long)(Math.random()*FIVE_SECOND));
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				moreQuotes =false;
			}
			
		}
		socket.close();
	}


}
