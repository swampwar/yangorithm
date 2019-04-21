package JavaStudy.JavaOopForSpring.FactoryMethodPattern;

// 팩토리 메서드가 생성할 객체
public class CatToy extends AnimalToy{

	@Override
	void identify() {
		System.out.println("i'm cat's toy");
	}

}
