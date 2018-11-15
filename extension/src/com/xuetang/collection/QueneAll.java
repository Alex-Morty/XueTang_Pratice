/*
 * 线性表的全操作  (100 满分)
题目描述
如题。

给定一个线性表，如果你不知道什么是线性表，可以去看看数据结构。

当然，简单的说就是给一组数。

一共有如下5种操作：

1 index：查询第index位置上的数，如果index非法，则输出-1

2 index value：在第index位置上插入一个数value，原来的数依次后移，如果index非法则不操作

3 index：删除第index位置上的数，其后的数依次前移。如果index非法则不操作

4 index n v1 v2 ... vn：从第index位置依次插入v1到vn的n个数，原来的数后移。如果index非法则不操作。

5 index n: 从第index位置往后依次删除n个数，其后的数依次前移。如果index非法则不操作，如果index及其之后不够n个数，则将index及其之后的数全部删除即可。

对每一个1指令，打印输出查询到的数值。

初始时，表是空的。

特别的，index从1开始，也就是说表首元素是第1个元素，而不是第0个。

另外需要注意的是：插入操作与删除操作中index的合法范围是不一样的！

本题出现的所有数据均是正的int类型。
 * 
 * 
 * */

package com.xuetang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.xuetang.collection.Cmd;
//表示指令的对象
class Cmd1 {
	int cmd; 		//只能取值1~5
	int index;		//操作的位置
	int nOrValue;	//cmd为1时，该域无用
					//cmd为2时，该域表示value
					//cmd为3时，该域无用
					//cmd为4时，该域表示n
					//cmd为5时，该域表示n
	Integer [] params;	//cmd为4时，该域含n个int
}

public class QueneAll {
	public static void main(String[] args) {
		Cmd1 [] commands = getCmd();//获取指令序列
		
		//学员需要自行定义数据以及设计程序以完成题目指定的任务
		/***being your code here****/
		


		/***end your code****/
	}

	//生成指令序列，学员可以无视
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
	
	//学员可以无视
	private static int A,B,M,X;
	private static int get() {
		X = (A*X+B) % M;
		return X;
	}
}


