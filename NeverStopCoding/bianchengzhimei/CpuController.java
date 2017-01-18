package bianchengzhimei;
/**  
 * 控制系统CPU曲线变化为50%或者正弦变化曲线   
 *  
 * @author 郑元浩 
 * @date 2017年1月17日 下午4:35:10 
 */
public class CpuController {

	public static void main(String[] args) throws InterruptedException {
//		firstMethod();
//		secondMethod();
//		thirdMethod();
//		test();
//		test2();
	}
	
	public static void firstMethod() throws InterruptedException {
		for (;;) {
			for (int i = 0; i <= 96000000; i++)
				;
			Thread.sleep(10);
		}
	}
	
	public static void secondMethod() throws InterruptedException {
		int busyTime = 10;
		int idleTime = 2 * busyTime;
		long startTime = 0;
		while (true) {
			startTime = System.currentTimeMillis();
			while (System.currentTimeMillis() - startTime <= busyTime)
				;
			Thread.sleep(idleTime);
		}
	}
	
	public static void thirdMethod() throws InterruptedException {
		final double SPLIT = 0.01;
		final int COUNT = 200;
		final double PI = 3.14159265;
		final int INTERVAL = 300;
		int[] busySpan = new int[COUNT];
		int[] idleSpan = new int[COUNT];
		int half = INTERVAL / 2;
		double radian = 0.0;
		for (int i = 0; i < COUNT; i++) {
			busySpan[i] = (half + (int)(Math.sin(PI * radian) * half));
			idleSpan[i] = INTERVAL - busySpan[i];
			radian += SPLIT;
		}
		long startTime = 0;
		int j = 0;
		while (true) {
			j = j % COUNT;
			startTime = System.currentTimeMillis();
			while ((System.currentTimeMillis() - startTime) <= busySpan[j])
				;
			Thread.sleep(idleSpan[j]);
			j++;
		}
	}
	
	public static void test(){
//		int busyTime = 10;  
//		int idleTime = busyTime;  
//		long startTime = 0; 
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
				}	
			}
		}).start();
		while (true) {  
		}  
	}
	
	public static void test2(){
		int busyTime = 10;  
//		int idleTime = busyTime;  
		long startTime = 0; 

		while(true) {
			startTime = System.currentTimeMillis();
			while(System.currentTimeMillis() - startTime <= busyTime) {

			}
			try {
				Thread.sleep(10);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


}
