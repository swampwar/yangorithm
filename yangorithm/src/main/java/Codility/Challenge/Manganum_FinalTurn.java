package Codility.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Manganum_FinalTurn {
	static int sumScore = 0;
	
	public static void main(String[] args) {

		int[] X = { 3, 5, 1, 6 };
		int[] Y = { 1, 3, 3, 8 };
		String T = "Xpqp";
		
		System.out.println(Arrays.toString(X));
		System.out.println(Arrays.toString(Y));
		System.out.println(new Manganum_FinalTurn().solution(X, Y, T));
		
		int[] X2 = {0, 3, 5, 1, 6};
		int[] Y2 = {4, 1, 3, 3, 8};
		T = "pXpqp";
		System.out.println(new Manganum_FinalTurn().solution(X2, Y2, T));

	}
	
	public int getMaxValue(int[] array) {
		int[] tempX = Arrays.copyOfRange(array, 0, array.length);
		Arrays.sort(tempX);
		return tempX[tempX.length-1];
	}
	
	public int getMinValue(int[] array) {
		int[] tempX = Arrays.copyOfRange(array, 0, array.length);
		Arrays.sort(tempX);
		return tempX[0];
	}
	
	public int isPoint(int[] X, int[] Y, int x, int y){
		for(int idx=0; idx<X.length; idx++){
			if(X[idx] == x && Y[idx] == y) return idx;
		}
		return -1;
	}
	
	public int getScore(char c) {
		if(c == 'p') {
			return 1;
		}else if(c == 'q') {
			return 10;
		}
		return 0;
	}
	
	
	public int[] getRightPoint(int[] X, int[] Y, int[] queen, int score, String T) {
		int max_x = getMaxValue(X);
		int max_y = getMaxValue(Y);
		
		System.out.println("max_x : " + max_x);
		System.out.println("max_y : " + max_y);

		int moved_queen_x = queen[0]+1;
		int moved_queen_y = queen[1]+1;
		
		int[] right_point = {0, 0, score};
		
		while(!(moved_queen_x > max_x || moved_queen_y > max_y)) {
			int pointIdx = isPoint(X, Y, moved_queen_x, moved_queen_y);
			
			if(pointIdx != -1) {
				if(isPoint(X, Y, moved_queen_x+1, moved_queen_y+1) == -1) {
					right_point[0] = moved_queen_x+1;
					right_point[1] = moved_queen_y+1;
					right_point[2] = score + getScore(T.charAt(pointIdx));
					
					System.out.println("get right point");
					System.out.println(moved_queen_x + "," + moved_queen_y + "::::" +right_point[2]);
					
				}else {
					System.out.println("오른쪽은 탈락!");
				}
				
				break;
			}
			
			moved_queen_x++;
			moved_queen_y++;
		}
		
		return right_point;
	}
	
	public int[] getLeftPoint(int[] X, int[] Y, int[] queen, int score, String T) {
		int min_x = getMinValue(X);
		int max_y = getMaxValue(Y);
		
		System.out.println("min_x : " + min_x);
		System.out.println("max_y : " + max_y);

		int moved_queen_x = queen[0]-1;
		int moved_queen_y = queen[1]+1;
		
		int[] left_point = {0, 0, score};
		
		while(!(moved_queen_x < min_x || moved_queen_y > max_y)) {
			int pointIdx = isPoint(X, Y, moved_queen_x, moved_queen_y);
			if(pointIdx != -1) {
				if(isPoint(X, Y, moved_queen_x-1, moved_queen_y+1) == -1) {
					left_point[0] = moved_queen_x-1;
					left_point[1] = moved_queen_y+1;
					left_point[2] = score + getScore(T.charAt(pointIdx));
					
					System.out.println("get left point");
					System.out.println(moved_queen_x + "," + moved_queen_y + "::::" +left_point[2]);
				}else {
					System.out.println("왼쪽은 탈락!");
				}
				break;
			}
			
			moved_queen_x--;
			moved_queen_y++;
		}
		
		return left_point;
	}
	
	public void searchPoint(int[] X, int[] Y, int[] queen, String T){
		int max_y = getMaxValue(Y);
		int[] temp_right_queen = Arrays.copyOfRange(queen, 0, queen.length);
		int[] temp_left_queen = Arrays.copyOfRange(queen, 0, queen.length);
		
	}
	
	public int solution(int[] X, int[] Y, String T){
		int queenIdx = T.indexOf('X');
		int score = 0;
		int[] queen = {X[queenIdx],Y[queenIdx], score};
		
		int[] right_point = getRightPoint(X, Y, queen, score, T);
		int[] left_point = getLeftPoint(X, Y, queen, score, T);
		
		searchPoint(X, Y, queen, T);
		
		if(right_point[0] + right_point[1] != 0){
			goNextStep(X, Y, right_point, right_point[2], T);
		}
		if(left_point[0] + left_point[1] != 0){
			goNextStep(X, Y, left_point, left_point[2], T);
		}
		
		return 0;
	}
	
	public void goNextStep(int[] X, int[] Y, int[] queen, int score, String T){
		int max_y = getMaxValue(Y);
		
		while(queen[1] < max_y){
			int[] right_point = getRightPoint(X, Y, queen, score, T);
			if(right_point[0] + right_point[1] == 0){
				if(sumScore < right_point[2]){
					sumScore = right_point[2];
				}
			}else{
				goNextStep(X, Y, right_point, right_point[2], T);
			}
			
			int[] left_point = getLeftPoint(X, Y, queen, score, T);
			if(left_point[0] + left_point[1] == 0){
				if(sumScore < left_point[2]){
					sumScore = left_point[2];
				}
			}else{
				goNextStep(X, Y, left_point, left_point[2], T);
			}
			
		}
	}
	

	
	

}
