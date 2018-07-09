package Codility.Challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zinc {

	public static void main(String[] args) {
/*
		For example, given A = [1, 2, 1, 1], the function should return 3 as exmplained above.

				Given A = [1, 2, 3, 4], the function should return 4. There are four ways to spend tickets: (1, 2, 3), (1, 2, 4), (1, 3, 4) and (2, 3, 4).

				Given A = [2, 2, 2, 2], the function should return 1. There is only one way to spend tickets: (2, 2, 2).

				Given A = [2, 2, 1, 2, 2], the function should return 4. There are four ways to spend tickets: (1, 2, 2), (2, 1, 2), (2, 2, 1) and (2, 2, 2).

				Given A = [1, 2], the function should return 0. Kate cannot use all three tickets in only two days.
*/
	    int[] A = {1, 2, 1, 1}; // 3 
		int[] B = {1, 2, 3, 4}; // 4
		int[] C = {2, 2, 2, 2}; // 1
		int[] D = {2, 2, 1, 2, 2}; // 4
		int[] E = {1, 2}; // 0
		
		System.out.println("A : " + solution(A));
		System.out.println("B : " + solution(B));
		System.out.println("C : " + solution(C));
		System.out.println("D : " + solution(D));
		System.out.println("E : " + solution(E));
		
	}
	
	public static int solution(int[] A) {
		List<Integer> int_array = new ArrayList<Integer>();
		int_array.add(A[0]);
		
		for(int i=1; i<A.length; i++) {
			if(int_array.get(int_array.size()-1) != A[i]) {
				int_array.add(A[i]);
			}
		}

		HashSet<String> strSet = new HashSet<String>();
		
		for(int i=0; i<A.length-2; i++) {
			for(int j=i+1; j<A.length-1; j++) {
				for(int k=j+1; k<A.length; k++) {
					strSet.add(A[i] + "," + A[j] + "," + A[k]);
				}
			}
		}
		
		System.out.println(strSet.toString());
		
		return strSet.size();
		
	}

}
