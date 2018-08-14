package ThinkDataStructure.ch11;

import java.util.Map;

import ThinkDataStructure.ch09.MyLinearMap;

public class MyFixedHashMap<K, V> extends MyHashMap<K, V> implements Map<K, V>{

	private int size = 0;
	
	public void clear() {
		super.clear();
		size = 0;
	}

	@Override
	public V put(K key, V value) {
		// 실제 상위클래스에서 add가 실행됬는지 알수 없기 때문에 size를 빼고 더하는 작업 실행
		MyLinearMap<K, V> map = chooseMap(key);
		size -= map.size();
		
		V oldValue = map.put(key, value);
		size += map.size();
		
		// entry의 갯수가 임계치(map 1개당 1.0개)를 넘는다면 rehash() 실행
		if(size() > maps.size() * FACTOR) {
			rehash();
		}
		
		return oldValue;
	}

	@Override
	public V remove(Object key) {
		// 실제 상위클래스에서 add가 실행됬는지 알수 없기 때문에 이전-이후 size를 비교하여 size를 조정하는 작업 실행
		MyLinearMap<K, V> map = chooseMap(key);
		int bfMapSize = map.size();
		
		V oldValue = super.remove(key);
		int afMapSize = map.size();
		
		size -= (bfMapSize - afMapSize); // 변화량 만큼 size를 줄인다.
		return oldValue;
	}
	
	public int size() {
		return this.size;
	}
}
