package com.fei.projecteuler;

import java.util.Random;

public class Part3 {

	public static void q041() {
		
	}
	
	// Coded triangle numbers
	public static void q042() {
		
	}
	
	public static boolean isTrianlgeNumber(int n) {
		for (int i = 1; ; i++) {
			if ( n == (i * (i + 1) / 2) ) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public static int stringIntValue(String s) {
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < 'A' || c > 'Z') {
				return -1;
			}
			else {
				sum += c - 'A' + 1;
			}
		}
		return sum;
	}
	
	// Sub-string divisibility
	public static long q043() {
		long sum = 0;
		return sum;
	}
	
	public static long getPandigitalNumber(int n) {
		long m = 1;
		int[] num = new int[n];
		int[] digits = new int[n];
		
		for (int i = 0; i < n; i++) {
			digits[i] = i;
		}
		Random r = new Random();
		int count = 0;
		while(count < n) {
			
		}
		for (int j = 0; j < n; j++) {
			num[j] = digits[r.nextInt(n)];
		}
		
		return m;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
