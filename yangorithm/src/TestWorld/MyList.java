package TestWorld;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList implements List<String>{

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		System.out.println("iterator() called!");
		return new Iter();
	}
	
	class Iter implements Iterator<String>{
		int cnt = 0;

		@Override
		public boolean hasNext() {
			System.out.println("hasNext called!");
			if(cnt++ > 2) {
				return false;
			}
			
			return true;
		}

		@Override
		public String next() {
			System.out.println("next called!");
			return "1";
		}
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] paramArrayOfT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String paramE) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends String> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int paramInt, Collection<? extends String> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(int paramInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String set(int paramInt, String paramE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int paramInt, String paramE) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String remove(int paramInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object paramObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object paramObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<String> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<String> listIterator(int paramInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> subList(int paramInt1, int paramInt2) {
		// TODO Auto-generated method stub
		return null;
	}

}
