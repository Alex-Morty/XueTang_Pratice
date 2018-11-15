package com.url;
import java.io.*;
import java.net.*;
public class MultiTalkClient {
	private int num;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("127.0.0.1", 4701);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String readLine;
			readLine = sin.readLine();
			while (!readLine.equals("ok")) {
				os.println(readLine);
				os.flush();
				System.out.println("Client:"+readLine);
				System.out.println("Server:"+is.readLine());
				readLine = sin.readLine();
				
			}
			os.close();
			is.close();
			sin.close();
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
