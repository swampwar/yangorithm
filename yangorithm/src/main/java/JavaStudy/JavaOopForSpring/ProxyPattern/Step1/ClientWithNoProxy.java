package JavaStudy.JavaOopForSpring.ProxyPattern.Step1;

public class ClientWithNoProxy {

	public static void main(String[] args) {
		
		// 프록시를 활용하지 않고 서비스를 호출
		Service s = new Service();
		System.out.println(s.runSomething());

	}

}
