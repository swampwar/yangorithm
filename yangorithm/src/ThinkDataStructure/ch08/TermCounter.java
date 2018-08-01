package ThinkDataStructure.ch08;

import java.util.HashMap;
import java.util.Map;

public class TermCounter {

	private Map<String, Integer> map;
	private String label;
	
	public TermCounter(String label) {
		this.label = label;
		map = new HashMap();
	}
	
	public Integer get(String term) {
		return map.get(term) == null ? 0 : map.get(term);
	}
	
	public void put(String term, Integer count) {
		map.put(term, count);
	}
	
	public void incrementTerm(String term) {
		map.put(term, map.get(term)+1);
	}
}
