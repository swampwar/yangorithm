package ThinkDataStructure.Test;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		for(Entry entry : entrySet) {
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
		}
		
	}

}
