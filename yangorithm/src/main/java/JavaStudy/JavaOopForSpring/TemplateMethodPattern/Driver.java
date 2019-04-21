package JavaStudy.JavaOopForSpring.TemplateMethodPattern;

public class Driver {

	public static void main(String[] args){
		
		SubClassA objA = new SubClassA();
		SubClassB objB = new SubClassB();
		
		objA.mainMethod();
		objB.mainMethod();
		
		/*
		 *  상위 클래스에 공통 로직을 수행하는 템플릿 메서드와(mainMethod())
		 *  오버라이딩을 강제하는 추상메서드 또는 선택적으로 오버라이딩 할 수 있는 훅 메서드를
		 *  두는 패턴을 '템플릿 메서드 패턴'이라 한다.
		 * 
		 */
	}
}
