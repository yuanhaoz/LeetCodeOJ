package lintcode;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = fibonacci(10);
		System.out.println(a);
		a = fibonacci4(10);
		System.out.println(a);
	}
	
	/**
     * @param n: an integer
     * @return an integer f(n)
     */
    public static int fibonacci(int n) {
        // write your code here
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        } else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public static int fibonacci4(int n) {
        // write your code here
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }else{
            int a = 0;
            int b = 1;
            int result = 0;
            for(int i = 3; i <= n; i++){
            	result = a + b;
            	a = b;
            	b = result;
            }
            return result;
        }
       
    }
    
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public static int fibonacci2(int n) {
        // write your code here
    	int result=-1;
    	int temp1=0;
    	int temp2=1;
    	for(int index=0;index<=n;index++){
    		if(index==0){
    			result=temp1;
    		}else if(index==1){
    			result=temp2;
    		}else{
    			result=temp1+temp2;
    			if(result<0){
    				result=-2;
    				break;
    			}
    			temp1=temp2;
    			temp2=result;
    		}
    	}
    	return result;
    }
    
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public static int fibonacci3(int n) {
        // write your code here
    	int result=-1;
    	int temp1=0;
    	int temp2=1;
    	for(int index=0;index<=n;index++){
    		if(index==0){
    			result=temp1;
    		}else if(index==1){
    			result=temp2;
    		}else{
    			result=temp1+temp2;
    			if(result<0){
    				result=-2;
    				break;
    			}
    			temp1=temp2;
    			temp2=result;
    		}
    	}
    	return result;
    }

}
