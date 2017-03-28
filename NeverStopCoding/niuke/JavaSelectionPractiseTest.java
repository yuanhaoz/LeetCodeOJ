package niuke;


/**  
 * Java选择题训练   
 *  
 * @author 郑元浩 
 * @date 2017年2月28日 下午9:02:04 
 */
public class JavaSelectionPractiseTest {

	public static void main(String[] args) throws InterruptedException {
//		test1();
//		test2();
//		test3();
//		System.out.println("return value of test() : " + test4()); 
		System.out.println("return value of getValue(): " + getValue()); 
		System.out.println("return value of getValue2(): " + getValue2()); 
		System.out.println("return value of getValue3(): " + getValue3()); 
		System.out.println("return value of getValue4(): " + getValue4()); 
	}
	
	/**
	 * 程序输出：21
	 * @throws InterruptedException
	 */
	public static void test1() throws InterruptedException{
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
					throw new RuntimeException(e);
				}
				System.out.print("2");
			}
		});
		t.start();
		
		// thread.join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
		// 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
		t.join(); // 使调用线程t在此之前执行完毕。
		System.out.print("1");
	}
	
	public static int test2() { 
		int i = 1; 
		try { 
			System.out.println("try block"); 
			System.exit(0); 
			return i; 
		}finally { 
			System.out.println("finally block"); 
		} 
	} 
	
	/**
	 * 清单 3 的执行结果为：
 try block 
 finally block
清单 3 说明 finally 语句块在 try 语句块中的 return 语句之前执行。
	 */
	public static void test3(){
		try {  
			System.out.println("try block");  

			return ;  
		} finally {  
			System.out.println("finally block");  
		} 
	}
	
	/**
	 * 清单 4 的执行结果为：
 try block 
 exception block 
 finally block 
 reture value of test() : 2
清单 4 说明了 finally 语句块在 catch 语句块中的 return 语句之前执行。
	 * @return
	 */
	public static int test4(){
		try {  
			System.out.println("try block");  
			return 1;  
		}catch (Exception e){ 
			System.out.println("exception block"); 
			return 2; 
		}finally {  
			System.out.println("finally block");  
		} 
	}
	
	/**
	 * 从上面的清单 3 和清单 4，我们可以看出，其实 finally 语句块是在 try 或者 catch 中的 return 语句之前执行的。
	 * 更加一般的说法是，finally 语句块应该是在控制转移语句之前执行，控制转移语句除了 return 外，
	 * 还有 break 和 continue。另外，throw 语句也属于控制转移语句。虽然 return、throw、break 和 continue 都是控制转移语句，
	 * 但是它们之间是有区别的。其中 return 和 throw 把程序控制权转交给它们的调用者（invoker），
	 * 而 break 和 continue 的控制权是在当前方法内转移。
	 */
	
	/**
	 * 返回1
	 * @return
	 */
	@SuppressWarnings("finally")
	public static int getValue() { 
		try { 
			return 0; 
		} finally { 
			return 1; 
		} 
	} 
	
	/**
	 * 返回1
	 * @return
	 */
	public static int getValue2() { 
		int i = 1; 
		try { 
			return i; 
		} finally { 
			i++; 
		} 
	} 

	/**
	 * 返回5
	 * @return
	 */
	@SuppressWarnings("finally")
	public static int getValue3() {
		int i = 1;
		try {
			i = 4;
		} finally {
			i++;
			return i;
		}
	}
	
	/**
	 * 返回5
	 * @return
	 */
	public static int getValue4() { 
		int i = 1; 
		try { 
			i = 4; 
		} finally { 
			i++; 
		} 
		return i; 
	} 
	 
}
