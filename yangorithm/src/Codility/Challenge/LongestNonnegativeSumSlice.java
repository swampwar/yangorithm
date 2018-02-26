package Codility.Challenge;

public class LongestNonnegativeSumSlice {
	
	public static void main(String[] args) {
		int[] A = {-1, -1, 1, -1, 1, 0, 1, -1, -1};
		int[] B = {1, 1, -1, -1, -1, -1, -1, 1, 1};
		int[] C = {-1, -1, -1};
		
		System.out.println(new LongestNonnegativeSumSlice().solution(A)); // 7
		System.out.println(new LongestNonnegativeSumSlice().solution(B)); // 4
		System.out.println(new LongestNonnegativeSumSlice().solution(C)); // 0
	}
	
	public int solution(int[] A){
		int length = 0;
		for(int from=0; from<A.length; from++){
			if(A.length - from <= length) break;
			
			int sum = 0;
			for(int to=from; to<A.length; to++){
				int newLength = to-from+1;
				sum += A[to];

				if(newLength > length && sum >= 0){
					length = newLength;
				}
			}
			sum = 0;
		}
		return length;
	}
}

/*

Task description
You are given an array A consisting of the integers −1, 0 and 1. A slice of that array is any pair of integers (P, Q) such that 0 ≤ P ≤ Q < N. Your task is to find the longest slice of A whose elements yield a non-negative sum.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of length N, consisting only of the values −1, 0, 1, returns the length of the longest slice of A that yields a non-negative sum. If there's no such slice, your function should return 0.

For example, given A = [−1, −1, 1, −1, 1, 0, 1, −1, −1], your function should return 7, as the slice starting at the second position and ending at the eighth is the longest slice with a non-negative sum.

For another example, given A = [1, 1, −1, −1, −1, −1, −1, 1, 1] your function should return 4: both the first four elements and the last four elements of array A are longest valid slices.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1..1].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

*/