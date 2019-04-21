package JavaStudy.JavaOopForSpring.DecoratorPattern.Step1;

public class ClientWithDecorator {

	public static void main(String[] args) {
		
		IService decorator = new Decorator();
		System.out.println(decorator.runSomething());
		
		/*
		 *  인터페이스를 사용하여 실제 사용되는 메서드를 같이 구현하고 중간에 로직을 추가할 수 있는 것은
		 *  프록시 패턴과 같으나 반환 결과를 조작하여(데코하여) 전달하는 것이 프록시 패턴과의 차이점이다.
		 *
		 */

	}

}
