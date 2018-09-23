package com.tango.datastructures;

import java.util.Scanner;

import com.tango.datastructures.InsertNodeAtTailLL.SinglyLinkedList;
import com.tango.datastructures.InsertNodeAtTailLL.SinglyLinkedListNode;

public class DeleteNodeAtGivenPosition {
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

		static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
			if (position < 0)
				return head;
			if(position ==0)
			{
				SinglyLinkedListNode headNode = head.next;
				//head.
				//head.next=null;

				return head.next;
			}
			else {
				int counter = 0;
				SinglyLinkedListNode lDeleteNode = head;
				SinglyLinkedListNode lPreviousNode = null;
				while (counter != position) {
					counter++;
					//if (counter >=1)
					lPreviousNode = lDeleteNode;
					lDeleteNode = lDeleteNode.next;
				}
				if (lDeleteNode != null && lDeleteNode.next != null) {
					/*
					 * lDeleteNode.data=lDeleteNode.next.data; SinglyLinkedListNode lNode =
					 * lDeleteNode.next.next; lDeleteNode.next.next=null; lDeleteNode.next=lNode; or
					 */
					lPreviousNode.next = lDeleteNode.next;
					lDeleteNode.next=null;

				} else if (lDeleteNode.next == null) {
					lPreviousNode.next = null;
				}

			}
			return head;
		}

		static void reversePrint(SinglyLinkedListNode head) {

			if(head==null)
			{
				//System.out.println("");
				return ;
			}
			if(head.next==null)
			{
				System.out.println(head.data);
				return ;
			}
			if(head.next!=null)  
			{
				reversePrint(head.next);
				System.out.println(head.data);
			}
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node) {
		while (node != null) {
			System.out.println(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				// bufferedWriter.write(sep);
			}
		}
	}

	public static void main(String[] args) {

		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		SinglyLinkedList llist = new SinglyLinkedList();

		int nodeData[] =  new int[] {11,
				12,
				8,
				18,
				16,
				5,
				18};
		//new int[] { 11, 9, 2, 9 };
		// new int[] { 141, 302, 164, 530, 474 };
		for (int i = 0; i < nodeData.length; i++) {

			llist.insertNode(nodeData[i]);

		}
		llist.reversePrint(llist.head);
		//SinglyLinkedListNode llist1 = llist.deleteNode(llist.head, 0);

		//printSinglyLinkedList(llist1);
		// bufferedWriter.newLine();

		// bufferedWriter.close();

	}

}
