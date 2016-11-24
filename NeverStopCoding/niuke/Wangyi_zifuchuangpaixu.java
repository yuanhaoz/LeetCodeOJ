package niuke;

import java.util.ArrayList;
import java.util.Scanner;

public class Wangyi_zifuchuangpaixu {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int n = sc.nextInt();
	        ArrayList<String> list = new ArrayList<String>();
	        for(int i = 0; i < n; i++){
	        	String str = sc.next();
	        	list.add(str);
	        }
	        int a = sortByDic(list, n);
	        int b = sortByLen(list, n);
	        if(a == 1 && b == 0){
	        	System.out.println("lexicographically");
	        } else if(a == 0 &&b == 1){
	        	System.out.println("lengths");
	        } else if(a == 1 &&b == 1){
	        	System.out.println("both");
	        }
		}
	}
	
	public static int sortByLen(ArrayList<String> list, int n){
		int[] len = new int[n];
		for(int i = 0; i < n; i++){
			String str = list.get(i);
			len[i] = str.length();
		}
		int flag = 1;
		for(int i = 0; i < n - 1; i++){
			if(len[i] > len[i + 1]){
				flag = 0;
			}
		}
		return flag;
	}
	
	public static int sortByDic(ArrayList<String> list, int n){
		int flag = 1;
		for(int i = 0; i < list.size() - 1; i++){
			String p = list.get(i);
			String q = list.get(i + 1);
			int len = 0;
			int plen = p.length();
			int qlen = q.length();
			if(plen > qlen){
				len = qlen;
			} else {
				len = plen;
			}
			if(p.charAt(0) > q.charAt(0)){
				flag = 0;
			}else if(p.charAt(0) < q.charAt(0)){
				flag = 1;
			}else{
				for(int j = 1; j < len; j++){
					char pm = p.charAt(j);
					char qm = q.charAt(j);
					if(pm > qm){
						flag = 0;
					}
				}
			}
		}
		return flag;
	}
	
	
}
