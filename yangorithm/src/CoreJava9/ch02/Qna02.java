package CoreJava9.ch02;

import java.util.Random;
import java.util.Scanner;

public class Qna02 {

	public static void main(String[] args) {
		// Scanner의 nextInt()는 변경자인가? 접근자인가?
		// 변경자 - 호출되는 객체를 변경
		// 접근자 - 호출되는 객체를 변경하지 않음   ex)새로운 객체를 생성하여 반환
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		// Random의 nextInt()는 변경자인가? 접근자인가?
		Random random = new Random();
		int b = random.nextInt(a);
		System.out.println(b);
		
	}
	
	

}
