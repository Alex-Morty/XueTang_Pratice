package com.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread{
	Socket socket=null;
	int clientnum;
	public ServerThread(Socket socket , int num) {
		this.socket = socket;
		clientnum = num+1;
	}
	@Override
	public void run() {
		try {
			String line;
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os =new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Client"+clientnum+":"+is.readLine());
			line = sin.readLine();
			while (!line.equals("ok")) {
				os.println(line);
				os.flush();
				System.out.println("Server:"+line);
				System.out.println("Client:"+clientnum+":"+is.readLine());
				line=sin.readLine();
				
				
			}
			os.close();
			is.close();
			sin.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:"+e);
		}
	}
}

public class MultiTalkServer {
	static int clientnum=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serSocket=null;
		boolean listening =true;
		try {
			serSocket=new ServerSocket(4701);
		
		while (listening) {
			new ServerThread(serSocket.accept(),clientnum).start();
			clientnum++;
			
		}
		serSocket.close();
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Could not listen on port:4700");
			System.exit(-1);
		}
	}

}
