package ThinkDataStructure.ch11;

import java.util.List;
import java.util.Map;

import ThinkDataStructure.ch09.MyLinearMap;
import ThinkDataStructure.ch10.MyBetterMap;

public class MyHashMap<K, V> extends MyBetterMap<K, V> implements Map<K, V>{
	
	// map 1개당 entry 갯수의 임계치
	private static final double FACTOR = 1.0;

	@Override
	public V put(K key, V value) { // coded by YJS
		V oldValue = super.put(key, value);
		
		// entry의 갯수가 임계치(map 1개당 1.0개)를 넘는다면 rehash() 실행
		if(size() > maps.size() * FACTOR) {
			rehash();
		}
		return oldValue;
	}
	
	/**
	 *  HashMap의 entry갯수가 임계치에 도달하면 실행.
	 *  map의 갯수를 2배 늘린다.
	 */
	public void rehash() { // coded by YJS
		int bfMapSize = maps.size();
		int afMapSize = bfMapSize*2;
		
		System.out.println("rehash.... after size : " + afMapSize);
		
		List<MyLinearMap<K, V>> oldMaps = maps;
		makeMaps(afMapSize);
		
		for(MyLinearMap<K, V> eachMap : oldMaps) {
			List<Entry<K, V>> eachEntries = (List<Entry<K, V>>) eachMap.getEntries();
			for(Entry<K, V> entry : eachEntries) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}
	
	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<String, Integer>();
		for (int i=0; i<10; i++) {
			map.put(new Integer(i).toString(), i);
		}
		Integer value = map.get("3");
		System.out.println(value);
	}
}
