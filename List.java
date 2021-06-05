/**
 * Defines a double-linked list class
 * @author Ansar Shaikh
 * @author Yadwinder Grewal
 * CIS 22C, Lab 3
 */

import java.util.NoSuchElementException;

public class List<T> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;

	/**** CONSTRUCTOR ****/

	/**
	 * Instantiates a new List with default values
	 * 
	 * @postcondition a list object created with default values
	 */
	public List() {
		first = null;
		last = null;
		iterator = null;
		length = 0;
	}

	/**
	 * Instantiates a new List by copying another List
	 * 
	 * @param original the List to make a copy of
	 * @postcondition a new List object, which is an identical but separate copy of
	 *                the List original
	 */
	public List(List<T> original) {
		if (original == null) {
			return;
		}
		if (original.length == 0) {
			length = 0;
			first = null;
			last = null;
			iterator = null;
		} else {
			Node temp = original.first;
			while (temp != null) {
				addLast(temp.data);
				temp = temp.next;
			}
			iterator = null;
		}
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition length != 0
	 * @return the value stored at node first
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getFirst: " + "List is empty, no data to access");
		}
		return first.data;
	}

	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition length != 0
	 * @return the value stored in the last node
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getLast: List is Empty. No data to access!");
		}
		return last.data;
	}

	/**
	 * Returns the current length of the list
	 * 
	 * @return the number of elements in the list
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Returns the current iterator
	 * 
	 * @return iterator node data
	 */
	public T getIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("getIterator: " + "Iterator is null, can not access its data");
		}
		return iterator.data;
	}

	/**
	 * Returns whether the list is currently empty
	 * 
	 * @return true/false whether the list is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**** MUTATORS ****/

	/**
	 * Creates a new first element
	 * 
	 * @param the data to insert at the front of the list
	 * @postcondition a new first element in the list
	 */
	public void addFirst(T data) {
		if (first == null) {
			first = last = new Node(data);
		} else {
			Node N = new Node(data);
			N.next = first;
			first.prev = N;
			first = N;
		}
		length++;
	}

	/**
	 * Create a new last element
	 * 
	 * @param the data to insert at the end of the list
	 * @postcondition a new data node added at the end of the list
	 */
	public void addLast(T data) {
		if (first == null) {
			first = last = new Node(data);
		} else {
			Node N = new Node(data);
			last.next = N;
			N.prev = last;
			last = N;
		}
		length++;
	}

	/**
	 * removes the element at the front of the list
	 * 
	 * @precondition length != 0
	 * @postcondition first element in the list removed
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
		} else if (length == 1) {
			first = last = null;
		} else {
			first = first.next;
			first.prev = null;
		}
		length--;
	}

	/**
	 * removes the element at the end of the list
	 * 
	 * @precondition length != 0
	 * @postcondition last element in the list removed
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("removeLast: list is empty. Nothing to remove.");
		} else if (length == 1) {
			first = last = null;
		} else {
			last = last.prev;
			last.next = null;
		}
		length--;
	}

	/**
	 * return whether the iterator is off the list
	 */
	public boolean offEnd() {
		return iterator == null;
	}

	/**
	 * Determines whether two Lists have the same data in the same order
	 * 
	 * @param L the List to compare to this List
	 * @return whether the two Lists are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof List)) {
			return false;
		} else {
			List<T> L = (List<T>) o;
			if (this.length != L.length) {
				return false;
			} else {
				Node temp1 = this.first;
				Node temp2 = L.first;
				while (temp1 != null) { // Lists are same length
					if (!(temp1.data.equals(temp2.data))) {
						return false;
					}
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
				return true;
			}
		}
	}

	/**
	 * removes the element currently pointed to by iterator
	 * 
	 * @precondition iterator != null
	 * @postcondition iterator points to null
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeIterator() throws NoSuchElementException {
		if (offEnd()) {
			throw new NullPointerException("removeIterator:  iterator is null, can not remove");
		} else if (iterator == first) {
			removeFirst();
		} else if (iterator == last) {
			removeLast();
		} else {
			iterator.prev.next = iterator.next;
			iterator.next.prev = iterator.prev;
			length--;
		}
		iterator = null;
	}

	/**
	 * Place the iterator to the start of the list
	 * 
	 * @postcondition iterator moved to the start of the list
	 */
	public void placeIterator() {
		iterator = first;
	}

	/**
	 * inserts an element after the Node currently pointed to iterator
	 * 
	 * @precondition iterator != null
	 * @postcondition adds a node after iterator
	 * @throws NullPointerException when the precondition is violated
	 */
	public void addIterator(T data) throws NullPointerException {
		if (offEnd()) {
			throw new NullPointerException("addIterator: " + "Iterator is off end, cannot add to list");
		} else if (iterator == last) {
			addLast(data);
		} else {
			Node N = new Node(data);
			N.next = iterator.next;
			N.prev = iterator;
			iterator.next.prev = N;
			iterator.next = N;
			length++;
		}
	}

	/**
	 * Moves iterator up by one Node
	 * 
	 * @precondition iterator != null
	 * @postconditions Iterator moves up by one Node
	 * @throws NullPointerException
	 */
	public void advanceIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("advanceIterator: " + "iterator is null, cannot be advance");
		}
		iterator = iterator.next;
	}

	/**
	 * Moves iterator down by one Node
	 * 
	 * @precondition iterator != null
	 * @postconditions iterator moves down by one Node
	 * @throws NullPointerException
	 */
	public void reverseIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("reverseIterator: " + "iterator is null cannot be reverse");
		}
		iterator = iterator.prev;
	}

	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * List with each value on its own line at the end of the List a new line
	 * 
	 * @return the List as a String for display
	 */
	@Override
	public String toString() {
		String result = "";
		Node temp = first;
		while (temp != null) {
			result += temp.data + " ";
			temp = temp.next;
		}
		return result + "\n";
	}

	/**
	 * Points the iterator at first and then advances it to the specified index
	 * 
	 * @param index the index where the iterator should be placed
	 * @precondition 0 < index <= length
	 * @throws IndexOutOfBoundsException when precondition is violated
	 */
	public void iteratorToIndex(int index) throws IndexOutOfBoundsException {
		if (index > length || index < 0) {
			throw new IndexOutOfBoundsException("iteratorToIndex: " + "index not in the List");
		} else {
			placeIterator();
			for (int i = 1; i < index; i++) {
				advanceIterator();
			}
		}

	}

	/**
	 * Searches the List for the specified value using the linear search algorithm
	 * 
	 * @param value the value to search for
	 * @return the location of value in the List or -1 to indicate not found Note
	 *         that if the List is empty we will consider the element to be not
	 *         found post: position of the iterator remains unchanged
	 */
	public int linearSearch(T value) {
		if (length > 0) {
			int position = -1;
			Node temp = first;
			while (temp != null) {
				position++;
				if (temp.data.equals(value))
					return position;
				temp = temp.next;
			}
		}
		return -1;
	}

	/**
	 * Prints the contents of the linked list in the format #. <element>
	 */
	public String printNumberList() {
		String result = "\n";
		Node temp = first;
		int i = 1;
		while (temp != null) {
			result += temp.data + "\n";
			temp = temp.next;
			i++;
		}
		return result;
	}
}