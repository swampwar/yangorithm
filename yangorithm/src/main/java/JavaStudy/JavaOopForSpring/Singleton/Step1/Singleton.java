package JavaStudy.JavaOopForSpring.Singleton.Step1;

public class Singleton {

	static Singleton singletoneObject; // 정적 참조변수
	
	private Singleton(){} // private 생성자
	
	public static Singleton getInstance(){
		if(singletoneObject == null){
			singletoneObject = new Singleton();
		}
		
		return singletoneObject;
	}
}
