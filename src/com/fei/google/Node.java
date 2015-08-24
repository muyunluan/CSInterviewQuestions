package com.fei.google;

public class Node {
	
	public String name;
	public int value;
	public Node next;
	public Node previous;
	
	public Node(int v) {
		name = String.valueOf(v);
		value = v;
		next = null;
		previous = null;
	}
	
	public String printString(Node n) {
		String s = "";
		while(n != null) {
			s += String.valueOf(n.value);
			n = n.next;
		}
		return s;
	}
}
