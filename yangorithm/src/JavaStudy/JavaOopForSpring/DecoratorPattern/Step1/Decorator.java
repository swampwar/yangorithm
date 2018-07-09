package JavaStudy.JavaOopForSpring.DecoratorPattern.Step1;

public class Decorator implements IService {

	IService svc;
	@Override
	public String runSomething() {
		svc = new Service();
		System.out.println("Decorator Run");
		return svc.runSomething() + " + Decorator";
	}

}
