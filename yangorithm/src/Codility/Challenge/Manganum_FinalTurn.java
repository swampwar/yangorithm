package Codility.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Manganum_FinalTurn {
	public static void main(String[] args) {

		int[] X = { 3, 5, 1, 6 };
		int[] Y = { 1, 3, 3, 8 };
		String T = "Xpqp";
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
					right_point[0] = moved_queen_x;
					right_point[1] = moved_queen_y;
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
					left_point[0] = moved_queen_x;
					left_point[1] = moved_queen_y;
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
	

	public int solution(int[] X, int[] Y, String T){
		int queenIdx = T.indexOf('X');
		int[] queen = {X[queenIdx],Y[queenIdx]};
		int score = 0;

		int[] right_point = getRightPoint(X, Y, queen, score, T);
		int[] left_point = getLeftPoint(X, Y, queen, score, T);
		
		// 1. get access point 
		/*
		int min_distX_right = 10;
		int min_distX_left = 10;
		Integer[] r_point = new Integer[2];
		Integer[] l_point = new Integer[2];
		ArrayList<Integer[]> access_point_list = new ArrayList<Integer[]>();
		
		for(int idx=0; idx< X.length; idx++){
			Integer[] point = {X[idx], Y[idx]};
			int distX = point[0] - queen[0];
			int distY = point[1] - queen[1];
			
			if(distY <= 0) continue; // 위에줄이 아니면 재낀다 
			
			// 대각선 && 인접point 없음 && 제일 가까운놈
			if(Math.abs(distX) == distY){
				if(distX > 0){ // 양놈
					if(Math.abs(distX) < min_distX_right){
						min_distX_right = distX;
						if(!isPoint(X,Y,point[0]+1,point[1]+1)){
							r_point = point;
						}
					}
				}else if(distX < 0){ // 음놈
					if(Math.abs(distX) < min_distX_left){
						min_distX_left = Math.abs(distX);
						if(!isPoint(X,Y,point[0]-1,point[1]+1)){
							l_point = point;
						}
					}
				}
			}
		}
		
		access_point_list.add(l_point);
		access_point_list.add(r_point);
		for(int i=0; i<access_point_list.size(); i++){
			System.out.println(Arrays.toString(access_point_list.get(i)));
		}
		*/
		// 2. sum point
		
		
		// 
		
		return 0;
	}
	

	
	

}
