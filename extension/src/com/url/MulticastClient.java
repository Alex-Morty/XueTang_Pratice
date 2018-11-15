package com.url;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
//使用数据报进行广播通信--客户端
public class MulticastClient {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		MulticastSocket socket = new MulticastSocket(4446);
		InetAddress address = InetAddress.getByName("230.0.0.1");
		socket.joinGroup(address);
		DatagramPacket packet;
		
		for(int i = 0; i<5 ; i++) {
			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			String received = new String(packet.getData());
			
		}
		socket.leaveGroup(address);
		socket.close();
	}

}
