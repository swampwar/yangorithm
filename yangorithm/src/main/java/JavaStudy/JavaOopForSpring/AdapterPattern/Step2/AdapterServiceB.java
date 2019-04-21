package JavaStudy.JavaOopForSpring.AdapterPattern.Step2;

public class AdapterServiceB {
	ServiceB sb = new ServiceB();
	
	void runService() {
		sb.runServiceB();
	}
	
}
