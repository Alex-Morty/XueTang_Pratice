/*
 * ���Ա��β����  (100 ����)
��Ŀ����
���⡣

����һ�����Ա�����㲻֪��ʲô�����Ա�����ȥ�������ݽṹ��

��Ȼ���򵥵�˵���Ǹ�һ������

һ��������5�ֲ�����

1 index����ѯ��indexλ���ϵ��������index�Ƿ��������-1

2 value����value���뵽���β��

3 n v1 v2 ... vn:��v1��vn��n����һ�β��뵽���β��

4: ɾ����β��һ������������ǿյģ���ʲô������

5 n: ɾ����β��n�������������û��n�������򽫱��е���ȫ��ɾ��

��ÿһ��1ָ���ӡ�����ѯ������ֵ��

��ʼʱ�����ǿյġ�

�ر�ģ�index��1��ʼ��Ҳ����˵����Ԫ���ǵ�1��Ԫ�أ������ǵ�0����

������ֵ��������ݾ�������int���͡�



��������빦����ϵͳ��ɣ�����ѧԱ��д��

��˱��ⲻ�ṩ�������������ѧԱ������Ŀ�������д���������ɡ�
 * 
 * */

package com.xuetang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//��ʾָ��Ķ���
class Cmd{
	int cmd;				//ֻ��ȡֵ1~5
	int nOrIndexOrValue;	//cmdΪ1ʱ�������ʾindex
							//cmdΪ2ʱ�������ʾvalue
							//cmdΪ3ʱ�������ʾn
							//cmdΪ4ʱ���������
							//cmdΪ5ʱ�������ʾn
	Integer [] params;		//cmdΪ3ʱ������n��int
}

public class Main {
	public static void main(String[] args) {
		Cmd [] commands = getCmd();//��ȡָ������
		
		//ѧԱ��Ҫ���ж������ݱ�д���������Ŀָ��������
		/***being your code here****/
		







		/***end your code****/
	}

	//����ָ�����У�ѧԱ��������
	public static Cmd[] getCmd(){
		Scanner cin = new Scanner(System.in);
		A = cin.nextInt();
		B = cin.nextInt();
		M = cin.nextInt();
		X = cin.nextInt();
		cin.close();
				
		int n = get();
		Cmd [] ret = new Cmd [n];
		ret[0] = new Cmd();
		ret[0].cmd = 3;
		ret[0].nOrIndexOrValue = get();
		ret[0].params = new Integer [ret[0].nOrIndexOrValue];
		for(int i=0;i!=ret[0].nOrIndexOrValue;++i) ret[0].params[i] = get();
		
		for(int i=1;i!=n;++i) {
			Cmd cmd = new Cmd();
			cmd.cmd = get()%5+1;
			switch(cmd.cmd) {
			case 1:
			case 2:cmd.nOrIndexOrValue=get();break;
			case 3:cmd.nOrIndexOrValue=get();cmd.params=new Integer[cmd.nOrIndexOrValue];for(int j=0;j!=cmd.nOrIndexOrValue;++j)cmd.params[j]=get();break;
			case 4:break;
			case 5:cmd.nOrIndexOrValue=get();break;
			}
			ret[i] = cmd;
		}
		return ret;
	}
	
	//ѧԱ��������
	private static int A,B,M,X;
	private static int get() {
		X = (A*X+B) % M;
		return X;
	}
}
