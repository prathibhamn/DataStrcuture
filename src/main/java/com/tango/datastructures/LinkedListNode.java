package com.tango.datastructures;

public class LinkedListNode
{
    Node head;

    public static void main( String[] args )
    {
        LinkedListNode lLinkedListNode = new LinkedListNode();

        Node n1 = new Node( 10 );
        Node n2 = new Node( 20 );
        Node n3 = new Node( 30 );
        Node n4 = new Node( 40 );
        Node n5 = new Node( 50 );
        Node n6 = new Node( 60 );
        Node n7 = new Node( 70 );
        Node n8 = new Node( 80 );
        lLinkedListNode.head = n1;

        n1.next = ( n2 );
        n2.next = ( n3 );
        n3.next = ( n4 );
        n4.next = ( n5 );
        n5.next = ( n6 );
        n6.next = ( n7 );
        n7.next = ( n8 );
        n8.next = ( n6 );
    }

    public static Node reverse( LinkedListNode headOfList )
    {
        Node currentNode = headOfList.head;
        Node previousNode = null;
        Node nextNode = null;

        // until we have 'fallen off' the end of the list
        while( currentNode != null )
        {

            // copy a pointer to the next element
            // before we overwrite currentNode.next
            nextNode = currentNode.next;

            // reverse the 'next' pointer
            currentNode.next = previousNode;

            // step forward in the list
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

}
