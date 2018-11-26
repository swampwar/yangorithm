package CoreJava9.ch03;

/**
 * Interface 기초, 기본활용
 * 
 * @author Yang
 */
public class Interface {

	public static void main(String[] args) {
		// Interface의 변수는 자동 static final이 되므로 Class명으로 접근할 수 있다.
		System.out.println(IntSequence.OFF);
		
		// 1부터 100까지 사각형의 넓이의 합을 구한다.
		SquareSequence squares = new SquareSequence();
		double avg = IntSequence.average(squares, 100);
		System.out.println(avg);
		
		// 1729의 각 자릿수의 합을 구한다.
		IntSequence digits = new DigitSequence(1729); // 슈퍼타입으로 형변환 가능
		double davg = IntSequence.average(digits, 100);
		System.out.println(davg);
		
		// 슈퍼타입 -> 서브타입으로 강제형변환(캐스트)가 가능하다.
		if(digits instanceof DigitSequence) {
			DigitSequence newDigits = (DigitSequence) digits;
		}
		
		if(digits instanceof SquareSequence) {
			// 문법에는 오류가 없으나 런타임에서 ClassCastException이 발생한다. (digits은 DigitSequence Class의 객체이므로)
			SquareSequence sq = (SquareSequence) digits;
		}
	}
}

interface IntSequence {
	int OFF = 1; // Interface에서 정의한 변수는 자동으로 public static final 이 된다.
	int ON = 0;
	
	int next(); // interface의 모든 추상메서드는 자동으로 public이 된다.
	
	default boolean hasNext() { // Interface에 defualt method의 구현이 가능하다. 하위 클래스에서 오버라이드도 가능하다.
		return true;
	}
	
	// Interface에 static method의 구현이 가능하다.
	public static double average(IntSequence seq, int n) {
		int count = 0;
		double sum = 0;
		
		while(seq.hasNext() && count < n) {
			count++;
			sum += seq.next();
		}
		
		return count == 0 ? 0 : sum/count;
	}
	
	// Interface에 defualt method의 구현이 가능하다.
	default void print() {
		System.out.println("Interface에서 defualt method 구현가능");
	}
}


/**
 * 1부터 n까지 사각형 넓이를 반환하는 Class
 * 
 * @author Yang
 */
class SquareSequence implements IntSequence {
	private int i;
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public int next() {
		i++;
		return i*i;
	}
}

/**
 * 초기화된 number의 낮은자릿수부터 양의 정수를 반환하는 Class
 * 
 * @author Yang
 */
class DigitSequence implements IntSequence {
	private int number;
	
	public DigitSequence(int number) {
		this.number = number;
	}
	
	@Override
	public boolean hasNext() {
		return this.number != 0; // 모든 자릿수가 지나면 false
	}

	@Override
	public int next() {
		int result = this.number%10;
		this.number /= 10;
		
		return result;
	}
	
	public int rest() {
		return this.number;
	}
}
