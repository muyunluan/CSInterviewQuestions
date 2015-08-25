package com.fei.google;

import java.util.HashSet;

import sun.security.krb5.internal.crypto.crc32;


public class List {

	public static Node mergeTwoSortedLists(Node n1, Node n2) {
		Node n = new Node(-1);
		Node m = n;
		while(n1 != null && n2 != null) {
			if (n1.value < n2.value) {
				n.next  = n1;
				n1 = n1.next;
			}
			else {
				n.next  = n2;
				n2 = n2.next;
			}
			n = n.next;
		}

		if (n1 != null) {
			n.next = n1;
		}

		if (n2 != null) {
			n.next = n2;
		}
		return m.next;
	}

	public static Node getIntersection(Node n1, Node n2) {
		Node n = new Node(-1);
		Node m = n;
		HashSet<Integer> h = new HashSet<Integer>();
		while(n1 != null) {
			h.add(n1.value);
			n1 = n1.next;
		}

		while(n2 != null) {
			if (h.contains(n2.value)) {
				Node t = new Node(n2.value);
				n.next = t;
				n = n.next;
			}
			n2 = n2.next;
		}
		return m.next;
	}

	public static Node findMthFromLast(Node n, int m) {
		int count = 0;
		Node r = n;
		Node t = n;
		while(t.next != null) {
			t = t.next;
			count++;
			if(count >= m) {
				r = r.next;
			}
		}
		return r;
	}

	public static Node findSourceOfCircularList(Node n) {
		Node fast = n;
		Node slow = n;
		Node result = null;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				//find circular
				Node p1 = n;
				Node p2;
				while(true) {
					p2 = slow;
					while(p2.next != slow && p2.next != p1) {
						p2 = p2.next;
					}
					if (p2.next == p1) {
						result = p1;
						break;
					}
					else {
						p1 = p1.next;
					}
				}
				return result;
			}
		}
		return null;
	}


	public static Node reverse(Node head, int k) {
		if(k <= 1) return head;
		Node newHead = new Node(0);
		newHead.next = head;
		Node p = newHead;
		Node q = newHead;
		int counter = 0;
		while(q.next != null){   //find the begin and end, then reverse the node between them
			counter = 0;
			while(q.next != null && counter < k - 1) {
				q = q.next;
				counter++;
			}
			if(q.next == null) break;
			//reverse element between p.next ~ q.next;  tracking prev and next node
			Node next = q.next.next;
			Node prev = p.next;
			p.next = q.next;
			reverse(prev, q.next);
			System.out.println(prev.value + "," + q.value + "," + q.next.value + "," + p.value);
			prev.next = next;
			p = prev;
			q = prev;
		}
		return newHead.next;
	}
	private static Node reverse(Node current, Node tail){
		if(current.next == tail) {
			tail.next = current;
			System.out.println("1: " + tail.value + "," + current.value);
		}
		else {
			reverse(current.next, tail).next = current;
			System.out.println("2: " + current.value + "," + tail.value);
		}
		return current;
	}

	public static Node reverseKthNode(Node n, int k) {
		Node head = n,prev = n;
		int count = 1;
		Node tempNode = head.next;

		while(tempNode != null)
		{
			//If count reaches k break the loop
			if(count == k)
				break;

			/*This is the major part:
                Link the prev node to next node of current node and
                link current node to head; so current node moved to 
                beginning of list. Now point current node to next of
                prev node to continue traversing
			 */
			prev.next = tempNode.next;
			tempNode.next = head;//reverse to previous Node
			head = tempNode;
			tempNode = prev.next;
			count++;
		}

		/*Check if current node is null or not; if not call the
        method again to get the next 3 elements in list got reversed
		 */
		if(tempNode != null)
			prev.next = reverseKthNode(tempNode, k);

		//Returns head which is the beginning node of modified list
		return head;
	}
	
	public static Node rearrangeList(Node n1, Node n2) {
		Node n1NextNode = null;
		Node n2NextNode = null;
		Node n1TempNode = n1;
		Node n2TempNode = n2;
		while(n1TempNode != null && n2TempNode != null) {
			n1NextNode = n1TempNode.next;
			n2NextNode = n2TempNode.next;
			
			n1TempNode.next = n2TempNode;
			n2TempNode.next = n1NextNode;
			
			n2TempNode = n2NextNode;
			n1TempNode = n1NextNode;
		}
		return n1;
	}
	
	public static Node deleteMiddleNode(Node n) {
		int count = 1;
		Node m = n;
		Node p = null;
		Node c = n;
		while(c.next != null) {
			count++;
			if(count % 2 == 0) {
				p = m;
				m = m.next;
			}
			c = c.next;
		}
		p.next = m.next;
		return n;
	}
	
	public static Node partition(Node n, int x) {
		Node newHead = new Node(-1);
		newHead.next = n;
		Node pre = newHead;

		//find the first node which is larger than x
		while(pre.next != null && pre.next.value < x) {
			pre = pre.next;
		}
		
		Node cur = pre;
		while(cur.next != null) {
			if(cur.next.value < x) {
				Node t = cur.next;//save the next node of the target which is less than x
				cur.next = t.next;//remove target node
				t.next = pre.next;
				pre.next = t;
				pre = pre.next;
			}
			else {
				cur = cur.next;
			}
		}
		return newHead.next;
	}
	
	public static Node partition2(Node n, int k) {
		Node small = new Node(-1);
		Node smallHead = small;
		Node big = new Node(-1);
		Node bigHead = big;
		while(n != null) {
			if(n.value < k) {
				small.next = n;
				small = small.next;
			}
			else {
				big.next = n;
				big = big.next;
			}
			n = n.next;
		}
		big.next = null;
		small.next = bigHead.next;
		return smallHead.next;
	}
	
	
	
	public static void main(String[] args) {
		Node a1 = new Node(0);
		Node a2 = new Node(1);
		a1.next = a2;
		Node a3 = new Node(2);
		a2.next = a3;
		Node a4 = new Node(3);
		a3.next = a4;
		Node a5 = new Node(4);
		a4.next = a5;
		Node a6 = new Node(5);
		a5.next = a6;
		Node a7 = new Node(6);
		a6.next = a7;
		Node a8 = new Node(7);
		a7.next = a8;
		System.out.println("a: " + a1.printString(a1));

		Node b1 = new Node(0);
		Node b2 = new Node(3);
		b1.next = b2;
		Node b3 = new Node(4);
		b2.next = b3;
		Node b4 = new Node(7);
		b3.next = b4;
		Node b5 = new Node(8);
		b4.next = b5;
		Node b6 = new Node(9);
		b5.next = b6;
		Node b7 = new Node(10);
		b6.next = b7;
		Node b8 = new Node(11);
		b7.next = b8;
		System.out.println("b: " + b1.printString(b1));

		//		Node n = mergeTwoSortedLists(a1,b1);
		//		System.out.println(n.printString(n));

		//		Node n1 = getIntersection(a1, b1);
		//		System.out.println(n1.printString(n1));

		Node c1 = new Node(0);
		Node c2 = new Node(1);
		c1.next = c2;
		Node c3 = new Node(2);
		c2.next = c3;
		Node c4 = new Node(3);
		c3.next = c4;
		Node c5 = new Node(4);
		c4.next = c5;
		Node c6 = new Node(5);
		c5.next = c6;
		Node c7 = new Node(6);
		c6.next = c7;
		Node c8 = new Node(7);
		c7.next = c8;
		c8.next = c4;
		
//		Node n2 = findSourceOfCircularList(c1);
//		System.out.println(n2.name);

//		Node n3 = reverseKthNode(a1, 3);
//		System.out.println(n3.printString(n3));
		
//		Node n4 = rearrangeList(a1, b1);
//		System.out.println(n4.printString(n4));
		
		Node n5 = deleteMiddleNode(a1);
		System.out.println(n5.printString(n5));
		
		Node d1 = new Node(1);
		Node d2 = new Node(3);
		d1.next = d2;
		Node d3 = new Node(4);
		d2.next = d3;
		Node d4 = new Node(2);
		d3.next = d4;
		Node d5 = new Node(5);
		d4.next = d5;
		Node d6 = new Node(8);
		d5.next = d6;
		Node d7 = new Node(6);
		d6.next = d7;
		Node d8 = new Node(7);
		d7.next = d8;
		System.out.println("d: " + d1.printString(d1));
		
		Node n6 = partition(d1, 2);
		System.out.println(n6.printString(n6));
	}

}
