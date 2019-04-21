package JavaStudy.JavaOopForSpring.AdapterPattern.Step2;

public class AdapterServiceA {
	ServiceA sa = new ServiceA();
	
	void runService() {
		sa.runServiceA();
	}
	
}
