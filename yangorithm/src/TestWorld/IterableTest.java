package TestWorld;

import java.util.Iterator;

public class IterableTest implements Iterable<String>{
	
	public IterableTest() {
		System.out.println("IterableTest constructor execute !");
	}
	
	@Override
	public Iterator<String> iterator() {
		return new MyIterator();
	}
	
	class MyIterator implements Iterator<String>{
		
		private int cnt = 0;

		@Override
		public boolean hasNext() {
			System.out.println("MyIterator hasNext() execute! : " + cnt);
			cnt++; 
			
			if(cnt >= 5) return false;
			
			return true;
		}

		@Override
		public String next() {
			System.out.println("MyIterator next() execute!");
			
			return "다음놈";
		}
		
	}

}
