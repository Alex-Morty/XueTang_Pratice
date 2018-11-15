package com.url;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.IllegalFormatCodePointException;
/*
 * @Auther Alex
 * 股票数据报文的获取，发送数据包客户端
 * */
public class QuoteClient {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		if(args.length!=2) {
			System.out.println("Usage:java QuoteClinet<hostname>");
			return;
		}
		DatagramSocket socket = new DatagramSocket();
		byte[] buf =new byte[256];
		int port = Integer.parseInt(args[1]);
		InetAddress address = InetAddress.getByName(args[0]);
		DatagramPacket packet = new DatagramPacket(buf, buf.length,address,port);
		socket.send(packet);
		
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		
		String reveived = new String(packet.getData());
		System.out.println("Quote of the Moment "+ reveived);
		
		socket.close();
	}

}
