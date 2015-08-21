package com.fei.projecteuler;

import java.math.BigInteger;
import java.util.HashSet;

public class Part2 {

	// Non-abundant sums
	public static void q023() {
		
	}
	
	
	// 1000-digit Fibonacci number
	public static void q025() {
//		for(int i = 1; ; i++) {
//			BigInteger t = BigInteger.valueOf(fibonacci(i));
//			if (t.toString().length() >= 10) {
//				System.out.println(i);
//				break;
//			}
//		}
		
		BigInteger lowerthres = BigInteger.TEN.pow(10 - 1);
		BigInteger upperthres = BigInteger.TEN.pow(10);
		BigInteger prev = BigInteger.ONE;
		BigInteger cur = BigInteger.ZERO;
		int i = 0;
		while (true) {
			// At this point, prev = fibonacci(i - 1) and cur = fibonacci(i)
			if (cur.compareTo(lowerthres) >= 0) {
				System.out.println(i);
				break;
			}
			else if (cur.compareTo(upperthres) >= 0)
				throw new RuntimeException("Not found");
			
			BigInteger temp = cur.add(prev);
			prev = cur;
			cur = temp;
			i++;
		}
	}
	
	public static long fibonacci(long n) {
		if(n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	//Distinct powers
	public static void q029() {
		HashSet<BigInteger> dis = new HashSet<BigInteger>();
		int count = 0;
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				BigInteger tem = BigInteger.valueOf(i).pow(j);
				if (!dis.contains(tem)) {
					dis.add(tem);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q029();
	}

}
