package CoreJava9.ch02;

public class StaticPractice {
	public static void main(String[] args) {
		System.out.println("main start");
		TestClass firstObj = new TestClass(); // TestClass의  static block이 실행됨
		TestClass secondObj = new TestClass();
		
		TestClass.getInstance(); // 객체의 선언없이 클래스명으로 static method 실행이 가능하다.
	}
}

class TestClass{
	static final String instanceOne; // static 상수 변수
	
	static { // static 초기화 블록 : 처음 클래스를 로드할 때만 실행된다.(첫번째 객체가 생성될때)
		System.out.println("static block은 처음 객체가 생성될 때만 실행됩니다.");
		instanceOne = "I'm One"; // 정적 상수 초기화
	}
	
	public static TestClass getInstance() { // static method
		System.out.println("static method 실행");
		
		// static method는 주로 factory method로 활용된다.(클래스의 새 인스턴스를 반환하는 메서드)
		return new TestClass();
	}
	
}