package Programmers.Level4.Expressions;

public class Expressions {

	public int expressions(int num) {
		int answer = 0;

		for(int n=1; n<=num; n++) {
			int temp_sum = 0;
			int start_num = n;
			
			while(temp_sum < num) {
				temp_sum += start_num;
				start_num++;
				
				if(temp_sum == num) {
					answer++;
				}
			}
		}

		return answer;
	}

	public static void main(String args[]) {
		Expressions expressions = new Expressions();
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(expressions.expressions(15));
	}
}