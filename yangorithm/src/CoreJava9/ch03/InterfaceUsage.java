package CoreJava9.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class InterfaceUsage {
	public static void main(String[] args) {
		Human[] group = {new Human(10), new Human(20), new Human(30)};
		
		// Comrapable Interface 구현으로 정렬
		Arrays.sort(group);
		System.out.println("Comrapable 오름차순 정렬 : " + Arrays.toString(group));
		
		// Comparator Interface 구현으로 정렬
		Comparator<Human> comparator = new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return Integer.compare(o2.age, o1.age); // 역순이 되도록 한다.
			}
		};
		
		Arrays.sort(group, comparator);
		System.out.println("Comparator 내림차순 정렬 : " + Arrays.toString(group));
		
		//---------------------------------------------------------------------------//
		
		// 추상메서드를 1개만 가진 Functional Interface(함수형 인터페이스)는 람다 표현식으로 대체할 수 있다.
		Comparator<Human> comparatorL = (h1, h2) -> Integer.compare(h1.age, h2.age);
		Arrays.sort(group, comparatorL);
		System.out.println("Comparator(람다) 오림차순 정렬 : " + Arrays.toString(group));
		
		Arrays.sort(group, (h1, h2) -> Integer.compare(h2.age, h1.age)); // 내부적으로는 compare호출시 람다 바디부분이 실행된다.
		System.out.println("Comparator(람다) 내림차순 정렬 : " + Arrays.toString(group));
	
		//---------------------------------------------------------------------------//
		
		// Functional Interface 를 람다표현식으로 사용예제(Runnable, Predicate)
		// Runnalbe 사용
		Runnable task = () -> System.out.println("Thread Task 실행1");
		new Thread(task).start();
		new Thread(() -> System.out.println("Thread Task 실행2")).start();
		
		// Predicate 사용
		ArrayList<Human> list = new ArrayList<Human>(Arrays.asList(group));
		Predicate<Human> pObj = new Predicate<Human>() {
			@Override
			public boolean test(Human t) {
				return t.age <= 10 ? true : false; // 10살 이하 제외
			}
		};
		list.removeIf(pObj);
		System.out.println("10살 이하 제외 : " + list);
		
		// Predicate Interface는 람다표현식을 위해 전달받을 용도로 설계됨
		list.removeIf(t -> t.age >= 30 ? true : false); // 30살 이상 제외
		System.out.println("30살 이상 제외 : " +list);
		
		//---------------------------------------------------------------------------//
		
	}
}

/**
 * Comrapable Interface를 구현하여 sort할수 있게 한다.
 */
class Human implements Comparable<Human>{
	public int age;
	
	public Human(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Human pHuman) {
		return Integer.compare(this.age, pHuman.age);
	}
	
	public String toString() {
		return Integer.toString(this.age);
	}
}
