package JavaStudy.JavaOopForSpring.ProxyPattern.Step2;

public class ClientWithProxy {

	public static void main(String[] args) {
		
		// 프록시를 활용하여 서비스 호출
		IService proxy = new Proxy();
		System.out.println(proxy.runSomething());

		/*
		 * 프록시 패턴에서는 실제 서비스 객체가 가진 메서드와 같은 이름의 메서드를 사용하며 이를 위해 인터페이스를 사용한다.
		 * 
		 */
	}

}
