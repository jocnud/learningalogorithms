package custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorFlattener<String> implements Iterator<String> {

	Iterator<Iterator<String>> root;
	List<String> flatList = new ArrayList<>();

	String element;
	public int size;
	int current = 0;

	public IteratorFlattener(Iterator<Iterator<String>> root) {
		this.root = root;
		while (root.hasNext()) {
			List<String> temp = copyIterator(root.next());
			flatList.addAll(temp);
		}
		size = flatList.size();
	}

	@Override
	public boolean hasNext() {
		return current < size;
	}

	@Override
	public String next() {
		element = flatList.get(current);
		current++;
		return element;
	}

	private static <T> List<T> copyIterator(Iterator<T> iter) {
		List<T> copy = new ArrayList<T>();
		while (iter.hasNext())
			copy.add(iter.next());
		return copy;
	}

}
