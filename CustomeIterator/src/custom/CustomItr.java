package custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomItr {

	public List<Iterator<String>> iteratorList = new ArrayList<Iterator<String>>();

	public CustomItr(List<Iterator<String>> iteratorList) {
		this.iteratorList = iteratorList;
	}

	public IteratorFlattener iterator() {
		return new IteratorFlattener<>(iteratorList.iterator());
	}

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("String11");
		list1.add("String12");
		list1.add("String13");
		List<String> list2 = new ArrayList<String>();
		list2.add("String21");
		list2.add("String22");
		list2.add("String23");
		List<Iterator<String>> iteratorList = new ArrayList<Iterator<String>>();
		iteratorList.add(list1.iterator());
		iteratorList.add(list2.iterator());

		CustomItr cst = new CustomItr(iteratorList);
		IteratorFlattener itr = cst.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
