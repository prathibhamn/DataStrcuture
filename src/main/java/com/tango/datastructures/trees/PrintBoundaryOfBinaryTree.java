package com.tango.datastructures.trees;

public class PrintBoundaryOfBinaryTree {

	private Node rootNode = null;

	public static void main(String[] args) {
		new PrintBoundaryOfBinaryTree();
	}

	public PrintBoundaryOfBinaryTree() {
		addNode(rootNode, 100);
		addNode(rootNode, 50);
		addNode(rootNode, 150);
		addNode(rootNode, 25);
		addNode(rootNode, 75);
		addNode(rootNode, 140);
		addNode(rootNode, 142);
		addNode(rootNode, 30);
		addNode(rootNode, 70);
		addNode(rootNode, 80);
		addNode(rootNode, 35);

		printBoundary(rootNode);
	}

	private void printBoundary(Node rootNode2) {
		System.out.print(" "+rootNode2.getData());
		printLeftBoubdary(rootNode2.getLeft());
		printleaf(rootNode2);
		printRightBoundary(rootNode2.getRight());
	
		
	}

	private void printLeftBoubdary(Node rootNode2) {
		if (rootNode2 == null) {
			return;
		}
		if (rootNode2.getLeft() == null && rootNode2.getRight() == null) {
		return;
		}
		if (rootNode2.getLeft() != null) {
			System.out.print(" "+rootNode2.getData());
			printLeftBoubdary(rootNode2.getLeft());
		} else if (rootNode2.getRight() != null) {
			System.out.print(" "+rootNode2.getData());
			printLeftBoubdary(rootNode2.getRight());
		}

	}

	private void printleaf(Node rootNode2) {
		if (rootNode2 == null) {
			return;
		}
		if (rootNode2.getLeft() == null && rootNode2.getRight() == null) {
			System.out.print(" "+rootNode2.getData());
		}
		printleaf(rootNode2.getLeft());
		printleaf(rootNode2.getRight());
	}

	private void printRightBoundary(Node rootNode2) {
		if (rootNode2 == null) {
			return;
		}
		if (rootNode2.getLeft() == null && rootNode2.getRight() == null) {
			return;
		}
		
		
		if (rootNode2.getRight() != null) {
			System.out.print(" "+rootNode2.getData());
			printRightBoundary(rootNode2.getRight());
		} else if (rootNode2.getLeft() != null) {
			System.out.print(" "+rootNode2.getData());
			printRightBoundary(rootNode2.getLeft());
		}

	}

	private void addNode(Node rootNode, int i) {
		if (this.rootNode == null) {
			this.rootNode = new Node(i);

		} else {
			addNodeInRightPlace(rootNode, i);
		}

	}

	private void addNodeInRightPlace(Node rootNode, int i) {
		if (i > rootNode.getData()) {
			if (rootNode.getRight() != null) {
				addNode(rootNode.getRight(), i);
			} else {
				rootNode.setRight(new Node(i));

			}
		} else if (i <= rootNode.getData()) {
			if (rootNode.getLeft() != null) {
				addNode(rootNode.getLeft(), i);
			} else
				rootNode.setLeft(new Node(i));

		}

	}
}