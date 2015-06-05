package org.shahbaz.corejava.simplelinkedlist;

public class SimpleLinkedList {

	private int size;

	private Node next = null;

	public void add(String data) {

		Node node = new Node();
		node.setData(data);
		node.setNode(next);
		next = node;
		size++;

	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		Node node = next.getNode();

		StringBuilder builder = new StringBuilder();
		while (node != null) {
			builder.append(next.getData());
		}

		return builder.toString();
	}
}
