package com.NewCode;
 
import java.util.Scanner;
 
/*
 * ż���ֽ�
��°ͺղ��룺�κ�һ����������ż�����Բ�ֳ����������ĺͣ���ӡ�����еĿ���
����nΪż��,���n�����зֽ����
������
100
�����
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
		System.out.println("��������һ��������ż����");
		Scanner in=new Scanner(System.in);
		int EvenNum;
		int loop=3;
		EvenNum=in.nextInt();
		while(EvenNum<=6||EvenNum%2!=0)
		{
			System.out.println("��������һ��������ż����");
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
