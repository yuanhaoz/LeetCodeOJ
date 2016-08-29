package algorithmJava;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static int rank(int key, int[] a){
		// 数组必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			//被查找的键要么不存在，要么必然存在于a[lo..hi]之中
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid]){
				hi = mid - 1;
			} else if(key > a[mid]){
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] whitelist = {1,3,9,12,30,60,100};
		Arrays.sort(whitelist);
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			//读取键值，如果不存在于白名单中则将其打印
			int key = in.nextInt();
			if(rank(key, whitelist) < 0){
				System.out.println(key);
			}
		}
	}

}
