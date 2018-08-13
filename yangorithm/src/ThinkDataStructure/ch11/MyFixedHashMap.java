package ThinkDataStructure.ch11;

import java.util.Map;

public class MyFixedHashMap<K, V> extends MyHashMap<K, V> implements Map<K, V>{

	private int size = 0;
	
	public void clear() {
		super.clear();
		size = 0;
	}
}
