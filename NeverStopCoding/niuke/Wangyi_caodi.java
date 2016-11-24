package niuke;

import java.util.Scanner;

public class Wangyi_caodi {
	private static Scanner sc;

	public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[2][n];
        for(int i = 0; i < n; i++){
        	a[0][i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
        	a[1][i] = sc.nextInt();
        }
        int[] dis = distance(a);
        int min = getmin(dis);
        System.out.println(min);
	}
	
	public static int[] distance(int[][] a){
		int len = a[0].length;
		int[] dis = new int[len];
		for(int i = 0; i < a[0].length; i++){
			int x = a[0][i];
			int y = a[1][i];
			int distance = (x - 1) + (y - 1);
			dis[i] = distance;
		}
		return dis;
	}
	
	public static int getmin(int[] a){
		int min = a[0];
		for(int i = 1; i < a.length; i++){
			if(min > a[i]){
				min = a[i];
			}
		}
		return min;
	}
}