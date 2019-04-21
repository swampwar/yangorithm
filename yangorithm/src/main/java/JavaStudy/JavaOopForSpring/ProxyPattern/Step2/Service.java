package JavaStudy.JavaOopForSpring.ProxyPattern.Step2;

public class Service implements IService {
	
	@Override
	public String runSomething() {
		return "실제 서비스 짱!";
	}

}
