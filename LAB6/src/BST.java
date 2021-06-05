
/**
* BST.java
* @author Yadwinder Grewal
* @author Ansar Shaikh
* CIS 22C Lab 5
*/

import java.util.Comparator;
import java.util.NoSuchElementException;

public class BST<T> {
	private class Node {
		private T data;
		private Node left;
		private Node right;

		public Node(T data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	private Node root;

	/*** CONSTRUCTORS ***/

	/**
	 * Default constructor for BST sets root to null
	 */
	public BST() {
		root = null;

	}

	/**
	 * Copy constructor for BST
	 * 
	 * @param bst the BST of which to make a copy.
	 * @param c   the way the tree is organized
	 */
	public BST(BST<T> bst, Comparator<T> c) {
		if (bst == null) {
			root = null;
		} else {
			copyHelper(bst.root, c);
		}
	}

	/**
	 * Helper method for copy constructor
	 * 
	 * @param node the node containing data to copy
	 * @param c    the way the tree is organized
	 */
	private void copyHelper(Node node, Comparator<T> c) {
		if (node == null) {
			return;
		} else {
			insert(node.data, c);
			copyHelper(node.left, c);
			copyHelper(node.right, c);
		}
	}

	/*** ACCESSORS ***/

	/**
	 * Returns the data stored in the root
	 *
	 * @return the data stored in the root
	 * @throws NoSuchElementException when preconditon is violated
	 * @precondition !isEmpty()
	 */
	public T getRoot() throws NoSuchElementException {
		if (getSize() <= 0) {
			throw new NoSuchElementException("getRoot():  The tree is empty, no data to access");
		}
		return root.data;
	}

	/**
	 * Determines whether the tree is empty
	 * 
	 * @return whether the tree is empty
	 */
	public boolean isEmpty() {
		return (getSize() == 0);
	}

	/**
	 * Returns the current size of the tree (number of nodes)
	 * 
	 * @return the size of the tree
	 */
	public int getSize() {
		return (getSize(root));
	}

	/**
	 * Helper method for the getSize method
	 * 
	 * @param node the current node to count
	 * @return the size of the tree
	 */
	private int getSize(Node node) {
		if (node == null)
			return 0;
		else
			return (getSize(node.left) + 1 + getSize(node.right));
	}

	/**
	 * Returns the height of tree by counting edges.
	 * 
	 * @return the height of the tree
	 */
	public int getHeight() {
		if (this.isEmpty()) {
			return 0;
		} else {
			Node walk = root;
			return getHeight(walk);
		}
	}

	/**
	 * Helper method for getHeight method
	 * 
	 * @param node the current node whose height to count
	 * @return the height of the tree
	 */
	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	/**
	 * Returns the smallest value in the tree
	 * 
	 * @precondition !isEmpty()
	 * @return the smallest value in the tree
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public T findMin() throws NoSuchElementException {
		Node temp = root;
		if (isEmpty()) {
			throw new NoSuchElementException("findMin(): list is Empty, Can't find minimum!");
		}
		return findMin(temp);
	}

	/**
	 * Recursive helper method to findMin method
	 * 
	 * @param node the current node to check if it is the smallest
	 * @return the smallest value in the tree
	 */
	private T findMin(Node node) {
		if (node.left != null) {
			return findMin(node.left);
		} else {
			return node.data;
		}
	}

	/**
	 * Returns the largest value in the tree
	 * 
	 * @precondition !isEmpty()
	 * @return the largest value in the tree
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public T findMax() throws NoSuchElementException {
		Node temp = root;
		if (isEmpty()) {
			throw new NoSuchElementException("findMax(): list is Empty, Can't find the maximum!");
		}
		return findMax(temp);
	}

	/**
	 * Recursive helper method to findMax method
	 * 
	 * @param node the current node to check if it is the largest
	 * @return the largest value in the tree
	 */
	private T findMax(Node node) {
		if (node.right != null) {
			return findMax(node.right);
		} else {
			return node.data;
		}
	}

	/**
	 * Searches for a specified value in the tree
	 * 
	 * @param data the value to search for
	 * @param c    the Comparator that indicates the way the data in the tree was
	 *             ordered
	 * @return the data stored in that Node of the tree is found or null otherwise
	 */
	public T search(T data, Comparator<T> c) {
		if (root == null) {
			return null;
		} else {
			return search(data, root, c);
		}
	}

	/**
	 * Helper method for the search method
	 * 
	 * @param data the data to search for
	 * @param node the current node to check
	 * @param c    the Comparator that determines how the BST is organized
	 * @return BOOLEAN the data stored in that Node of the tree is found or null
	 *         otherwise
	 */
	private T search(T data, Node node, Comparator<T> c) {
		if (c.compare(data, node.data) == 0) {
			return node.data;
		} else if (c.compare(data, node.data) < 0) {
			if (node.left == null) {
				return null;
			} else {
				return search(data, node.left, c);
			}
		} // end else if
		else {
			if (node.right == null) {
				return null;
			} else {
				return search(data, node.right, c);
			}
		}
	}

//		else if (node == null)
//			return false;

//		if (data.compareTo(node.data) == 0) {
//			return true;
//		} else if (data.compareTo(node.data) > 0) {
//			return search(data, node.right);
//		} else {
//			return search(data, node.left);
//		}

	/*** MUTATORS ***/

	/**
	 * Inserts a new node in the tree
	 * 
	 * @param data the data to insert
	 * @param c    the Comparator indicating how data in the tree is ordered
	 */
	public void insert(T data, Comparator<T> c) {
		if (root == null) {
			root = new Node(data);
			return;
		} else {
			insert(data, root, c);
		}
	}

	/**
	 * Helper method to insert Inserts a new value in the tree
	 * 
	 * @param data the data to insert
	 * @param node the current node in the search for the correct location to insert
	 * @param c    the Comparator indicating how data in the tree is ordered
	 */
	private void insert(T data, Node node, Comparator<T> c) {
		if (c.compare(data, node.data) <= 0) {
			if (node.left == null) {
				node.left = new Node(data);
			} else {
				insert(data, node.left, c);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(data);
			} else {
				insert(data, node.right, c);
			}
		}

//		if (data.compareTo(node.data) <= 0) {
//			if (node.left == null) {
//				node.left = new Node(data);
//			} else {
//				insert(data, node.left);
//			}
//		} else {
//			if (node.right == null) {
//				node.right = new Node(data);
//			} else {
//				insert(data, node.right);
//			}  // end else
//		}  // end else
	} // end insert

	/**
	 * Removes a value from the BST
	 * 
	 * @param data the value to remove
	 * @param c    the Comparator indicating how data in the tree is organized Note:
	 *             updates nothing when the element is not in the tree
	 */
	public void remove(T data, Comparator<T> c) {
		if (isEmpty()) {
			throw new NoSuchElementException("remove(): list is Empty, Can't find the element to remove!");
		}
		root = remove(data, root, c);
	}

	/**
	 * Helper method to the remove method
	 * 
	 * @param data the data to remove
	 * @param node the current node
	 * @param c    the Comparator indicating how data in the tree is organized
	 * @return an updated reference variable
	 */
	private Node remove(T data, Node node, Comparator<T> c) {
		if (node == null)
			return null;
		else if (c.compare(data, node.data) < 0) {
			node.left = remove(data, node.left, c);
		} else if (c.compare(data, node.data) > 0) {
			node.right = remove(data, node.right, c);
		} else {
			if ((node.left == null) && (node.right == null)) {
				return null;
			} else if (node.left != null && node.right == null) {
				return node = node.left;
			} else if ((node.left == null) && (node.right != null)) {
				return node = node.right;
			} else {
				T temp = findMin(node.right);
				node.data = temp;
				node.right = remove(temp, node.right, c);
			}
		}
		return node;
	}

	/*** ADDITONAL OPERATIONS ***/

	/**
	 * Prints the data in pre order to the console followed by a new line
	 */
	public void preOrderPrint() {
		preOrderPrint(root);
	}

	/**
	 * Helper method to preOrderPrint method Prints the data in pre order to the
	 * console followed by a new line
	 */
	private void preOrderPrint(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.data + " ");
			preOrderPrint(node.left);
			preOrderPrint(node.right);
		}
	}

	/**
	 * Prints the data in sorted order to the console followed by a new line
	 */
	public void inOrderPrint() {
		inOrderPrint(root);
	}

	/**
	 * Helper method to inOrderPrint method Prints the data in sorted order to the
	 * console followed by a new line
	 */
	private void inOrderPrint(Node node) {
		if (node == null) {
			return;
		} else {
			preOrderPrint(node.left);
			System.out.print(node.data + " ");
			preOrderPrint(node.right);
		}
	}

	/**
	 * Prints the data in post order to the console followed by a new line
	 */
	public void postOrderPrint() {
		postOrderPrint(root);
	}

	/**
	 * Helper method to postOrderPrint method Prints the data in post order to the
	 * console
	 */
	private void postOrderPrint(Node node) {
		if (node == null) {
			return;
		} else {
			preOrderPrint(node.left);
			preOrderPrint(node.right);
			System.out.print(node.data + " ");
		}
	}
}