package TestWorld.YsCollections;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class YsArrayList<E> extends AbstractList<E> implements List<E>{
// TODO AbstractList가 이미 List를 implements 했는데 왜 다시 implements 했을까....
	
	transient Object[] elementData;
	private int size;
	private static final Object[] EMPTY_ELEMENTDATA = {}; // 생성자에서 파라미터 0일시 초기화 
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}; // 생성자에 파라미터 없을시 초기화 
	
	public YsArrayList(int initialCapacity) { //TODO size를 초기화 하지 않음 왜??
		if(initialCapacity > 0) {
			this.elementData = new Object[initialCapacity];
		}else if(initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		}else {
			throw new IllegalArgumentException("Iillegal Capacity:" + initialCapacity);
		}
	}
	
	public YsArrayList() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}
	
	public YsArrayList(Collection<? extends E> c) {
		this.elementData = c.toArray(); // Object[] 반환
		if((size = this.elementData.length) != 0) {
			if(elementData.getClass() != Object[].class) {
				// TODO elementData가 Object[]가 아니라면 성립될수가 없는데...
				elementData = Arrays.copyOf(elementData, size, Object[].class); 
			}
		}else {
			this.elementData = EMPTY_ELEMENTDATA;
		}
	}
	
	// List를 실데이터가 있는 만큼만 자른다. 용량 최소화
	public void trimToSize() {
		modCount++; // AbstractList에 선언변수
		if(size < elementData.length) {
			elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
		}
	}
	
	@Override
	public boolean add(E arg0) {
		
		
		
		return false;
	}

	@Override
	public void add(int arg0, E arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
