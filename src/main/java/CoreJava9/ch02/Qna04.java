package CoreJava9.ch02;

import org.omg.CORBA.IntHolder;

public class Qna04 {

	public static void main(String[] args) {
		// IntHolder의 swap method를 구현해라
		IntHolder a = new IntHolder(1); 
		IntHolder b = new IntHolder(100); 
		
		System.out.println(a.value);
		
		swapIntHolder(a, b);
	
		System.out.println(a.value);
	}
	
	public static void swapIntHolder(IntHolder a, IntHolder b) {
		IntHolder tmp = new IntHolder(a.value);
		a =  new IntHolder(b.value);
		System.out.println(a.value);
	}

}
