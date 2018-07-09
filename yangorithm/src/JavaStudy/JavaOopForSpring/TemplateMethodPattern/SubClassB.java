package JavaStudy.JavaOopForSpring.TemplateMethodPattern;

public class SubClassB extends TemplateMethodClass {

	@Override
	public void abstractMethod() {
		System.out.println("abstract method override in subClassB");
	}
	
	// 하위 클래스에서 훅메서드는 선택적으로 오버라이드가 가능하다.
	@Override
	public void hookMethod(){
		System.out.println("run hookMethod override in subClassB");
	}

}
