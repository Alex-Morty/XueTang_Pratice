/*
 * ���Ա��ȫ����  (100 ����)
��Ŀ����
���⡣

����һ�����Ա�����㲻֪��ʲô�����Ա�����ȥ�������ݽṹ��

��Ȼ���򵥵�˵���Ǹ�һ������

һ��������5�ֲ�����

1 index����ѯ��indexλ���ϵ��������index�Ƿ��������-1

2 index value���ڵ�indexλ���ϲ���һ����value��ԭ���������κ��ƣ����index�Ƿ��򲻲���

3 index��ɾ����indexλ���ϵ���������������ǰ�ơ����index�Ƿ��򲻲���

4 index n v1 v2 ... vn���ӵ�indexλ�����β���v1��vn��n������ԭ���������ơ����index�Ƿ��򲻲�����

5 index n: �ӵ�indexλ����������ɾ��n����������������ǰ�ơ����index�Ƿ��򲻲��������index����֮�󲻹�n��������index����֮�����ȫ��ɾ�����ɡ�

��ÿһ��1ָ���ӡ�����ѯ������ֵ��

��ʼʱ�����ǿյġ�

�ر�ģ�index��1��ʼ��Ҳ����˵����Ԫ���ǵ�1��Ԫ�أ������ǵ�0����

������Ҫע����ǣ����������ɾ��������index�ĺϷ���Χ�ǲ�һ���ģ�

������ֵ��������ݾ�������int���͡�
 * 
 * 
 * */

package com.xuetang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.xuetang.collection.Cmd;
//��ʾָ��Ķ���
class Cmd1 {
	int cmd; 		//ֻ��ȡֵ1~5
	int index;		//������λ��
	int nOrValue;	//cmdΪ1ʱ����������
					//cmdΪ2ʱ�������ʾvalue
					//cmdΪ3ʱ����������
					//cmdΪ4ʱ�������ʾn
					//cmdΪ5ʱ�������ʾn
	Integer [] params;	//cmdΪ4ʱ������n��int
}

public class QueneAll {
	public static void main(String[] args) {
		Cmd1 [] commands = getCmd();//��ȡָ������
		
		//ѧԱ��Ҫ���ж��������Լ���Ƴ����������Ŀָ��������
		/***being your code here****/
		


		/***end your code****/
	}

	//����ָ�����У�ѧԱ��������
	public static Cmd1 [] getCmd(){
		Scanner cin = new Scanner(System.in);
		A = cin.nextInt();
		B = cin.nextInt();
		M = cin.nextInt();
		X = cin.nextInt();
		cin.close();
		
		int n = get();
		Cmd1 [] ret = new Cmd1 [n];
		ret[0] = new Cmd1();
		ret[0].cmd = 4;
		ret[0].index = 1;
		ret[0].nOrValue = get();
		ret[0].params = new Integer[ret[0].nOrValue];
		for(int i=0;i!=ret[0].nOrValue;++i) ret[0].params[i] = get();
		
		for(int i=1;i!=n;++i) {
			Cmd1 cmd = new Cmd1();
			cmd.cmd = get()%5+1;
			switch(cmd.cmd) {
			case 1:cmd.index=get();break;
			case 2:cmd.index=get();cmd.nOrValue=get();break;
			case 3:cmd.index=get();break;
			case 4:cmd.index=get();cmd.nOrValue=get();cmd.params=new Integer [cmd.nOrValue];for(int j=0;j!=cmd.nOrValue;++j)cmd.params[j]=get();break;
			case 5:cmd.index=get();cmd.nOrValue=get();break;
			}
			ret[i]=cmd;
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


