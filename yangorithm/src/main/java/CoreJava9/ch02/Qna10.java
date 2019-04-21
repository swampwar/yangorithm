package CoreJava9.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Qna10 {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

		System.out.println(RandomNumbers.randomElement(array));
		System.out.println(RandomNumbers.randomElement(list));

		// Q : randomElement() 메서드를 int[]나 ArrayList<Integer>에 인스턴스 메서드로 만들수 없는 이유는?
		// A : 배열타입은(int[]) 클래스가 아니므로 추가할 수 없다.
		//     ArrayList<Integer> 는 static메서드를 사용하게 되면 메서드에서 사용하는 값들을 모두 static으로 바꿔야 하기 때문에 사용할 수 없다.
	}
}

class RandomNumbers {
	private static Random ran = new Random();
	
	public static int randomElement(int[] array) {
		if(array.length == 0) return 0;
		else return array[ran.nextInt(array.length)];
	}
	
	public static int randomElement(List<Integer> list) {
		if(list.size() == 0) return 0;
		else return list.get(ran.nextInt(list.size()));
	}
}
