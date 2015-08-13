package com.fei.projecteuler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class OneHourPractice {

	/*
	 * 问题1

	   使用for循环、while循环和递归写出3个函数来计算给定数列的总和。

	   问题2

	   编写一个交错合并列表元素的函数。例如：给定的两个列表为[a，B，C]和[1，2，3]，函数返回[a，1，B，2，C，3]。

	   问题3

       编写一个计算前100位斐波那契数的函数。根据定义，斐波那契序列的前两位数字是0和1，随后的每个数字是前两个数字的和。例如，前10位斐波那契数为：0，1，1，2，3，5，8，13，21，34。

       问题4

       编写一个能将给定非负整数列表中的数字排列成最大数字的函数。例如，给定[50，2，1,9]，最大数字为95021。

       问题5

       编写一个在1，2，…，9（顺序不能变）数字之间插入+或-或什么都不插入，使得计算结果总是100的程序，并输出所有的可能性。例如：1 + 2 + 34 – 5 + 67 – 8 + 9 = 100。
	 */

	public static int q101(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	public static int q102(int[] arr) {
		int i = 0;
		int sum = 0;
		while(i < arr.length) {
			sum += arr[i];
			i++;
		}
		return sum;
	}
	public static int q103(int[] arr, int num) {
		return num == 0 ? 0 : q103(arr, num - 1) + arr[num - 1];
	}

	public static void q200(LinkedList<Integer> arr1, LinkedList<Integer> arr2) {
		LinkedList<Integer> arr = new LinkedList<>();
		int i = 0, j = 0;
		while(i < arr1.size() && j < arr2.size()) {
			arr.add(arr1.get(i));
			arr.add(arr2.get(j));
			i++;
			j++;
		}
		while(i < arr1.size()) {
			arr.add(arr1.get(i));
			i++;
		}
		while(j < arr2.size()) {
			arr.add(arr2.get(j));
			j++;
		}
		for(int n = 0; n < arr.size(); n++) {
			System.out.println(arr.get(n));
		}
	}

	public static int q300(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return q300(n - 1) + q300(n -2);
	}

	public static void q400(Integer[] arr) {
		Arrays.sort(arr, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				String v1 = o1.toString();
				String v2 = o2.toString();
				return (v1 + v2).compareTo(v2 + v1) * -1;
			}

		});
		String result = "";
		for (Integer integer : arr) {
			result += integer.toString();
		}
		System.out.println(result);
	}

	public static void q500() {
		int[] b = {1,2,3,4,5,6,7,8,9};
		int[] sym = new int[8];

		// there are 3 options "+", "-" and " " for these 8 positions
		for (sym[0]=0;sym[0]<3;sym[0]++)
			for (sym[1]=0;sym[1]<3;sym[1]++)
				for (sym[2]=0;sym[2]<3;sym[2]++)
					for (sym[3]=0;sym[3]<3;sym[3]++)
						for (sym[4]=0;sym[4]<3;sym[4]++)
							for (sym[5]=0;sym[5]<3;sym[5]++)
								for (sym[6]=0;sym[6]<3;sym[6]++)
									for (sym[7]=0;sym[7]<3;sym[7]++){
										int result = 0;
										StringBuffer sb = new StringBuffer();
										sb.append(b[0]);
										for(int i=0;i<8;i++){
											if(sym[i]==0){
												sb.append("+"+b[i+1]);
											}
											else if (sym[i]==1){
												sb.append("-"+b[i+1]);
											}
											else{
												sb.append(b[i+1]);
											}
										}

										String str = sb.toString();
										result = getResult(str);

										if(result==100){                
											for(int i=0;i<8;i++){
												if(sym[i]==0){
													System.out.print(b[i]+"+");
												}
												else if(sym[i]==1){
													System.out.print(b[i]+"-");
												}
												else{
													System.out.print(b[i]);                        
												}
											}
											System.out.println(b[8]);
										}

									}
	}

	public static int getResult(String str){
		int result=0;
		boolean isPlus = true;
		int temp=0;
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c=='+' || c=='-'){
				if(isPlus){
					result+=temp;
					temp=0;
				}
				else{
					result-=temp;
					temp=0;
				}
				if(c=='-'){
					isPlus=false;
				}
				else{
					isPlus=true;
				}
			}
			else{
				temp=temp*10+Integer.parseInt(str.charAt(i)+"");
			}
		}
		//deal with the last number
		if(isPlus){
			result+=temp;
		}
		else{
			result-=temp;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] VALUES = { 5, 2, 1, 9, 50, 56 };
		q400(VALUES);
		q500();
	}

}
