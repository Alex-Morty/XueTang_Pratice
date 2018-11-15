package com.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SerSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket= null;
			try {
				serverSocket = new ServerSocket(4201);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("can not listen to "+e);
			}
			Socket socket = null;
			try {
				socket =serverSocket.accept();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error:"+e);
			}
			String line;
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os =new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Client:"+is.readLine());
			line=sin.readLine();
			while(!line.equals("ok")) {
				os.println(line);
				os.flush();
				System.out.println("server:"+line);
				System.out.println("client:"+is.readLine());
				line= sin.readLine();
			}
			os.close();
			sin.close();
			is.close();
			socket.close();
			serverSocket.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:"+e);
		}
		
	}

}
