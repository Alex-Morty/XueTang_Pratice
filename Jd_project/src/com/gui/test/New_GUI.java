package com.gui.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class New_GUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Swing  Frame");
		Container contentPane = frame.getContentPane();
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLUE,10));
		panel.setLayout(new GridLayout(1, 2));
		JLabel label =new JLabel("Lable",SwingConstants.CENTER);
		JButton button = new JButton("Button");
		panel.add(label);
		panel.add(button);
		contentPane.add(panel);
		frame.pack();
		frame.show();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
