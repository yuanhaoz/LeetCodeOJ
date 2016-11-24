package niuke;

import java.util.HashSet;
import java.util.Scanner;

public class Wangyi_xaicufang {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<String> a = new HashSet<String>();
		while(n > 0){
			String line = sc.next();
			System.out.println(line);
			String[] strs = line.split(" "); 
			for(int i = 0; i < strs.length; i++){
				a.add(strs[i]);
			}
			n--;
		}
		System.out.println(a.size());
	}
	
}
