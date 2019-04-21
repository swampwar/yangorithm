package Programmers.Level4.BestSet;

import java.util.Arrays;

public class BestSetNew {
    public int[] bestSet(int n, int sum){
    	
    	if(sum < n) return new int[]{-1};

    	int[] answer = new int[n];
    	int now_sum = 0;
    	
    	for(int idx=0; idx<answer.length; idx++){
    		int num = (sum-now_sum) / (answer.length-idx);
    		
    		answer[idx] = num;
    		now_sum += num;
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
        BestSetNew c = new BestSetNew();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(Arrays.toString(c.bestSet(3,13)));
    }
}
