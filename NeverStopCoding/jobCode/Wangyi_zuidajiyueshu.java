package jobCode;

import java.util.Scanner;

public class Wangyi_zuidajiyueshu {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		flow();
	}
	
	public static void flow(){
		sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			int sum = getSum(n);
			System.out.println(sum);
		}
	}
	
	// 计算从f(1)+f(2)+...+f(n)
	public static int getSum(int n){
		int sum = 0;
		for(int i = 1; i <= n; i++){
			sum = sum + getyueshu(i);
		}
		return sum;
	}
	
	// 得到一个数的所有奇数约数
	public static int getyueshu(int n){
		int big = 0;
		for(int i = n; i >= 1; i--){
			int yushu = n%i;
			if(yushu == 0){
				int jishu = i%2;
				if(jishu!=0){
					big = i;
					break;
				}
			}
		}
		return big;
	}

}
