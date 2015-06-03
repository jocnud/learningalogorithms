package org.shahbaz.corejava.stackqueue;

import org.shahbaz.corejava.simplequeue.SimpleQueue;

public class SimpleQuueOperation {

	public static void main(String[] args) {

		SimpleQueue queue = new SimpleQueue();
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);

	}
}
