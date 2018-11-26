package ThinkDataStructure.ch12;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K, V> implements Map<K, V> {

	private int size = 0;
	private Node root = null;
	
	@Override
	public void clear() {
		this.size = 0;
		this.root = null; // 실행시간이 상수로 보이나 GC에 의해 메모리가 수거되는 시간까지 고려하면 선형이다.
	}

	@Override
	public boolean containsKey(Object target) {
		return findNode(target) != null;
	}

	@Override
	public boolean containsValue(Object target) {
		return containsValueHelper(root, target);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}

	@Override
	public V get(Object target) {
		Node node = findNode(target);
		
		if(node == null) return null;
		return node.value;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		if(key == null) throw new IllegalArgumentException();
		
		if(root == null) {
			root = new Node(key, value);
			size = 1;
			return null;
		}
		
		return putHelper(root, key, value);
	}

	/**
	 * TreeMap을 순환하며 key가 일치하는 Node를 찾아 value 값을 바꾸고 이전 value 값을 리턴한다.
	 * 일치하는 key를 가진 Node가 없으면 추가하고 null을 리턴한다.
	 * 실행시간은 TreeMap의 높이에 비례한다.
	 * 
	 * @param node
	 * @param key
	 * @param value
	 * @return
	 */
	private V putHelper(Node node, K key, V value) {
//		size++;
		Comparable<K> keyForCompr = (Comparable<K>) key;
		
		Node nextNode = node;
		Node beforeNode = null;
		V returnValue = null;
		int compareRslt = 1;
		
		// 전체 노드를 반복하지 않음 > 실행시간이 노드의 높이에 비례
		while(nextNode != null) {
			System.out.printf("target key : %s, nextNode key : %s, rslt : %d %n",key,nextNode.key,keyForCompr.compareTo(key));
			compareRslt = keyForCompr.compareTo(key);
			if(compareRslt == 0) {
			    returnValue = nextNode.value;
				break;
			}else if(compareRslt > 0) {
				beforeNode = nextNode;
				nextNode = nextNode.right;
				
				if(nextNode == null) beforeNode.right = new Node(key, value);
			}else {
				beforeNode = nextNode;
				nextNode = nextNode.left;
				
				if(nextNode == null) beforeNode.left = new Node(key, value);
			}
		}
		
		return returnValue;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * TreeMap을 순환하며 해당키의 Node를 찾아 반환하고 없으면 null을 반환한다.
	 * 
	 * @param target
	 * @return
	 */
	private Node findNode(Object target) {
		if(target == null) throw new IllegalArgumentException();
		
		// compareTo()를 사용하기 위해 형변환
		@SuppressWarnings("unchecked")
		Comparable<? super K> k = (Comparable<? super K>) target;
		
		Node startNode = root;
		Node returnNode = null;
		
		// 전체 노드를 반복하지 않음 > 실행시간이 노드의 높이에 비례
		while(startNode != null) {
//			System.out.printf("target value : %s, startNode key : %s, rslt : %d %n",k,startNode.key,k.compareTo(startNode.key));
			int compareRslt = k.compareTo(startNode.key);
			if(compareRslt == 0) {
				returnNode = startNode;
				break;
			}else if(compareRslt > 0) {
				startNode = startNode.right;
			}else {
				startNode = startNode.left;
			}
		}
		
		return returnNode;
	}
	
	/**
	 * TreeMap에서 해당 Value값을 가진 노드가 있는지 여부를 반환한다.
	 * containsValue()의 헬퍼 메서드. 
	 * 
	 * @param node
	 * @param target
	 * @return
	 */
	private boolean containsValueHelper(Node node, Object target) {
		if(node == null) {
			return false;
		}
		if(equals(node.value, target)) {
			return true;
		}
		if(containsValueHelper(node.left, target)) {
			return true;
		}
		if(containsValueHelper(node.right, target)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Compares two keys or two values, handling null correctly.
	 *
	 * @param target
	 * @param obj
	 * @return
	 */
	private boolean equals(Object target, Object obj) {
		if (target == null) {
			return obj == null;
		}
		return target.equals(obj);
	}
	
	/**
	 * Node를 생성하여 반환한다.
	 * @param key
	 * @param value
	 * @return
	 */
	public MyTreeMap<K, V>.Node makeNode(K key, V value) {
		return new Node(key, value);
	}
	
	/**
	 * root node를 초기화한다.
	 * @param node
	 * @param size
	 */
	public void setTree(Node node, int size) {
		this.root = node;
		this.size = size;
	}
	
	protected class Node {
		public K key;
		public V value;
		public Node left = null;
		public Node right = null;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
}
