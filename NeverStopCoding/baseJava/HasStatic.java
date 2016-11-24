package baseJava;

public class HasStatic {
	 private static int x=100;
	 public static void main(String args[]){
		 System.out.println("hs1.x="+x);
	     HasStatic.x++;//编译器会提示应该以静态方式访问静态字段HasStatic.x;
	     System.out.println("hs1.x="+x);
	          
	     System.out.println("hs2.x="+x);
	     HasStatic.x++;//编译器会提示应该以静态方式访问静态字段HasStatic.x;
	     System.out.println("hs2.x="+x);
	     System.out.println("x="+x);
	     HasStatic.x++;//编译器会提示应该以静态方式访问静态字段HasStatic.x;
	     System.out.println("x="+x);
	     HasStatic.x--;
	     System.out.println("x="+x);
	     }
}