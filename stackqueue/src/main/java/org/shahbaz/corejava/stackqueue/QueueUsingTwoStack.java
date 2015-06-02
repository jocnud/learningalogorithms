package org.shahbaz.corejava.stackqueue;

import org.shahbaz.corejava.simplestack.Node;
import org.shahbaz.corejava.simplestack.SimpleStack;

public class QueueUsingTwoStack {

	public static void main(String[] args) {

		SimpleStack stackMain = new SimpleStack();
		SimpleStack stackUtility = new SimpleStack();

		stackMain.push("1");
		/* POP from main stack PUSH to utility Stack */
		Node node = stackMain.pop();
		stackUtility.push(node.getData());
		stackMain.push("2");
		stackMain.push(stackUtility.pop().getData());

		System.out.println(stackMain);

	}

}
