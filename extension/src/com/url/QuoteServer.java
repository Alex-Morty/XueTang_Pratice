package com.url;

import java.io.IOException;
/*
 * ���ݱ��ͻ���
 * 
 * */
public class QuoteServer {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		new QuoteServerThread().start();
	}

}
