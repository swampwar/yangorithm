package JavaStudy.JavaOopForSpring.Singleton.Step1;

public class Client {

	public static void main(String[] args){
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		// toString() 반환값이 동일한 메모리 주소를 가리킨다.
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
	}
}
