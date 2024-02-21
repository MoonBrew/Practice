
package dataStructures;

public class BST {
	//just a header?
	//this is an ordered tree.

	public class Node {
		private Node left;
		private Node right;
		public Node() {
		}
		public Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}
