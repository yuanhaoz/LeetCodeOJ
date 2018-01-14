package niuke;

/**
 *
 * Created by yuanhao on 2017/9/13.
 */
public class Test2 {

    static int k;
    private static int vv;

    public static void main(String[] args) {
        int i = 0;
        while (i < (i++) + 1) {

        }
        System.out.println(i);

        Hello hello = null;
        hello.world(); // 类方法，与对象无关
        String a = "a";
        a+="a";
        ++k;
        System.out.println(k++>1?1:2);

Integer b = 0;
        System.out.println(vv==b);

    }

    public static void Test2() {



    }


}

class Hello {
    public static void world() {
        System.out.println("hello");
    }

}

class DemoThread extends Thread {
    public static void main(String[] args) {
        DemoThread threadOne = new DemoThread();
        DemoThread threadTwo = new DemoThread();
        threadOne.start();
        System.out.print("thread one.");
        threadTwo.start();
        System.out.print("thread two.");
    }

    public void run() {
        System.out.print("Thread.");
    }
}

