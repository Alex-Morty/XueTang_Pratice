package com.url;

import javax.swing.*;
import javax.xml.crypto.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class ChatFrame extends JFrame implements ActionListener{

	JTextField tField;
	JTextArea tArea;
	JScrollPane sp;
	JButton send;
	JPanel panel;
	
	int port;
	String string = "";
	String myID;
	Date date;
	ServerSocket serverSocket;
	Socket mySocket;
	BufferedReader is;
	PrintWriter os;
	String line;
	
	public ChatFrame(String ID,String remoteID ,String IP,int port,boolean isServer) {
		super(ID);
		myID = ID;
		this.port = port;
		tArea = new JTextArea();
		tArea.setEditable(false);
		sp = new JScrollPane(tArea);
		this.setSize(330,400);
		this.setResizable(false);//用户不可调窗口大小
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//获得系统配色类
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		this.getContentPane().add(sp, "Center");
		panel = new JPanel();
		this.getContentPane().add(panel, "South");
		send = new JButton("发送");
		tField = new JTextField(20);
		tField.requestFocus();
		panel.add(tField);
		panel.add(send);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*
		 * 0-DO_NOTHING_ON_CLOSE：不执行任何操作，无法关闭窗口
		 * 1-HIDE_ON_CLOSE：调用任意已注册的 WindowListener 对象后自动隐藏该窗体。此时没有关闭程序，只是将程序界面隐藏了。
		 * 2-DISPOSE_ON_CLOSE；调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。但继续运行应用程序，释放了窗体中占用的资源。
		 * 3-EXIT_ON_CLOSE：使用 System exit 方法退出应用程序。仅在应用程序中使用。结束了应用程序。
		 * */
		
		this.setVisible(true);//方法的意思是说数据模型已经构造好了，允许JVM可以根据数据模型执行paint方法开始画图并显示到屏幕上了，并不是显示图形，而是可以运行开始画图了。
		send.addActionListener(this);
		tField.addActionListener(this);
		if(isServer) {
			try {
				serverSocket = null;
				serverSocket =new ServerSocket(port);
				mySocket= null;
				
				mySocket = serverSocket.accept();
				
				is = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
				os = new PrintWriter(mySocket.getOutputStream());
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		else {
			try {
				mySocket = new Socket(IP, port);
				os = new PrintWriter(mySocket.getOutputStream());
				is = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error: in client socket"+e);
			}
		}
		while(true) {
			try {
				line = is.readLine();
				date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentTime = format.format(date);
				string += currentTime + "" +remoteID + "say:\n"+line + "\n";
				tArea.setText(string);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error: in receive remote information"+e);
			}
		}
	}
	
	/*
	 * ActionListener接口实现函数
	 * Java Swing中处理各组件事件的一般步骤是：
　　
　　1． 新建一个组件（如JButton）。
　　
　　2． 将该组件添加到相应的面板（如JPanel）。
　　
　　3． 注册监听器以监听事件源产生的事件（如通过ActionListener来响应用户点击按钮）。
　　
　　4． 定义处理事件的方法（如在ActionListener中的actionPerformed中定义相应方法）。

	利用getActionCommand获得按钮名称：e.getActionCommand();
	也可以利用getSource()来实现
	if (e.getSource() ==button1)
　　
	 * */
	public void actionPerformed(ActionEvent e) {
		
		date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = format.format(date);
		string += currentTime + "" +myID + "say:\n"+tField.getText() + "\n";
		tArea.setText(string);
		os.println(tField.getText());
		os.flush();
		tField.setText("");
		tField.requestFocus();
	}


}
