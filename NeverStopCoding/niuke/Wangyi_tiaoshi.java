package niuke;

import java.util.ArrayList;
import java.util.Scanner;

public class Wangyi_tiaoshi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		flow();
	}
	
	public static void flow(){
		sc = new Scanner(System.in);
//		while(sc.hasNextInt()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int count = forword(n, m);
			System.out.println(count);
//		}
	}
	
	private static int count = 0;
	private static Scanner sc;
	public static int forword(int n, int m){
		count++;
		ArrayList<Integer> a = getyueshu(n);
		if(a.size() == 0){
			count = -1;
		} else {
			for(int i = 0; i < a.size(); i++){
				int next = n + a.get(i);
				if(next != m){
					forword(next, m);
				} else {
					break;
				}
			}
		}
		return count;
	}
	
	// 得到一个数的所有约数（除去1和它本身n）
	public static ArrayList<Integer> getyueshu(int n){
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 2; i < n; i++){
			int yushu = n % i;
			if(yushu == 0){
				a.add(i);
			}
		}
		return a;
	}

}
