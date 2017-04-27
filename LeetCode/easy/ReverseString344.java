package easy;

import java.util.*;

public class ReverseString344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "canal Panama!";
//		ReverseString344 rs = new ReverseString344();
		
//		rs.reverseString(s);
//		rs.reverseString2(s);
//		test();
//		reverseIt(s);
//		reverse(s);
		stack(s);
	}
	
	public String reverseString(String s){
		String str = new String();
		for(int i = 0; i < s.length(); i++){
			str = s.charAt(i) + str;
		}
		System.out.println(str);
		return str;
	}
	
	public String reverseString2(String s){
//		return new StringBuffer(s).reverse().toString();
		return new StringBuilder(s).reverse().toString();
	}
	
	public static void test(){
		String str = "I Love Java";
		String[] sArr = str.split(" ");//I love java
		List<String> list = new ArrayList<String>();
		list = Arrays.asList(sArr);
//		for(int i=0;i<sArr.length;i++){
//			list.add(sArr[i]);
//		}
		Collections.reverse(list);
		for(String word:list){
			System.out.print(word+" ");
		}
	}
	
	public static String reverseIt(String source) {
	    int i, len = source.length();
	    StringBuilder dest = new StringBuilder(len);

	    for (i = (len - 1); i >= 0; i--){
	        dest.append(source.charAt(i));
	    }

	    return dest.toString();
	}
	
	// 遍历一半的数组即可，效率比其他的高
	public static String reverse(String s){
	    char[] in = s.toCharArray();
	    int begin=0;
	    int end=in.length-1;
	    char temp;
	    while(end > begin){
	        temp = in[begin];
	        in[begin] = in[end];
	        in[end] = temp;
	        end--;
	        begin++;
	    }
	    return new String(in);
	}
	
	public static String stack(String s){
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < s.length(); i++){
			stack.push(s.charAt(i));
		}
		while(!stack.empty()){
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}
