package com.practice;

import java.util.HashSet;

/**
 * @author Tushar Linked List example
 * printMiddleElementOfLinkedList
 * deleteElementWhoseSumIsZero
 * deleteMiddleOfLinkedList
 * deleteDuplicatedElementFromSortedLinkedList
 */
public class LinkedList1DsEasy {

	public static void main(String args[]) {
		LinkedListCustom ls = new LinkedListCustom();
//		ls.addLast(6);
//		ls.addLast(-6);
//		ls.addLast(8);
		ls.addLast(2);
		ls.addLast(2);
		ls.addLast(3);
		ls.addLast(4);
		ls.addLast(5);
		ls.printLinkedList();
		System.out.println();
		System.out.println(ls.printMiddleElementOfLinkedList());
		// ls.deleteElementWhoseSumIsZero();
		// ls.printLinkedList();

		System.out.println();
		ls.deleteDuplicatedElementFromSortedLinkedList();
		;
		System.out.println();
		ls.printLinkedList();
		System.out.println();
		ls.printLinkedList();
		System.out.println();
		ls.deleteMiddleOfLinkedList();
		ls.printLinkedList();

	}

}

class LinkedListCustom {

	Node head;

	class Node {
		int k;
		Node next;

		Node(int k) {
			this.k = k;
		}
	}

	//Add elements To Linked List
	public void addLast(int k) {
		Node last = head;
		if (last == null) {
			head = new Node(k);
			return;
		}

		while (last.next != null)
			last = last.next;

		last.next = new Node(k);

	}

	//Print Liked List Generic
	public void printLinkedList() {
		Node iterate = head;

		while (iterate != null) {
			System.out.print(iterate.k + " , ");
			iterate = iterate.next;
		}
	}

	public int printMiddleElementOfLinkedList() {

		if (head == null)
			return 0;

		Node rabbit = head;
		Node tortoise = head;

		while (rabbit != null && rabbit.next != null) {
			tortoise = tortoise.next;
			rabbit = rabbit.next.next;
		}

		return tortoise.k;
	}

	public void deleteElementWhoseSumIsZero() {
		Node iter = head;
		Node lastpointer = null;
		HashSet<Integer> hm = new HashSet<>();
		int sum = iter.k;
		while (iter.next != null) {
			iter = iter.next;
			sum = sum + iter.k;
			System.out.print(sum + "oo");
			if (sum == 0) {
				lastpointer = iter.next;
				head = lastpointer;
			} else {
				if (hm.contains(sum)) {
					lastpointer.next = iter.next;
					lastpointer = lastpointer.next;
				} else
					hm.add(sum);
			}
			System.out.println("--" + hm);
		}
	}

	void deleteMiddleOfLinkedList() {
		if (head == null)
			return;

		Node rabbit = head;
		Node tortoise = head;
		Node prev = head;

		while (rabbit != null && rabbit.next != null) {
			prev = tortoise;
			tortoise = tortoise.next;
			rabbit = rabbit.next.next;
		}
		prev.next = tortoise.next;

	}

	public void deleteDuplicatedElementFromSortedLinkedList() {
		Node itr = head;
		Node prev;

		while (itr != null && itr.next != null) {
			prev = itr;
			itr = itr.next;
			if (prev.k == itr.k) {
				prev.next = itr.next;
				itr = prev;
			}
		}
	}

}
//2 2 4 5
//2 2 2 2 2
//6->-6-> 8-> 12-> null
