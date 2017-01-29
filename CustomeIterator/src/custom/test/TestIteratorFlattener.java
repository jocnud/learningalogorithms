package custom.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import custom.CustomItr;
import custom.IteratorFlattener;
import junit.framework.Assert;

public class TestIteratorFlattener<T> {

	List<String> listOfIndianCity = new ArrayList<>();
	List<String> listOfAmericanCity = new ArrayList<>();
	List<Iterator<String>> iteratorList = new ArrayList<Iterator<String>>();
	
	List<Iterator<String>> emptyIteratorList = new ArrayList<Iterator<String>>();

	@Before
	public void setup() {

		listOfAmericanCity = new ArrayList<>();
		listOfIndianCity = new ArrayList<>();

		listOfAmericanCity.add("New York");
		listOfAmericanCity.add("New Jersey");

		listOfIndianCity.add("Bombay");
		listOfIndianCity.add("Madras");

		iteratorList.add(listOfAmericanCity.iterator());
		iteratorList.add(listOfIndianCity.iterator());

	}

	@Test
	public void when_adding_two_list_size_2_each_itr_size_should_be_4() {
		CustomItr custItr = new CustomItr(iteratorList);
		IteratorFlattener itr = custItr.iterator();
		Assert.assertEquals(4, itr.size);
	}
	
	@Test
	public void when_adding_empty_list_size_should_be_0() {
		
		CustomItr custItr = new CustomItr(emptyIteratorList);
		IteratorFlattener itr = custItr.iterator();
		Assert.assertEquals(0, itr.size);
	}
	
	@Test
	public void when_4_elements_added_has_next_shoud_return_true_last_should_be_false(){
		CustomItr custItr = new CustomItr(iteratorList);
		IteratorFlattener itr = custItr.iterator();
		Assert.assertEquals(true, itr.hasNext());
		itr.next();
		Assert.assertEquals(true, itr.hasNext());
		itr.next();
		Assert.assertEquals(true, itr.hasNext());
		itr.next();
		Assert.assertEquals(true, itr.hasNext());
		itr.next();
		Assert.assertEquals(false, itr.hasNext());
		
	}
	
	@Test
	public void compare_each_string_that_was_in_list_should_return_same_string(){

		CustomItr custItr = new CustomItr(iteratorList);
		IteratorFlattener itr = custItr.iterator();

		Assert.assertEquals("New York", itr.next());
		Assert.assertEquals("New Jersey", itr.next());
		Assert.assertEquals("Bombay", itr.next());
		Assert.assertEquals("Madras", itr.next());
	}

}
