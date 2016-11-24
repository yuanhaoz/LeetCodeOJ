package niuke;

/**
 *[编程题] 构造队列
小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
while(!Q.empty())              //队列不空，执行循环

{

    int x=Q.front();            //取出当前队头的值x

    Q.pop();                 //弹出当前队头

    Q.push(x);               //把x放入队尾

    x = Q.front();              //取出这时候队头的值

    printf("%d\n",x);          //输出x

    Q.pop();                 //弹出这时候的队头

}


做取出队头的值操作的时候，并不弹出当前队头。
小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正] 
输入描述:
第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。


输出描述:
对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.

输入例子:
4
1
2
3
10

输出例子:
1
2 1
2 1 3
8 1 6 2 10 3 7 4 9 5

思路：
初始化一个队列为空，从n,n-1,n-2,...,1 ，取一个元素插入对头，再取出队尾元素，放到对头。
关键是逆向过程即可恢复原队列，题目是取一个对头放在队尾，然后再取出后面的对头。因此逆过程是取一个元素放在对头，然后将队尾元素放回对头。 
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Wangyi_Duilie {

	private static Scanner sc;

	public static void main(String[] args) {
//		arrayDequeTest();
//		source(14);
		workflow();
	}
	
	public static void workflow(){
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T > 0){
			int n = sc.nextInt();
			source(n);
			T--;
		}
	}
	
	// 逆向寻找所有元素
	public static void source(int n){
		ArrayList<Integer> q = queue(n);
//		console(q);
		ArrayDeque<Integer> qsrc = new ArrayDeque<Integer>();
		for(int i = 0; i < q.size(); i++){
			int k = q.get(i);
			arrayDeque(qsrc, k);
		}
		console(qsrc);
	}
	
	// 队列使用
	public static void arrayDeque(ArrayDeque<Integer> stack, int k){
		stack.push(k);
//		System.out.println(stack); 
		int f = stack.getLast();
		stack.removeLast();
		stack.push(f);
//		System.out.println(stack);
//		console(stack);
	}
	
	// 由输入n得到结果队列的反序，顺序是从n到1
	public static ArrayList<Integer> queue(int n){
		ArrayList<Integer> q = new ArrayList<Integer>();
		for(int i = n; i > 0; i--){
			q.add(i);
		}
		return q;
 	}
	
	// 输出队列元素，数字之间用一个空格隔开，不要在行末输出多余的空格。
	public static void console(ArrayList<Integer> q){
		for(int i = 0; i < q.size() - 1; i++){
			System.out.print(q.get(i) + " ");
		}
		System.out.print(q.get(q.size() - 1));
		System.out.println("");
	}
	
	// 输出队列元素，数字之间用一个空格隔开，不要在行末输出多余的空格。
	public static void console(ArrayDeque<Integer> stack){
		ArrayList<Integer> q = new ArrayList<Integer>();
		for (Integer number : stack) {
			q.add(number);
		}
		console(q);
	}
	
	// 队列使用
	public static void arrayDequeTest(){
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		//依次将三个元素push入"栈"
		stack.push(4);
		stack.push(3);
		stack.push(5);
		System.out.println(stack); // 原来的三个元素：5，3，4
		stack.push(2); // 将元素插入开始位置，5之前
		System.out.println(stack); 
		int f = stack.getLast(); // 取出结束位置元素，4，并将其从队列中删除，然后将其push到开始位置
		stack.removeLast();
		stack.push(f);
		System.out.println(stack);

		for (Integer number : stack) {
			System.out.println("Number = " + number);
		}

		System.out.println(stack.getFirst());
		System.out.println(stack.getLast());
		stack.offerFirst(20);
		System.out.println(stack);
		stack.offerLast(40);
		System.out.println(stack);
		//访问第一个元素，但并不将其pop出"栈"
		System.out.println(stack.peek());
		System.out.println(stack.peekFirst());
		System.out.println(stack.peekLast());
		System.out.println(stack);
		//pop出第一个元素
		System.out.println(stack.pop());
		System.out.println(stack.pollFirst());
		System.out.println(stack.pollLast());
		System.out.println(stack);
	}

}
