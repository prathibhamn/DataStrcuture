package com.tango.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;


public class AddNodeInBinaryTree {
	private Node rootNode;
	 
	 public static void main(String[] args) {
	  new AddNodeInBinaryTree();
	 }
	 
	 public AddNodeInBinaryTree(){
	 
	  addNodeInBinaryTree(rootNode, 1); 
	  addNodeInBinaryTree(rootNode, 2); 
	  addNodeInBinaryTree(rootNode, 3); 
	  addNodeInBinaryTree(rootNode, 4); 
	  addNodeInBinaryTree(rootNode, 5); 
	 
	  printTreeLevelOrder(rootNode);
	 }
	 
	 //Iterative way of adding new Node in Binary Tree.
	 private void addNodeInBinaryTree(Node rootNode, int data){
	   
	  if(rootNode==null){
	   // No Nodes are Present, create one and assign it to rootNode
	   this.rootNode = new Node(data);
	   
	  }else{
	   //Nodes present, So checking vacant position for adding new Node in sequential fashion 
	   //Start scanning all Levels (level by level) of a tree one by one until we found a node whose either left or right node is null.
	   //For each and every node, we need to check whether Left and Right Node exist? 
	   //If exist, then that node is not useful for adding new node but we need to store left and right node of that node for later processing 
	   //that is why it is stored in Queue for sequential placement.
	   //If not exist, then we found a node, where new node will be placed but not sure on left or right, so check which side is null and place new node there.
	 
	   Queue<Node> q = new LinkedList<Node>();
	   q.add(rootNode);
	   while(!q.isEmpty()){
	    Node node = q.poll();
	 
	    if(node.getLeft()!=null && node.getRight()!=null){
	     q.add(node.getLeft());
	     q.add(node.getRight());
	    }else{
	     if(node.getLeft()==null){
	      node.setLeft(new Node(data));
	     }else{
	      node.setRight(new Node(data));
	     }
	     break;
	    }
	   }
	  }
	   
	 }
	 
	 private void printTreeLevelOrder(Node rootNode) {
	  if(rootNode==null)
	   return;
	 
	  Queue<Node> q = new LinkedList<Node>();
	  q.add(rootNode);
	   
	  while(!q.isEmpty()){
	   Node node = q.poll();
	   System.out.print(node.getData() + " ");
	 
	   if(node.getLeft()!=null)
	    q.add(node.getLeft());
	 
	   if(node.getRight()!=null)
	    q.add(node.getRight());
	  }
	  
	 }
}


