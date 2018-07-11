package CoreJava9.ch02;

public class StaticBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1번");
		TestClass testclass1 = new TestClass();
		System.out.println("2번");
		TestClass testclass2 = new TestClass();
		System.out.println("3번");
		TestClass testclass3 = new TestClass();
	}

}

class TestClass{
	static {
		System.out.println("static block이 실행됩니다.");
	}
}