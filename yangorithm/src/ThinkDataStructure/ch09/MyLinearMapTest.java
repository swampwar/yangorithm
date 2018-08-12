package ThinkDataStructure.ch09;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MyLinearMapTest {
	
	protected Map<String, Integer> map;
	
	@Before
	public void setUp() throws Exception {
		map = new MyLinearMap<String, Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put(null, 0);
		System.out.println("SETUP OK..");
	}
	
	@Test
	public void testClear() {
		map.clear();
		assertEquals(map.size(), 0);
	}
	
	@Test
	public void testContainKey() {
		assertTrue(map.containsKey("Three"));
		assertTrue(map.containsKey(null));
		assertFalse(map.containsKey("Four"));
	}
	
	@Test
	public void testGet() {
		assertEquals(map.get("Three"), new Integer(3));
		assertEquals(map.get(null), new Integer(0));
		assertEquals(map.get("Four"), null);
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(map.isEmpty());
		map.clear();
		assertTrue(map.isEmpty());
	}
	
	@Test
	public void testKeySet() {
		Set<String> keySet = map.keySet();
		assertEquals(keySet.size(), 4);
		assertTrue(keySet.contains("Three"));
	}
	
	@Test
	public void testPut() {
		map.put("One", 11);
		assertEquals(map.size(), 4);
		assertEquals(map.get("One"), new Integer(11));
		
		map.put("Five", 5);
		assertEquals(map.size(), 5);
		assertEquals(map.get("Five"), new Integer(5));
	}

	@Test
	public void testPutAll() {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Six", 6);
		m.put("Seven", 7);
		m.put("Eight", 8);
		map.putAll(m);
		assertThat(map.size(), is(7));
	}
	
	@Test
	public void testRemove() {
		map.remove("One");
		assertThat(map.size(), is(3));
		assertThat(map.get("One"), nullValue());
	}

	/**
	 * Test method for {@link MyLinearMap#size()}.
	 */
	@Test
	public void testSize() {
		assertThat(map.size(), is(4));
	}

	/**
	 * Test method for {@link MyLinearMap#values()}.
	 */
	@Test
	public void testValues() {
		Collection<Integer> keySet = map.values();
		assertThat(keySet.size(), is(4));
		assertThat(keySet.contains(3), is(true));
		assertThat(keySet.contains(0), is(true));
		assertThat(keySet.contains(4), is(false));
	}
	
}
