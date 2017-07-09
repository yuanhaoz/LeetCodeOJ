package test;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m, n;
//        String nm = in.nextLine();
//        String[] nms = nm.split(" ");
        n = in.nextInt();
        m = in.nextInt();
        int[] scores = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            scores[i] = in.nextInt();
        }
        in.nextLine();
        for (int j = 0; j < m; j++) {
        	String next = in.nextLine();
        	String[] nexts = next.split(" ");
        	if ("Q".equals(nexts[0])) {
        		System.out.println(query(scores, Integer.parseInt(nexts[1]), Integer.parseInt(nexts[2])));
        	} else {
        		update(scores, Integer.parseInt(nexts[1]), Integer.parseInt(nexts[2]));
        	}        	
        }        
    }
    
    public static int query(int[] scores, int a, int b){
        int max = Integer.MIN_VALUE;
        for (int i = a; i < b + 1; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }
    
    public static void update(int[] scores, int a, int b){
        scores[a] = b;
    }
}