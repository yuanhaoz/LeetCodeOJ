package easy;
/**  
 * 类说明   
 *  
 * @author 郑元浩 
 * @date 2017年3月21日 下午5:11:55 
 */
public class ReverseLinkedList206 {
	public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode current = head;
        ListNode reverseHead = null;
        ListNode next = null;
        
        while(current != null) {
            next = current.next;
            
            current.next = reverseHead;
            reverseHead = current;
            
            current = next;
            
        }
        
        return reverseHead;
        
    }
}
