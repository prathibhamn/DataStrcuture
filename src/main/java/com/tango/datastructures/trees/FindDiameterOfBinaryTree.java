package com.tango.datastructures.trees;

public class FindDiameterOfBinaryTree {
	private Node rootNode;
	private static int maxDiameterTillNow;

	public static void main(String[] args) {
		new FindDiameterOfBinaryTree();
	}

	public FindDiameterOfBinaryTree() {
		addNode(rootNode, 100);
		addNode(rootNode, 90);
		addNode(rootNode, 150);
		addNode(rootNode, 80);
		addNode(rootNode, 95);
		addNode(rootNode, 70);
		addNode(rootNode, 92);
		addNode(rootNode, 60);
		addNode(rootNode, 94);

		getDiameterOfBinaryTreeUsingGlobalVariable(rootNode);
		System.out.println(maxDiameterTillNow);
	}

	private int getDiameterOfBinaryTreeUsingGlobalVariable(Node startNode) {
		if (startNode == null)
			return 0;

		int leftHeight = getDiameterOfBinaryTreeUsingGlobalVariable(startNode.getLeft()); // Height of Left Subtree
		int rightHeight = getDiameterOfBinaryTreeUsingGlobalVariable(startNode.getRight()); // Height of Right Subtree

		if (leftHeight + rightHeight + 1 > maxDiameterTillNow) { // + 1 for node itself
			maxDiameterTillNow = leftHeight + rightHeight + 1;
		}
		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	private void addNode(Node rootNode, int data) {
		if (rootNode == null) {
			Node temp1 = new Node(data);
			this.rootNode = temp1;
		} else {
			addNodeInProperPlace(rootNode, data);
		}
	}

	private void addNodeInProperPlace(Node rootNode, int data) {
		if (data > rootNode.getData()) {
			if (rootNode.getRight() != null) {
				addNode(rootNode.getRight(), data);
			} else {
				Node temp1 = new Node(data);
				rootNode.setRight(temp1);
			}
		} else if (data < rootNode.getData()) {
			if (rootNode.getLeft() != null) {
				addNode(rootNode.getLeft(), data);
			} else {
				Node temp1 = new Node(data);
				rootNode.setLeft(temp1);
			}
		}
	}
}
