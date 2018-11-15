package com.jd.test;
import java.util.*;

public class Rectangle{
	int height,width;
	int getArea(int height , int width) {
		return height*width;
	}
	int getPerimeter(int height, int width) {
		return 2*(height+width);
	}
	public static void main(String args[]){ 
		  Rectangle rect = new Rectangle();
		  Scanner in =new Scanner(System.in);
		  int height = in.nextInt();
		  int weight = in.nextInt();
		  rect.height= height;
		  rect.width = weight;

		  System.out.println(rect.getArea(height, weight)+" "+rect.getPerimeter(height, weight)); 
		 } 
}