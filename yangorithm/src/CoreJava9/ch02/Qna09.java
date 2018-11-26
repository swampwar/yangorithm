package CoreJava9.ch02;

public class Qna09 {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.refuel(10);
		
		if(myCar.move(5)) System.out.println(myCar.toString());
		if(myCar.move(3)) System.out.println(myCar.toString());

		myCar.move(2);
		System.out.println(myCar.toString());
		
		// Q : Car 클래스를 불변클래스로 작성해야 하는가?
		// A : 클래스의 인스턴스변수가(연료량,현재위치) 호출되는 메서드에 따라 계속 바뀌어야 하므로 불변 클래스와는 맞지않다.
	}	
}


class Car {
	double mile; // 원점부터의 거리(마일)
	double MPG; // 갤런당 이동마일
	double gallon; // 연료량(갤런)
	
	public Car() {
		this.mile = 0;
		this.MPG = 1;
	}
	
	public Car(double mile, double MPG) {
		this.mile = mile;
		this.MPG = MPG;
	}
	
	/**
	 * 이동
	 * 
	 * @param milesToGo
	 * @return
	 */
	public boolean move(double milesToGo) {
		if(milesToGo / MPG > this.gallon) {
			return false; // 연료부족
		}else { 
			this.mile += milesToGo;
			this.gallon -= milesToGo/MPG;
		}
		return true;
	}

	/**
	 * 연료 주입
	 * 
	 * @param gallon
	 */
	public void refuel(double gallon) {
		this.gallon += gallon;
	}
	
	public String toString() {
		return "현재위치 : " + this.mile + ", 남은 연료량 : " + this.gallon;
	}
	
}