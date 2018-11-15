package com.NewCode;
 
import java.util.Scanner;
 
/*
 * 偶数分解
歌德巴赫猜想：任何一个大于六的偶数可以拆分成两个质数的和，打印出所有的可能
输入n为偶数,输出n的所有分界可能
如输入
100
输出：
100=3+97
100=11+89
100=17+83
100=29+71
100=41+59
100=47+53
 */
public class gdbh {
	public boolean IsPrime(int num)
	{
		for(int i=2;i<=Math.sqrt(num);i++)
		{
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入任一大于六的偶数：");
		Scanner in=new Scanner(System.in);
		int EvenNum;
		int loop=3;
		EvenNum=in.nextInt();
		while(EvenNum<=6||EvenNum%2!=0)
		{
			System.out.println("请输入任一大于六的偶数：");
			EvenNum=in.nextInt();
		}
		while(loop<=EvenNum/2)
		{
			gdbh gold=new gdbh();
			if(gold.IsPrime(loop)&&gold.IsPrime(EvenNum-loop))
			{
				System.out.printf("%d=%d+%d\n", EvenNum,loop,EvenNum-loop);
			}
			loop+=1;
		}
		in.close();
	}
 
}
