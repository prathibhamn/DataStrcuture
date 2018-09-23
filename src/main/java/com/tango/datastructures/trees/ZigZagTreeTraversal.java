package com.tango.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTreeTraversal {

	private Node rootNode = null;

	public ZigZagTreeTraversal() {
		addNode(rootNode, 1);
		addNode(rootNode, 2);
		addNode(rootNode, 3);
		addNode(rootNode, 4);
		addNode(rootNode, 5);
		addNode(rootNode, 6);
		addNode(rootNode, 7);
		addNode(rootNode, 8);
		addNode(rootNode, 9);
		addNode(rootNode, 10);
		addNode(rootNode, 11);

		zigZagTraverse(rootNode);
	}

	public static void main(String[] args) {
		new ZigZagTreeTraversal();
	}

	private void zigZagTraverse(Node rootNode2) {
		if (rootNode == null) {
			return;
		}
		Stack<Node> currentLevelStack = new Stack<Node>();
		Stack<Node> nextLevelStack = new Stack<Node>();
		boolean leftRead = true;
		currentLevelStack.add(rootNode2);
		while (!currentLevelStack.isEmpty()) {
			Node lNode = currentLevelStack.pop();
			System.out.print(" "+lNode.getData());
			if (leftRead) {
				if (lNode.getLeft() != null)
					nextLevelStack.push(lNode.getLeft());
				if (lNode.getRight() != null)
					nextLevelStack.push(lNode.getRight());
			} else if (!leftRead) {
				if (lNode.getRight() != null)
					nextLevelStack.push(lNode.getRight());
				if (lNode.getLeft() != null)
					nextLevelStack.push(lNode.getLeft());
			}

			if (currentLevelStack.isEmpty()) {
				leftRead = !leftRead;
				currentLevelStack = nextLevelStack;
				nextLevelStack = new Stack<Node>();
			}
		}

	}

	private void addNode(Node rootNode, int data) {

		if (rootNode == null) {
			// No Nodes are Present, create one and assign it to rootNode
			this.rootNode = new Node(data);

		} else {
			// Nodes present, So checking vacant position for adding new Node in sequential
			// fashion
			// Start scanning all Levels (level by level) of a tree one by one until we
			// found a node whose either left or right node is null.
			// For each and every node, we need to check whether Left and Right Node exist?
			// If exist, then that node is not useful for adding new node but we need to
			// store left and right node of that node for later processing
			// that is why it is stored in Queue for sequential placement.
			// If not exist, then we found a node, where new node will be placed but not
			// sure on left or right, so check which side is null and place new node there.
			if (rootNode.getLeft() != null && rootNode.getRight() != null) {
				Queue<Node> q = new LinkedList<Node>();
				q.add(rootNode);
				while (!q.isEmpty()) {
					Node node = q.poll();

					if (node.getLeft() != null && node.getRight() != null) {
						q.add(node.getLeft());
						q.add(node.getRight());
					} else {
						if (node.getLeft() == null) {
							node.setLeft(new Node(data));
						} else {
							node.setRight(new Node(data));
						}
						break;
					}
				}
			} else {
				// We reach this condition when either Left or Right is Null, but not sure which
				// side is Null.
				if (rootNode.getLeft() == null) {
					Node temp1 = new Node(data);
					rootNode.setLeft(temp1);
				} else {
					Node temp1 = new Node(data);
					rootNode.setRight(temp1);
				}
			}
		}

	}

}
