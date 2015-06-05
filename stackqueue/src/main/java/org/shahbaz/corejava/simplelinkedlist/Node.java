package org.shahbaz.corejava.simplelinkedlist;

public class Node {

	private String data;

	private Node node;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", node=" + node + "]";
	}

}
