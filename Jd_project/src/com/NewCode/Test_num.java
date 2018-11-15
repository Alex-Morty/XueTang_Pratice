package com.NewCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
abstract class Glyph{
	abstract void draw();
	Glyph(){
		System.out.println("before draw()");
		draw();
		System.out.println("after draw()");
	}
}
class RoundGlyph extends Glyph{
	int radius =1 ;
	public RoundGlyph(int r) {
		radius =r;
		System.out.println("RoundGlyph() radius = "+radius);
		// TODO Auto-generated constructor stub
	}
	void draw() {
		System.out.println("draw() radius="+radius);
	}
}

public class Test_num {

public static int MaxNum(int[] list)
{
	int res=0;
	for(int i=0 ; i<list.length;i++)
		res=list[i];
	return res;
}
public static void main(String[] args) {
	new RoundGlyph(5);

//		Scanner in = new Scanner(System.in);
//		int res=0;
//		while(in.hasNext()) {
//        int N = in.nextInt();
//        ArrayList<int []> list = new ArrayList<>();
//        int[] value = new int[N];
//        for(int i=0 ;i<N;i++) {
//        	value[i]=in.nextInt();
//        }
//        list.add(value);
//        res=MaxNum(value);
//		}   
//		System.out.println(res);
       
	}
}
