package niuke;

/**
 */

import java.util.Scanner;

public class Wangyi_yuanzhengshu {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		workflow();
	}
	
	public static void workflow(){
		sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int area = sc.nextInt();
			double rad = Math.sqrt(area);
			int r = (int)rad;
			if(rad == r){
				int count = getNode(r);
				System.out.println(count);
			}
		}
	}
	
	public static int getNode(int r){
		int count = 0;
		int area = r*r;
		for(int i = -r; i <= r; i++){
			for(int j = -r; j <= r; j++){
				int x2 = i*i;
				int y2 = j*j;
				int area2 = x2 + y2;
				if(area == area2){
					count++;
				}
			}
		}
		return count;
	}

}
