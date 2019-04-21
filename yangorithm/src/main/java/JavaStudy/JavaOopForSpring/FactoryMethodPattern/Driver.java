package JavaStudy.JavaOopForSpring.FactoryMethodPattern;

public class Driver {
	public static void main(String[] args){
		// 팩토리 메서드를 보유한 객체들 생성
		Animal bolt = new Dog();
		Animal kitt = new Cat();
		
		// 팩토리 메서드가 반환하는 객체들
		AnimalToy boltToy = bolt.getToy();
		AnimalToy kittToy = kitt.getToy();
		
		// 팩토리 메서드가 반환한 객체들을 사용
		boltToy.identify();
		kittToy.identify();
	
	    /* 오버라이드된 메서드가 객체를 반환하는 패턴
	     *  
	     */
	}
}
