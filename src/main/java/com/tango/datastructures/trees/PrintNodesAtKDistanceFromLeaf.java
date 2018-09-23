package com.tango.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintNodesAtKDistanceFromLeaf {

	public static void main(String[] args) {
		new PrintNodesAtKDistanceFromLeaf();
	}

	public PrintNodesAtKDistanceFromLeaf() {

		Node rootNode = null;
		rootNode = addNode(rootNode, 50);
		rootNode = addNode(rootNode, 60);
		rootNode = addNode(rootNode, 70);
		rootNode = addNode(rootNode, 80);
		rootNode = addNode(rootNode, 90);
		rootNode = addNode(rootNode, 69);
		rootNode = addNode(rootNode, 68);
		rootNode = addNode(rootNode, 67);

		printNodesAtDistanceKFromLeafHelper(rootNode, 4);
	}

	public static void printNodesAtDistanceKFromLeafHelper(Node root, int k) {
		if (root == null) {
			return;
		}
		List<Integer> pathList = new ArrayList<Integer>();
		List<Boolean> alreadyVisitedFlagList = new ArrayList<Boolean>();

		printNodesAtDistanceKFromLeaf(root, k, 0, pathList, alreadyVisitedFlagList);
	}

	// prints all the keys which are K distant from a leaf
	public static void printNodesAtDistanceKFromLeaf(Node root, int k, int currentDistanceFromRoot,
			List<Integer> pathList, List<Boolean> alreadyVisitedFlagList) {
		if (root == null) {
			return;
		}

		// Add entry in Path and mark as node not yet printed.
		pathList.add(root.getData());
		alreadyVisitedFlagList.add(false);

		// reach leaf node if condition is true.
		if (root.getLeft() == null && root.getRight() == null) {

			// we reach leaf node, So get the index of node that is K distance away from
			// this leaf node.
			int indexToPrint = currentDistanceFromRoot - k;

			// If index is <0, it means user give invalid K value and K distance doesn't
			// exist.
			// If index is >=0, it means K distance exist and check whether we already
			// printed that node.
			if (indexToPrint >= 0 && !alreadyVisitedFlagList.get(indexToPrint)) {

				System.out.print(pathList.get(indexToPrint) + " ");

				// marking as node already printed.
				alreadyVisitedFlagList.set(indexToPrint, true);
				return;
			}
		}

		if (root.getLeft() != null) {
			printNodesAtDistanceKFromLeaf(root.getLeft(), k, currentDistanceFromRoot + 1, pathList,
					alreadyVisitedFlagList);

			// Already visited Left subtree of current node. Remove current node form
			// pathList
			pathList.remove(currentDistanceFromRoot + 1);

			// Already visited Left subtree of current node. Remove current node form
			// alreadyVisitedFlagList
			alreadyVisitedFlagList.remove(currentDistanceFromRoot + 1);
		}

		if (root.getRight() != null) {
			printNodesAtDistanceKFromLeaf(root.getRight(), k, currentDistanceFromRoot + 1, pathList,
					alreadyVisitedFlagList);

			// Already visited Right subtree of current node. Remove current node form
			// pathList.
			pathList.remove(currentDistanceFromRoot + 1);

			// Already visited Right subtree of current node. Remove current node form
			// alreadyVisitedFlagList
			alreadyVisitedFlagList.remove(currentDistanceFromRoot + 1);
		}
	}

	private Node addNode(Node rootNode, int i) {
		if (rootNode == null) {
			return new Node(i);
		} else {
			if (i > rootNode.getData()) {
				Node nodeToAdd = addNode(rootNode.getRight(), i);
				rootNode.setRight(nodeToAdd);

			} else {
				Node nodeToAdd = addNode(rootNode.getLeft(), i);
				rootNode.setLeft(nodeToAdd);
			}
		}
		return rootNode;
	}
}