package CoreJava9.ch02;

public class Qna05 {
	public static void main(String[] args) {
		Point p1 = new Point(3,4).translate(1, 3).scale(0.5);
		System.out.println(p1);
	}
}

class Point {
	private double x;
	private double y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point translate(int x, int y) { // 접근자 메서드
		return new Point(this.x + x, this.y + y);
	}
	
	public void translateThis(int x, int y) { // 변경자 메서드
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public Point scale(double s) {
		return new Point(this.x*s, this.y*s);
	}
	
	public void scaleThis(double s) {
		this.x = this.x*s;
		this.y = this.y*s;
	}
	
	public String toString() {
		return "X : " + this.x + ", Y : " + this.y;
	}
}
