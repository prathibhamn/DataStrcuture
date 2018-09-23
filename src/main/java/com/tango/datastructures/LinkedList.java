package com.tango.datastructures;

public class LinkedList {
	
	Node head;
	
	 public void printList()
	    {
	        Node n = head;
	        while (n != null)
	        {
	            System.out.print(n.i+" ");
	            n = n.next;
	        }
	    }
	 
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
        llist.head  = new Node(1);
        Node second = new Node(2);
        Node third  = new Node(3);
        llist.head.next = second; 
        second.next=third;
        llist.printList();
	}

}

 class Node {
	
	int i ;
	Node next;
	
	Node(int d )
	{
		this.i=d;
		this.next=null;
	}
}

