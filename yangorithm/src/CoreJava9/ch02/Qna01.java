package CoreJava9.ch02;

import java.time.LocalDate;

public class Qna01 {

	public static void main(String[] args) {
		Qna01 thisObj = new Qna01();
		
		System.out.println("월요일이 시작인 달력 출력");
		thisObj.printCalMonFirst(2018, 11);
		
		System.out.println("----------------------------");
		
		System.out.println("일요일이 시작인 달력 출력");
		thisObj.printCalSunFirst(2018, 11);
	}
	
	public void printCalMonFirst(int year, int month) {
		LocalDate date = LocalDate.of(year, month, 1); // 해당 월의 첫째날
		System.out.println(date.getYear() + "/" +date.getMonth().getValue());
		System.out.println(" Mon Tue Web Thu Fri Sat Sun");
		
		while(month == date.getMonthValue()) {
			if(date.getDayOfMonth() == 1) { // 첫째날이면 공백 삽입
				for(int i=1; i<date.getDayOfWeek().getValue(); i++) {
					System.out.print("    ");
				}
			}
			System.out.printf("%4d", date.getDayOfMonth());
			
			if(date.getDayOfWeek().getValue() == 7) System.out.println(""); // 한주가 끝나면 줄바꿈
			date = date.plusDays(1); // 다음날짜
		}
		System.out.println("");
	}
	
	public void printCalSunFirst(int year, int month) {
		LocalDate date = LocalDate.of(year, month, 1); // 해당 월의 첫째날
		System.out.println(date.getYear() + "/" +date.getMonth().getValue());
		System.out.println(" Sun Mon Tue Web Thu Fri Sat");
		
		while(month == date.getMonthValue()) {
			if(date.getDayOfMonth() == 1) { // 첫째날이면 공백 삽입
				for(int i=0; i<date.getDayOfWeek().getValue(); i++) {
					System.out.print("    ");
				}
			}
			System.out.printf("%4d", date.getDayOfMonth());
			
			if(date.getDayOfWeek().getValue() == 6) System.out.println(""); // 한주가 끝나면 줄바꿈
			date = date.plusDays(1); // 다음날짜
		}
		System.out.println("");
	}

}
