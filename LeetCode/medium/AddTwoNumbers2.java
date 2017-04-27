package medium;

import utils.Log;

/**
 * 2016年12月21号，今天一天就被这一道题折磨死了，走了一条弯路
 * 1. 一开始是考虑所有的情况，对两个链表中的每个元素进行相加。但是题目理解错了，一开始看到例子以为
 * 两个链表的元素一定会一样，但是测试的时候发现各种bug，后面才知道例子只是举了一个最简单的例子。
 * 2.后面觉得太过困难，所以尝试将链表元素转化为整数，然后整数相加，结果转为链表。后面发现整数的值大小是有范围的
 * 一直解决不了，然后又去折腾方法1，把所有逻辑情况考虑完全了，总算解决了。
 * 总结：还是应该持之以恒呀！！！
 */

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumbers2 {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	public static void test2(){
		ListNode l1 = new ListNode(9);
		
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(9);
		ListNode l4 = new ListNode(9);
		ListNode l5 = new ListNode(9);
		ListNode l6 = new ListNode(9);
		ListNode l7 = new ListNode(9);
		ListNode l8 = new ListNode(9);
		ListNode l9 = new ListNode(9);
		ListNode l10 = new ListNode(9);
		ListNode l11 = new ListNode(9);
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		l9.next = l10;
		l10.next = l11;
		
		ListNode l12 = addTwoNumbers(l1, l2);
		Log.log("------------------");
		log(l12);
		
	}
	
	public static void test1(){
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.next = l5;
		l5.next = l6;
		
		ListNode l7 = addTwoNumbers(l1, l4);
		Log.log("------------------");
		log(l7);
		
		ListNode l10 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l12 = addTwoNumbers(l10, l11);
		Log.log("------------------");
		log(l12);
		
	}
	
	/**
	 * 解决算法：考虑各种情况，考虑的全才行
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	/**
    	 * 两个链表最少有一个元素，因此返回结果的第一个元素可以为两个链表第一元素的和
    	 */
    	Boolean flag = false;
    	int init = l1.val + l2.val;
    	if (init >= 10) {
    		init = init - 10;
    		flag = true;
		}
    	ListNode loop = new ListNode(init);
    	ListNode result = loop; // 用于返回结果，指向结果链表的第一个元素指针
    	
    	/**
    	 * 循环两个链表元素相同部分的元素，直到遇到一个链表遍历完
    	 */
    	while(l1.next != null && l2.next != null){
    		l1 = l1.next;
    		l2 = l2.next;
    		int a = l1.val + l2.val;
    		/**
    		 * flag判断是否需要加1
    		 */
    		if (flag) {
        		a = a + 1;
			}
    		if (a >= 10) {
				a = a - 10;
				flag = true;
			} else {
				flag = false;
			}
    		ListNode l3 = new ListNode(a);
    		loop.next = l3;
    		loop = loop.next;
    	}
    	
    	/**
    	 * 如果两个链表经过遍历以后，都为空
    	 */
    	if (l1.next == null && l2.next == null) {
			if (flag == true) {
				loop.next = new ListNode(1);
			}
		}
    	
    	/**
    	 * 如果两个链表经过遍历以后，有一个链表不为空，另外一个链表为空
    	 * 那么有进位的话保留加1，无进位的话直接保留多余的元素即可
    	 */
    	if (l1.next == null && l2.next != null) {
			if(flag){
				/**
				 * 判断需要加1
				 */
				while(l2.next != null && l2.next.val == 9){ 
					// 不为空，中间一直为9，一直填充0
					loop.next = new ListNode(0);
					loop = loop.next;
					l2 = l2.next;
				}
				if (l2.next == null) {//为空，高位为1
					loop.next = new ListNode(1);
				} else {// 不为空，不等于9，高位加1。接下来的数据直接补充原来的数据
					loop.next = new ListNode(l2.next.val + 1);
					loop = loop.next;
					l2 = l2.next;
					while(l2.next != null){
						loop.next = l2.next;
						loop = loop.next;
						l2 = l2.next;
					}
				}
			} else {
				while(l2.next != null){
					loop.next = l2.next;
					loop = loop.next;
					l2 = l2.next;
				}
			}
		}
    	
    	/**
    	 * 
    	 */
    	if (l1.next != null && l2.next == null) {
			if(flag){
				/**
				 * 判断需要加1
				 */
				while(l1.next != null && l1.next.val == 9){ // 不为空，中间一直为9，一直填充0
					loop.next = new ListNode(0);
					loop = loop.next;
					l1 = l1.next;
				}
				if (l1.next == null) {//为空，高位为1
					loop.next = new ListNode(1);
				} else {// 不为空，不等于9，高位加1。接下来的数据直接补充原来的数据
					loop.next = new ListNode(l1.next.val + 1);
					loop = loop.next;
					l1 = l1.next;
					while(l1.next != null){
						loop.next = l1.next;
						loop = loop.next;
						l1 = l1.next;
					}
				}
			} else {
				while(l1.next != null){
					loop.next = l1.next;
					loop = loop.next;
					l1 = l1.next;
				}
			}
		}
    	
    	return result;
    	
    }
    
    public static void log(ListNode l1){
    	while (l1!=null) {
			Log.log(l1.val);
			l1=l1.next;
		}
    }
    
    /**
     * 将链表对应的元素集合转化为数字
     * 再进行相加
     * 再将结果转化为链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	int a = getNumber(l1);
    	int b = getNumber(l2);
    	int c = addNumberByWei(a, b);
//    	int c = a + b;
    	Log.log(c);
    	ListNode result = getListNode(c);
    	return result;
    }
    
    public static int addNumberByWei(int num1, int num2){
    	int temp=0;  
        int carry=0;  
        while(num2!=0){   
            temp=num1^num2;  
            carry=(num1&num2)<<1;  
            num1=temp;  
            num2=carry;  
        }  
        return num1;  
    }
    
    /**
     * 将链表元素转化为数字
     * @param l1
     */
    public static int getNumber(ListNode l1){
    	int a = 0;
    	int number = l1.val;
    	while(l1.next != null){
    		a++;
    		int n = l1.next.val*((int)Math.pow(10, a));
    		number = number + n;
    		l1 = l1.next;
    	}
    	return number;
    }
    
    /**
     * 将一个数转化为链表元素
     * @param number
     * @return
     */
    public static ListNode getListNode(int number){
    	ListNode result = new ListNode(number%10);
    	ListNode reListNode = result;
    	int x = sizeOfInt(number) - 1;
    	number = number/10;
    	while(x--!=0){
    		int b = number%10; // 余数即是我们需要的
    		ListNode l1 = new ListNode(b);
    		result.next = l1;
    		result = result.next;
    		number = number/10;
    	}
    	return reListNode;
    }
    
    public static int sizeOfInt(int x) {
    	String a = x + "";
    	return a.length();
    }   

}
