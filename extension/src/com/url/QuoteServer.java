package com.url;

import java.io.IOException;
/*
 * 数据报客户端
 * 
 * */
public class QuoteServer {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		new QuoteServerThread().start();
	}

}
