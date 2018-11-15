package com.jd.test;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "C:\\Users\\Administrator\\Desktop\\a.txt",line;
		String[] bu;
		char[] buffer = new char[30];
		int charnum;
		BufferedReader in_0 = null;
		try {
			 in_0 = new BufferedReader(new FileReader(fileName));

			line=in_0.readLine();
			while (line!=null) {
				
				bu=line.split("\\s+");
				for(String s : bu) {
					System.out.println(s);
				}
				line= in_0 .readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Promblem reading" + fileName);
			e.printStackTrace();
			
				
			// TODO: handle exception
		}finally {
			 closeQuietly(in_0);
		}

	}
	private static void closeQuietly(Closeable closeable) {
	    try {
	        if (closeable != null) {
	            closeable.close();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
