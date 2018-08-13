package ThinkDataStructure.ch09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyLinearMap<K, V> implements Map<K, V> {

	private List<Entry> entries = new ArrayList<Entry>();
	
	@Override
	public void clear() {
		entries.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return findEntry(key) != null;
	}
	
	private Entry findEntry(Object key) {
		for(Entry entry : entries) {
			if(equals(entry.getKey(),key)){
				return entry;
			}
		}
		return null;
	}
	
	private boolean equals(Object target, Object obj) {
		if(target == null) {
			return obj == null;
		}
		return target.equals(obj);
	}

	@Override
	public boolean containsValue(Object value) {
		for(Entry entry : entries) {
			if(equals(entry.getValue(),value)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}

	@Override
	public V get(Object key) {
		Entry entry = findEntry(key);
		if(entry == null) {
			return null;
		}
		return entry.getValue();
	}

	@Override
	public boolean isEmpty() {
		return entries.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for(Entry entry : entries) {
			set.add(entry.getKey());
		}
		return set;
	}

	@Override
	public V put(K key, V value) {
		// 구현 by YJS
		Entry bfEntry = findEntry(key);
		V oldValue = null;
		if(bfEntry != null) {
			oldValue = bfEntry.getValue(); // 해당 key로 값이 있으면 이전value 리턴
			bfEntry.setValue(value); // 해당 key의 value값으로 덮어씌우기
		}else {
			entries.add(new Entry(key, value)); // 없으면 add 이후 null 리턴
		}
		
		return oldValue;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		for(Map.Entry<? extends K, ? extends V> eachEntry : map.entrySet()) {
			put(eachEntry.getKey(), eachEntry.getValue());
		}
	}

	@Override
	public V remove(Object key) {
		// coded by YJS
		Entry entry = findEntry(key);

		if(entry == null) return null; // key에 해당하는 데이터가 없으면 null리턴
		
		V oldValue = entry.getValue();
		entries.remove(entry);
		
		return oldValue;
	}

	@Override
	public int size() {
		return entries.size();
	}

	@Override
	public Collection<V> values() {
		Set<V> set = new HashSet<V>();
		for (Entry entry: entries) {
			set.add(entry.getValue());
		}
		return set;
	}
	
	
	
	public class Entry implements Map.Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}
		@Override
		public V getValue() {
			return value;
		}
		@Override
		public V setValue(V newValue) {
			value = newValue;
			return value;
		}
	}
	
	public Collection<? extends java.util.Map.Entry<K, V>> getEntries() {
		return entries;
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new MyLinearMap<String, Integer>();
		map.put("Word1", 1);
		map.put("Word2", 2);
		Integer value = map.get("Word1");
		System.out.println(value);

		for (String key: map.keySet()) {
			System.out.println(key + ", " + map.get(key));
		}
	}
}
