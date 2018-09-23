package com.tango.datastructures;

import java.util.HashSet;
import java.util.Set;

public class ToFetchNodeValueInLL {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node) {
		while (node != null) {
			System.out.println((String.valueOf(node.data)));
			node = node.next;
		}
	}

	static boolean hasCycle(SinglyLinkedListNode head) {
		SinglyLinkedListNode slowPointer = head;
		SinglyLinkedListNode fastPointer = head;

		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer)
				return true;
		}
		return false;

	}

	static int getNode(SinglyLinkedListNode head, int positionFromTail) {
		/*
		 * if (positionFromTail == 0) { return head.data; }
		 */
		int count = 0;
		int size = 0;
		SinglyLinkedListNode node = head;
		while (node != null) {
			node = node.next;
			size++;
		}
		while (count != (size - positionFromTail)) {
			node = head;
			head = head.next;
			count++;
		}
		return node.data;
	}

	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
		Set<Integer> lDataSet = new HashSet<>();
		SinglyLinkedListNode temp = head;
		SinglyLinkedListNode previousNode = null;
		if (head == null)
			return head;
		while (head != null) {
			if (lDataSet.contains(head.data)) {
				previousNode.next = head.next;
				head.next = null;
				head = previousNode;
			} else {
				lDataSet.add(head.data);
			}
			previousNode = head;
			head = head.next;
		}
		return temp;
	}

	public static void main(String[] args) {
		SinglyLinkedList llist = new SinglyLinkedList();
		int[] item = new int[] {-1,
				1,
				1};
				//{ 3, 1, 2, 3 };
		// new int[] { 86, 48, 91, 93, 79, 87, 27, 79, 67, 41, 8, 1, 95, 2, 14, 62, 35,
		// 2, 2, 59, 17, 51, 19,
		// 20, 17, 69, 69, 24, 14, 21, 58, 52, 68, 100, 44 };
		// { 3, 2, 1 };
		// int[] duplicateItem = new int[] { 1, 2, 2, 3, 4 };
		for (int i = 0; i < item.length; i++) {

			llist.insertNode(item[i]);
		}
		System.out.println(hasCycle(llist.head));
		// SinglyLinkedListNode lDistinceNocde = removeDuplicates(llist.head);
		// printSinglyLinkedList(lDistinceNocde);
		//System.out.println(getNode(llist.head, 0));
	}
}
