package com.gui.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grap extends JApplet{
	@Override
	public void init() {
		// ��init�����н�������htmlҳ���ϵĲ���
		//String message = getParameter("MESSAGE");
		add(new JLabel("welcome to touch's blog", JLabel.CENTER));
		Container contentPane =getContentPane();
		contentPane.setLayout(new GridLayout(3, 1));
		JButton button = new JButton("Clicl a");
		final JLabel label =new JLabel();
		contentPane.add(button);
		contentPane.add(label);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String information =JOptionPane.showInputDialog("������һ���ַ�","action");
				label.setText(information);
			}
		});
		
	}

	public  void Grap()
	{
		
		setVisible(true);
		setSize(500,300);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("SansSerif", Font.BOLD, 12));
		g.setColor(Color.YELLOW);
		g.drawString("alextest,���壬12�ţ���ɫ", 20, 50);
		
		g.drawLine(20, 60, 460, 60);
		
		g.setColor(Color.gray);
		g.drawRect(20, 70, 100, 50);
		g.fillRect(130, 190, 100, 50);
		
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setPaint(new GradientPaint(0, 0, Color.red, 180,45,Color.blue));
		graphics2d.drawString("This is a Test Applet",25, 25);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Applet is in the frame");
		Grap myJApplet =new Grap();
		// main�����ﴴ��һ�����������applet��applet��������ʱ��
		// Ҫ��ɲ��������ֶ�����init��start����
		frame.add(myJApplet, BorderLayout.CENTER);
		myJApplet.init();
 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);

		
		
	}

}
