package ThinkDataStructure.ch10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ThinkDataStructure.ch09.MyLinearMap;

public class MyBetterMap<K, V> implements Map<K, V> {
	
	protected List<MyLinearMap<K, V>> maps;
	
	public MyBetterMap() {
		makeMaps(10); // default maps size 10
	}
	
	public MyBetterMap(int k) {
		makeMaps(k);
	}
	
	public void makeMaps(int k) {
		// coded by YJS
		maps = new ArrayList<MyLinearMap<K, V>>();
		for(int i=0; i<k; i++) {
			maps.add(new MyLinearMap<K, V>());
		}
	}
	
	
	/**
	 * Object key의 hashCode를 이용하여 MapList에서 Map을 리턴한다.
	 * 
	 * @param Object key
	 * @return MyLinearMap
	 */
	public MyLinearMap<K, V> chooseMap(Object key){
		// helper method, coded by YJS
		int validIndex = 0;
		int hashCodeOfKey = -1;
		
		if(key != null) {
			hashCodeOfKey = key.hashCode();
			validIndex = Math.abs(hashCodeOfKey) % maps.size(); // 항상 유효한 Index를 구한다. 
		}
		
//		System.out.printf("hashCodeOfKey : %d , validIndex : %d %n", hashCodeOfKey, validIndex);
		
		return maps.get(validIndex);
	}
	
	@Override
	public V put(K key, V value) {
		// coded by YJS
		MyLinearMap<K, V> linearMap = chooseMap(key);
		return linearMap.put(key, value);
	}
	
	@Override
	public V get(Object key) {
		// coded by YJS
		// 여전히 Entry의 갯수가 늘어나면 실행시간이 선형으로 증가된다.
		MyLinearMap<K, V> linearMap = chooseMap(key);
		return linearMap.get(key);
	}
	
	@Override
	public void clear() {
		// coded by YJS
		for(MyLinearMap<K, V> map : maps) {
			map.clear();
		}
	}

	@Override
	public boolean containsKey(Object key) {
		// coded by YJS
		MyLinearMap<K, V> map = chooseMap(key);
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// coded by YJS
		// 모든 map을 순환하며 containsValue()를 호출한다. > 비효율적..
		for(MyLinearMap<K, V> map : maps) {
			if(map.containsValue(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		// coded by YJS
		for(MyLinearMap<K, V> map : maps) {
			if(!map.isEmpty()) return false;
		}
		return true;
	}
	@Override
	public Set<K> keySet() {
		// coded by YJS
		Set<K> set = new HashSet<K>();
		for(MyLinearMap<K, V> map : maps) {
			set.addAll(map.keySet());
		}
		return set;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// coded by YJS
		for(Entry<? extends K, ? extends V> entrySet : m.entrySet()) {
			MyLinearMap<K, V> map = chooseMap(entrySet.getKey());
			map.put(entrySet.getKey(), entrySet.getValue());
		}
	}

	@Override
	public V remove(Object key) {
		// coded by YJS
		MyLinearMap<K, V> map = chooseMap(key);
		return map.remove(key);
	}

	@Override
	public int size() {
		// coded by YJS
		int sizeSum = 0;
		for(MyLinearMap<K, V> map : maps) {
			sizeSum += map.size();
		}
		return sizeSum;
	}

	@Override
	public Collection<V> values() {
		// coded by YJS
		Set<V> set = new HashSet<V>();
		for(MyLinearMap<K, V> map : maps) {
			set.addAll((Set<V>) map.values());
		}
		return set;
	}
}
