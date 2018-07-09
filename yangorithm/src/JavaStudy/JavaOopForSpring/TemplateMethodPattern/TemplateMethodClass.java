package JavaStudy.JavaOopForSpring.TemplateMethodPattern;

public abstract class TemplateMethodClass {

	// 템플릿을 제공하는 메서드
	public void mainMethod(){
		hookMethod();
		abstractMethod();
	}
	
	// 하위 클래스에서 강제로 오버라이드 해야하는 추상메서드
	public abstract void abstractMethod();
	
	// 하위 클래스에서 선택적으로 오버라이드 가능한 훅(Hook)메서드
	public void hookMethod(){
		System.out.println("run hookMethod");
	}
}
