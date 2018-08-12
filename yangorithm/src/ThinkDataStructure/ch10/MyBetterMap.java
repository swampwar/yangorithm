package ThinkDataStructure.ch10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ThinkDataStructure.ch09.MyLinearMap;

public class MyBetterMap<K, V> implements Map<K, V> {
	
	protected List<MyLinearMap<K, V>> maps;
	
	public MyBetterMap(int k) {
		makeMaps(k);
	}
	
	public void makeMaps(int k) {
		// 구현 by YJS
		maps = new ArrayList<MyLinearMap<K, V>>();
		for(int i=0; i<k; i++) {
			maps.add(new MyLinearMap<K, V>());
		}
	}
	
	// helper method
	public MyLinearMap<K, V> chooseMap(Object key){
		int hashCodeOfKey = key.hashCode();
		int validIndex = Math.abs(hashCodeOfKey) % maps.size(); // 항상 유효한 Index를 구한다. 
		
		System.out.printf("hashCodeOfKey : %d , validIndex : %d %n", hashCodeOfKey, validIndex);
		
		return maps.get(validIndex);
	}
	
	@Override
	public V put(K key, V value) {
		// 구현 by YJS
		
		// 여전히 Entry의 갯수가 늘어나면 실행시간이 선형으로 증가
		MyLinearMap<K, V> linearMap = chooseMap(key);
		return linearMap.put(key, value);
	}
	
	@Override
	public V get(Object key) {
		// 구현 by YJS
		MyLinearMap<K, V> linearMap = chooseMap(key);
		return linearMap.get(key);
	}
	
	public static void main(String[] args) {
		new MyBetterMap<Integer, Integer>(3).chooseMap(new String("123213123"));
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}

class A {
	int a;
	int b;
}
