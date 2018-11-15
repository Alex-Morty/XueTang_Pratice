package com.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLReader {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		URL cs =new URL("http://www.baidu.com/");
		URLConnection tConnection =cs.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(tConnection.getInputStream()));
		String inputLine;
		
		while((inputLine=in.readLine())!=null) {
			System.out.println(inputLine);
			System.out.println(cs.getProtocol());
			System.out.println(cs.getFile());
		}
		in.close();
	}
	public static String sendGet(String url , String param) {
		String result = "";
		BufferedReader in =null;
		try {
			String urlNameString = url +"?"+param;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.connect();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line=in.readLine())!=null) {
				result+=line;
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		finally {
			try {
				if(in!=null) {
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	public static String sendPost(String url,String param) {
		PrintWriter out =null ;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection connection =realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setDoOutput(true);
			out = new PrintWriter(connection.getOutputStream());
			out.print(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line=in.readLine())!=null) {
				result+=line;
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		finally {
			try {
				if(out!=null) {
					out.close();
				}
				if(in!=null) {
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
		
	}
}
