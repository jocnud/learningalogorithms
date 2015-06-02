package org.shahbaz.corejava.stackqueue;

import org.shahbaz.corejava.simplestack.SimpleStack;

/**
 * Hello world!
 *
 */
public class SimpleStackOperation {
	public static void main(String[] args) {
		SimpleStack stack = new SimpleStack();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println(stack);

		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack);

	}
}
