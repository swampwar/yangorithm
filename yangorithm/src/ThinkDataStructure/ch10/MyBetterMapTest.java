package ThinkDataStructure.ch10;

import org.junit.Before;

import ThinkDataStructure.ch09.MyLinearMapTest;

public class MyBetterMapTest extends MyLinearMapTest {

	@Before
	public void setUp() {
		map = new MyBetterMap<String, Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put(null, 0);
		
		System.out.println("MyBetterMapTest setup() OK");
	}
	
}
