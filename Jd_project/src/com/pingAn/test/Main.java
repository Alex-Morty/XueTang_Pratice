package com.pingAn.test;
 
import java.util.Scanner;
 
public class Main {

	public int MaximumCommonDivisor(int a,int b)
	{
		while(a!=b)
		{
			if(a>b)
				a=a-b;
			if(b>a)
				b=b-a;
		}
		return a;
		
	}

	public static void main(String[] args) {
		System.out.println("请输入 两个正整数：");
		Scanner in=new Scanner(System.in);
		int a;
		int b;
		a=in.nextInt();
		b=in.nextInt();
		Main gl=new Main();

		int div=gl.MaximumCommonDivisor(a, b);
		System.out.printf("最大公约数：%d\t最小公倍数：%d\n",div,a*b/div);

		in.close();
	}
 
}
