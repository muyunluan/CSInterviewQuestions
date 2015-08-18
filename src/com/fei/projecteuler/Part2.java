package com.fei.projecteuler;

import java.math.BigInteger;

public class Part2 {

	// Non-abundant sums
	public static void q023() {
		
	}
	
	
	// 1000-digit Fibonacci number
	public static void q025() {
		for(int i = 1; ; i++) {
			BigInteger t = BigInteger.valueOf(fibonacci(i));
			if (t.toString().length() >= 10) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static long fibonacci(long n) {
		if(n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q025();
	}

}
