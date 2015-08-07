package com.fei.projecteuler;

public class Part1 {

	// multiples of 3 or 5 
	public static int q001(int num) {
		int i = 0;
		int count = 0;
		while (i < num) {
			if (i % 3 == 0 || i % 5 == 0) {
				count+=i;
			}
			i++;
		}
		return count;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(q001(1000));
	}

}
