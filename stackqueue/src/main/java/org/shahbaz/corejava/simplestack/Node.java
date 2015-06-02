package org.shahbaz.corejava.simplestack;

public class Node {

	private int size;

	private String data;

	private Node next;

	/**
	 * 
	 */
	public Node() {

	}

	public Node(String data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "[data=" + data + ", next=" + next + " ]";
	}
}
