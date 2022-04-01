import java.util.HashMap;
import java.util.Map;

public class CreateLinkedList {

	public static void main(String[] args) {
		LinkedList link = new LinkedList();
//		link.insertAtLast(3);
//		link.insertAtLast(4);
//		link.insertAtLast(5);
//		link.insertAtLast(6);
//		link.insertAtLast(7);
//		link.insertAtLast(9);
//		link.insertAtLast(10);
//		link.printLinkedList();
//		
//		System.out.println("");
//		System.out.println(link.findMiddleElementOfLinkedList());
	//	link.insertAtLast(9);
		link.insertAtLast(8);
		link.insertAtLast(-6);
		link.insertAtLast(-2);
		link.insertAtLast(3);
		link.deleteListWhoseSumEqualsZero();
		System.out.println("");
		link.printLinkedList();

	}

}

class LinkedList {

	Node head;

	class Node {
		Node next;
		int d;

		Node(int d) {
			this.d = d;
		}
	}

	int insertAtLast(int d) {
		Node newel = new Node(d);
		Node currNode = head;
		if (currNode == null) {
			head = newel;
		} else {
			while (currNode.next != null)
				currNode = currNode.next;

			currNode.next = newel;
		}
		return d;
	}

	void printLinkedList() {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.d + " ");
			currNode = currNode.next;
		}
	}

	int findMiddleElementOfLinkedList() {
		Node tortoise = head;
		Node rabbit = head;

		while (rabbit.next != null && rabbit.next.next != null) {
			tortoise = tortoise.next;
			rabbit = rabbit.next.next;
		}

		return tortoise.d;
	}

	void deleteListWhoseSumEqualsZero() {
		if(head==null)
			return;
		Node currEle = head;
		Node dummy=new Node(0);
		dummy.next=currEle;
		int currSum = 0;
		int delSum=0;
		Map<Integer, Node> hm = new HashMap<>();
		hm.put(0, dummy);
		while (currEle != null) {
			currSum+=currEle.d;
			if(hm.containsKey(currSum)) {
				delSum=currSum;
				System.out.println(delSum);
				
				Node start=hm.get(currSum);
				Node startDel=hm.get(currSum).next;
				while(startDel!=null && startDel!=currEle) {
					delSum+=startDel.d;
					hm.remove(delSum);
					startDel=startDel.next;
				}
				System.out.println(hm);
				System.out.println(currEle.next.d);
				
				start.next=currEle.next;
			}
			else {
				hm.put(currSum, currEle);
			}
			currEle=currEle.next;
		}
	}
}

// 9->8->-6->-2->10 -5 -5 3
//9  Node1
//17 Node2
//11  Node3
//8->-6->-2->3

//0 Node 1
//8 node 2
//2 node 3
//0
//
//
//

