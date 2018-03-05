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

	public int solution(int[] X, int[] Y, String T){
		int queenIdx = T.indexOf('X');
		
		// 1. get access point 
		int[] queen = {X[queenIdx],Y[queenIdx]};
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
		
		// 2. sum point
		
		
		// 
		
		return 0;
	}
	
	public boolean isPoint(int[] X, int[] Y, int x, int y){
		for(int idx=0; idx<X.length; idx++){
			if(X[idx] == x && Y[idx] == y) return true;
		}
		return false;
	}

}
