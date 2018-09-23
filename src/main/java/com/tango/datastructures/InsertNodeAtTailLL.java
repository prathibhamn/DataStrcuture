package com.tango.datastructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertNodeAtTailLL {
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

		public SinglyLinkedList() {
			this.head = null;
		}

	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
		while (node != null) {
			// bufferedWriter.write(String.valueOf(node.data));
			System.out.println("" + node.data);
			node = node.next;

			if (node != null) {
				// bufferedWriter.write(sep);
			}
		}
	}

	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

		if (head == null) {
			return new SinglyLinkedListNode(data);
		}
		SinglyLinkedListNode lNodeToAdd = new SinglyLinkedListNode(data);
		SinglyLinkedListNode lNodePosition = head;
		while (lNodePosition.next != null) {
			lNodePosition = lNodePosition.next;
		}
		lNodePosition.next = lNodeToAdd;

		return head;

	}


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		SinglyLinkedList llist = new SinglyLinkedList();

		int nodeData[] = new int[] { 141, 302, 164, 530, 474 };
		for (int i = 0; i < nodeData.length; i++) {

			SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, nodeData[i]);

			llist.head = llist_head;
		}

		printSinglyLinkedList(llist.head);
		// bufferedWriter.newLine();

		// bufferedWriter.close();

	}
}
