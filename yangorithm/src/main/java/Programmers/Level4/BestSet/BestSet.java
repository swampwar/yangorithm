package Programmers.Level4.BestSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class BestSet {
	int max_multi_num = 0;
	int[] answer;
	
    public int[] bestSet(int n, int sum){
    	if(sum < n) answer = new int[]{-1};
    	
    	fillArray(new int[n], sum);
    	
        return answer;
    }
    
    public void fillArray(int[] iArray, int sum){
    	int workIdx = 0;
    	int nowSum = 0;
    	
    	for(int idx=0; idx<iArray.length; idx++){
    		if(iArray[idx] == 0){
    			workIdx = idx;
    			break;
    		}
    		nowSum += iArray[idx];
    	}

    	if(workIdx == iArray.length-1){ // 마지막 index 이면
    		iArray[workIdx] = sum-nowSum;
//    		System.out.println("종료 : " + Arrays.toString(iArray));
    		
    		int multiNum = 1;
    		for(int idx=0; idx<iArray.length; idx++){
    			multiNum *= iArray[idx];
    		}
    		
    		if(max_multi_num < multiNum){
    			answer = iArray;
    			max_multi_num = multiNum;
    		}
    	}else{ // 마지막 index가 아니면
    		for(int i=1; i<=sum-nowSum-(iArray.length-workIdx-1); i++){
    			int[] nArray = new int[iArray.length];
    			
    			for(int idx=0; idx<workIdx; idx++){
    				nArray[idx] = iArray[idx];
    			}
    			nArray[workIdx] = i;

    			fillArray(nArray, sum);
    		}
    		
    	}
    }
    
    public static void main(String[] args) {
        BestSet c = new BestSet();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(Arrays.toString(c.bestSet(3,13)));
    }

}
