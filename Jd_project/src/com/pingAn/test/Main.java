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
		System.out.println("������ ������������");
		Scanner in=new Scanner(System.in);
		int a;
		int b;
		a=in.nextInt();
		b=in.nextInt();
		Main gl=new Main();

		int div=gl.MaximumCommonDivisor(a, b);
		System.out.printf("���Լ����%d\t��С��������%d\n",div,a*b/div);

		in.close();
	}
 
}
