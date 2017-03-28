package bean;
/**  
 * 类说明   
 *  
 * @author 郑元浩 
 * @date 2017年3月20日 下午3:15:12 
 */
public class ListNode {
	
	public int val;
	public ListNode next;
	
	public ListNode(){
		
	}
	
	public ListNode(int data) {
		this.val = data;
		next = null;
	}
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("null");
	}

}
