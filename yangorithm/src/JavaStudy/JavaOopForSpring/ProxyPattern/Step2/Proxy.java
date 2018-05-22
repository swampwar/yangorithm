package JavaStudy.JavaOopForSpring.ProxyPattern.Step2;

public class Proxy implements IService {
	IService service;
	
	@Override
	public String runSomething() {
		System.out.println("호출에 대한 흐름 제어가 주목적, 반환 결과를 그대로 전달");
		
		service = new Service();
		return service.runSomething();
		
		/*
		 * 프록시(대리자)는 실제 서비스와 같은 이름의 메서드를 구현한다. (인터페이스 사용)
		 * 실제 서비스에 대한 참조변수를 갖는다.
		 * 실제 서비스의 같은 이름을 가진 메서드를 호출하고 그 값을 클라이언트에게 돌려준다.
		 * 실제 서비스의 호출 전후에 별도의 로직을 수행할 수 있다. 
		 *  > 실제 반환값에 대해 가감하는 것이 목적이 아니라 흐름을 제어하거나 다른 로직을 수행하기 위해 사용한다. 
		 */
	}

}
