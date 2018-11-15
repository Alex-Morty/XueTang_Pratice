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
		this.setResizable(false);//�û����ɵ����ڴ�С
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//���ϵͳ��ɫ��
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		this.getContentPane().add(sp, "Center");
		panel = new JPanel();
		this.getContentPane().add(panel, "South");
		send = new JButton("����");
		tField = new JTextField(20);
		tField.requestFocus();
		panel.add(tField);
		panel.add(send);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*
		 * 0-DO_NOTHING_ON_CLOSE����ִ���κβ������޷��رմ���
		 * 1-HIDE_ON_CLOSE������������ע��� WindowListener ������Զ����ظô��塣��ʱû�йرճ���ֻ�ǽ�������������ˡ�
		 * 2-DISPOSE_ON_CLOSE������������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣����������Ӧ�ó����ͷ��˴�����ռ�õ���Դ��
		 * 3-EXIT_ON_CLOSE��ʹ�� System exit �����˳�Ӧ�ó��򡣽���Ӧ�ó�����ʹ�á�������Ӧ�ó���
		 * */
		
		this.setVisible(true);//��������˼��˵����ģ���Ѿ�������ˣ�����JVM���Ը�������ģ��ִ��paint������ʼ��ͼ����ʾ����Ļ���ˣ���������ʾͼ�Σ����ǿ������п�ʼ��ͼ�ˡ�
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
	 * ActionListener�ӿ�ʵ�ֺ���
	 * Java Swing�д��������¼���һ�㲽���ǣ�
����
����1�� �½�һ���������JButton����
����
����2�� ���������ӵ���Ӧ����壨��JPanel����
����
����3�� ע��������Լ����¼�Դ�������¼�����ͨ��ActionListener����Ӧ�û������ť����
����
����4�� ���崦���¼��ķ���������ActionListener�е�actionPerformed�ж�����Ӧ��������

	����getActionCommand��ð�ť���ƣ�e.getActionCommand();
	Ҳ��������getSource()��ʵ��
	if (e.getSource() ==button1)
����
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
