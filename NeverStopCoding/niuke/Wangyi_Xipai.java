package niuke;

/**
 * 004 - 网易有道2017内推编程题
[编程题] 洗牌
洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。 
输入描述:
第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
输出描述:
对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
输入例子:
3
3 1
1 2 3 4 5 6
3 2
1 2 3 4 5 6
2 2
1 1 1 1
输出例子:
1 4 2 5 3 6
1 5 4 3 2 6
1 1 1 1
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Wangyi_Xipai {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test();
		workflow();
	}
	
	// 测试程序
	public static void test(){
		int n = 3;
		int k = 3;
		int a[] = {1,2,3,4,5,6};
		shuffle(n, k, a);
	}
	
	public static void workflow(){
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T > 0){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[2*n];
			for(int i = 0; i < 2*n; i++){
				a[i] = sc.nextInt();
			}
			shuffle(n, k, a);
			T--;
		}
	}
	
	// 洗牌k次
	public static void shuffle(int n, int k, int a[]){
		for(int i = 0; i < k; i++){
			ArrayList<Integer> newArray = getTwoArray(n, a);
			a = listToArray(n, newArray);
		}
		array(a); // 控制台打印信息
	}
	
	// 将List转化为Array
	public static int[] listToArray(int n, ArrayList<Integer> newArray){
		int[] a = new int[2*n];
		for(int i = 0; i < newArray.size(); i++){
			a[i] = newArray.get(i);
		}
		return a;
	}
	
	// 得到前后两组牌，并进行一次洗牌
	public static ArrayList<Integer> getTwoArray(int n, int a[]){
		int[] head = new int[n];
		int[] tail = new int[n];
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			head[i] = a[i];
		}
		for(int i = n; i < 2*n; i++){
			tail[i-n] = a[i];
		}
//		array(a);
//		array(head);
//		array(tail);
		for(int i = n-1;i >= 0; i--){
			newArray.add(tail[i]);
			newArray.add(head[i]);
		}
//		array(newArray);
		newArray = reverse(newArray);
//		array(newArray);
		return newArray;
	}
	
	// 将一组牌倒序
	public static ArrayList<Integer> reverse(ArrayList<Integer> a){
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i = a.size()-1; i >= 0; i--){
			b.add(a.get(i));
		}
		return b;
	}
	
	// 读取牌组信息，空格分开，最后一个没有空格
	public static void array(int a[]){
		for(int i = 0; i < a.length - 1; i++){
			System.out.print(a[i] + " ");
		}
		System.out.print(a[a.length-1]);
		System.out.println("");
	}
	
	// 读取牌组信息，空格分开，最后一个没有空格
	public static void array(ArrayList<Integer> newArray){
		for(int i = 0; i < newArray.size() - 1; i++){
			System.out.print(newArray.get(i) + " ");
		}
		System.out.print(newArray.get(newArray.size() - 1));
		System.out.println("");
	}

}
