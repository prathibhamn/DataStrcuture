package com.tango.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {
	
	

	private Node rootNode;

	BinaryTreeTraversal() {

		addNode(rootNode, 45);
		addNode(rootNode, 25);
		addNode(rootNode, 35);
		addNode(rootNode, 55);
		System.out.println("-------------------level-----------------------------");
		printTreeLevelOrder(rootNode);
		System.out.println("----------------------in--------------------------");
		printTreeInOrder(rootNode);
		System.out.println("-----------------------pre-------------------------");
		printTreePreOrder(rootNode);
		System.out.println("------------------post------------------------------");
		printTreePostOrder(rootNode);
	}
	
	public static void main(String[] args) {
		new BinaryTreeTraversal();
	}

	private void printTreeLevelOrder(Node rootNode2) {
		if (rootNode2 == null) {
			return;
		}
		Queue<Node> lQueue = new LinkedList<>();
		lQueue.add(rootNode2);
		
		while(!lQueue.isEmpty()) {
			Node lNode = lQueue.poll();
			System.out.print("   "+lNode.getData());
			if(lNode.getLeft()!=null)
			{
				lQueue.add(lNode.getLeft());
			}
			if(lNode.getRight()!=null)
			{
				lQueue.add(lNode.getRight());
			}	
			
		}
	}

	//Inorder Printing.
	 private void printTreeInOrder(Node rootNode){
	  if(rootNode==null)
	   return;
	  printTreeInOrder(rootNode.getLeft());
	  System.out.print(rootNode.getData() + " ");
	  printTreeInOrder(rootNode.getRight());
	 }
	  
	 //Preorder Printing. 
	 private void printTreePreOrder(Node rootNode){
	  if(rootNode==null)
	   return;
	  System.out.print(rootNode.getData() + " ");
	  printTreePreOrder(rootNode.getLeft());
	  printTreePreOrder(rootNode.getRight());
	 }
	 
	 //Postorder Printing.
	 private void printTreePostOrder(Node rootNode){
	  if(rootNode==null)
	   return;
	  printTreePostOrder(rootNode.getLeft());
	  printTreePostOrder(rootNode.getRight());
	  System.out.print(rootNode.getData() + " ");
	 }
	  
	private void addNode(Node rootNode, int i) {
		if (this.rootNode == null) {
			this.rootNode = new Node(i);

		} else {
			addNodeInRightPlace(rootNode, i);
		}

	}

	private void addNodeInRightPlace(Node rootNode, int i) {
		if (i >rootNode.getData()  ) {
			if (rootNode.getRight() != null) {
				addNode(rootNode.getRight(), i);
			} else {
				rootNode.setRight(new Node(i));

			}
		} else if ( i<=rootNode.getData()) {
			if (rootNode.getLeft() != null) {
				addNode(rootNode.getLeft(), i);
			} else
				rootNode.setLeft(new Node(i));

		}

	}

}
