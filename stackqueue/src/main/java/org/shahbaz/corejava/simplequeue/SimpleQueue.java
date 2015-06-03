package org.shahbaz.corejava.simplequeue;

public class SimpleQueue {

	private int size;

	private Node current = null;

	private Node first = null;

	public void enqueue(String data) {
		Node node = new Node();
		node.setData(data);
		if (first == null) {
			first = node;
		}
		if (current != null) {
			current.setNext(node);
		}
		current = node;
		size++;
	}

	public Node dequeue() {
		Node temp = first;
		first = temp.getNext();
		size--;
		return temp;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "SimpleQueue [ first=" + first + "]";
	}

}
