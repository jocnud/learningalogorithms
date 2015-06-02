package org.shahbaz.corejava.simplestack;

public class SimpleStack {

	private int size;

	private Node first = null;

	public void push(String data) {
		Node node = new Node();
		node.setData(data);
		node.setNext(first);
		first = node;
		size++;
	}

	public Node pop() {
		Node temp = first;
		if (temp != null) {
			first = temp.getNext();
			size--;
		}
		return temp;

	}

	public Node peek() {
		return first;
	}

	public boolean isEmpty() {
		if (first == null)
			return true;
		return false;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {

		return "SimpleStack [size=" + size + ", Node=" + first + "]";
	}

}
