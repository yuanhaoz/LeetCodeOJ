package app1_2;
/**  
 * 递归和循环：通常基于递归实现的代码比基于循环实现的代码要简洁很多，更加容易实现。如果面试官没有特殊要求，应聘者可以优先采用递归的方法编程。
 * 递归虽然有简洁的优点，但它同时也有显著的缺点。递归由于是函数调用自身，而函数调用时有时间和空间的消耗的：每一次函数调用，都需要在内存栈中分配空间
 * 以保存参数、返回地址及临时变量，而且往栈里压入数据和弹出数据都需要时间。这就不难理解上述的例子中递归实现的效率不如循环。
 * 递归有可能引起更严重的问题：调用栈溢出。每个进程的栈容量是有限的，当递归调用的层级太多时，就会超出栈的容量，从而导致调用栈溢出。 
 * 
 * 面试题9：斐波那契数列
 * 写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。斐波那契数列的定义如下：
 * f(n)=0, n=0
 * f(n)=1, n=1
 * f(n)=f(n-1)+f(n-2), n>1
 * 
 * 用不同的方法求解斐波那契数列的时间效率不大相同。
 * 第一种基于递归的解法虽然直观但时间效率很低，在实际软件开发中不会用这种方法，也不可能得到面试官的青睐。
 * 第二种方法把递归的算法用循环实现，极大地提高了时间效率。
 * 第三种方法把斐波那契数列转换成求矩阵的乘方，是一种很有创意的算法。但是不太实用。
 * 
 * 有不少面试题可以看成是斐波那契数列的应用，比如：
 * 题目2：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 本题扩展：
 * 在青蛙跳台阶的问题中，如果把条件改成：一只青蛙一次可以跳上1级台阶，也可以跳上2级。。。它可以跳上n级，此时，该青蛙跳上一个n级台阶总共有多少种跳法？
 * 我们用数学归纳法可以证明是f(n)=2^(n-1)。
 * 
 * 相关题目：
 * 我们可以用2*1（图2.13的左边）的小矩阵横着或者竖着去覆盖更大的矩阵。请问用8个2*1的小矩阵无重复的覆盖一个2*8的大矩阵，总共有多少种方法？
 * 解法：我们先把2*8的覆盖方法记为f(8)。用第一个1*2小矩阵去覆盖大矩阵的最左边时有两个选择，竖着放或者横着放。
 * 当竖着放的时候，右边还剩下2*7的区域，这种情况下的覆盖方法记为f(7)。
 * 当横着放在左上角的时候，左下角必须和横着放一个1*2的小矩阵，而在右边还剩下2*6的区域，这种情形下的覆盖方法记为f(6)，
 * 因此f(8)=f(7)+f(6)。此时我们可以看出，这仍然是斐波那契数列。
 *  
 * @author 郑元浩 
 * @date 2017年3月13日 上午10:45:47 
 */
public class T9_Fibonacci {

	public static void main(String[] args) {
		// 测试用例
		
		// 功能测试（如输入3、5、10等）
		System.out.println(Fibonacci(3));
		System.out.println(Fibonacci(5));
		System.out.println(Fibonacci(10));
		// 边界值测试（如输入0、1、2等）
		System.out.println(Fibonacci(0));
		System.out.println(Fibonacci(1));
		System.out.println(Fibonacci(2));
		// 性能测试（如输入40、50、100等）方法1
		System.out.println(FibonacciBetter(40));
		System.out.println(FibonacciBetter(50));
		System.out.println(FibonacciBetter(100));
		System.out.println(FibonacciBetter2(100));
		// 性能测试（如输入40、50、100等）方法2
		System.out.println(Fibonacci(40));
		System.out.println(Fibonacci(50)); // 当数据较大时，递归方法效率很低
		System.out.println(Fibonacci(100));

	}
	
	/**
	 * 递归法：存在很严重的效率问题并分析原因。
	 * 我们以求解f(10)为例来分析递归的求解过程。想求得f(10)，需要先求得f(9)和f(8)。同样，想求得f(9)，需要先求得f(8)和f(7)..可以用树形结构来表示这种依赖关系
	 * 我们发现有很多节点是重复的，而且重复的节点数会随着n的增大而急剧增加，这意味着计算量会随着n的增大而急剧增大。事实上，用递归方法计算的时间复杂度是以n的指数的
	 * 方式递增的。
	 * 
	 * @param n
	 * @return
	 */
	public static int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}else if (n == 1) {
			return 1;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
	
	/**
	 * 面试官期待的实用解法：
	 * 其实改进的方法并不复杂。上述递归代码之所以慢是因为重复的计算太多，我们只要想办法避免重复计算就行了。
	 * 比如我们可以把已经得到的数列中间项保存起来，如果下次需要计算的时候我们先查找一下，如果前面已经计算过就不用再重复计算了。
	 * 更简单的方法是：
	 * 从下往上计算，首先根据f(0)和f(1)算出f(2)，再根据f(1)和f(2)算出f(3)。。。依次类推就可以算出第n项了。很容易理解，这种思路的时间复杂度是O(n)。
	 * 
	 * @param n
	 * @return
	 */
	public static int FibonacciBetter(int n){
		int[] result = {0, 1};
		if (n == 0|| n == 1) {
			return result[n];
		}
		int one = 0; // 记录前两个（第n-2个）的Fibonacci数的值
		int two = 1; // 记录前两个（第n-1个）的Fibonacci数的值
		int sum = 0; // 记录前两个（第n个）的Fibonacci数的值
		
		 // 求解第n个的Fibonacci数的值
		for (int i = 2; i <= n; i++) {
			sum = one + two; // 求解第i个的Fibonacci数的值
			one = two; // 前一个数等于后一个数
			two = sum; // 后一个数等于相加的和
		}
		return sum; // 返回所求结果
	}

	public static int FibonacciBetter2(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

}
