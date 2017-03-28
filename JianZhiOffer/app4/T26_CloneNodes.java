package app4;

import bean.ComplexListNode;

/**  
 * 面试题26：复杂链表的复制
 * 题目：请实现函数复制一个复杂链表。在复杂链表中，每个节点除了有一个指针指向下一个结点外，
 * 还有一个指针指向链表中的任意结点或者NULL。   
 * 
 * 思路：
 * 1. 两步：第一步复制原始链表中的每一个节点，并连接起来；第二步是复制每个节点的m_psibling指针。时间复杂度是O(n^2)。
 * 2. 两步：第一步复制原始链表中的每一个节点，并把对应信息存到哈希表中；第二步是复制每个节点的m_psibling指针。（空间换时间，时间复杂度为O(n)，需要空间为O(n)）
 * 3. 三步：不使用辅助空间实现O(n)的效率。第一步同上复制每个节点N为N'，并且把N'链接到N的后面。
 * 第二步设置复制出来的节点的m_pSibling。假设原始链表上的N的m_pSibling指向节点S，那么对应复制出来的N'是N的m_pNext指向的节点，
 * 同样S'也是S得m_pNext指向的节点。
 * 第三步把这个长链表拆分成两个链表：把奇数位的节点用m_pNext链接起来就是原始链表，把偶数位置的结点用m_pNext链接起来就是复制出来的链表。
 * 合起来就可以完成复杂链表的复制
 *  
 * @author 郑元浩 
 * @date 2017年3月27日 上午10:48:22 
 */
public class T26_CloneNodes {
	
	/**
	 * 复制每个节点
	 * 对链表的每个节点，复制一个相同的节点到该节点的后面
	 * @param root
	 */
	public static void cloneNodes(ComplexListNode root){
		if (root == null) {
			return ;
		}
		ComplexListNode tmp = root;
		while (tmp != null) {
			ComplexListNode copyTmp = tmp;
			copyTmp.next = tmp.next;
			tmp.next = copyTmp;
			tmp = copyTmp.next;
		}
	}
	
	/**
	 * 复制每个节点的sibling
	 * 对原始链表中的每个节点，复制该节点的sibling节点的下一个节点为该节点下一个结点的sibling节点
	 * @param root
	 */
	public static void cloneSibling(ComplexListNode root) {
		if (root == null) {
			return ;
		}
		ComplexListNode tmp = root;
		while (tmp != null) {
			ComplexListNode copyTmp = tmp.next;
			if (tmp.sibling != null) {
				ComplexListNode tmpSibling = tmp.sibling;
				copyTmp.sibling = tmpSibling.next;
			}
			tmp = copyTmp.next;
		}
	}
	
	/**
	 * 将两个链表进行分离
	 * @param root
	 * @return
	 */
	public static ComplexListNode seperateList(ComplexListNode root) {
		ComplexListNode tmp = root;
		ComplexListNode newRoot = null;
		ComplexListNode newTmp = null;
		if (root != null) {
			newRoot = tmp.next;
			newTmp = tmp.next;
			tmp.next = newRoot.next;
			tmp = tmp.next;
		}
		
		while (tmp != null) {
			newTmp.next = tmp.next;
			newTmp = tmp.next;
			tmp.next = newTmp.next;
			tmp = tmp.next;
		}
		return newRoot;
	}
	
	/**
	 * 三步实现复杂链表的复制
	 * @param root
	 * @return
	 */
	public static ComplexListNode clone(ComplexListNode root){
		cloneNodes(root);
		cloneSibling(root);
		return seperateList(root);
	}

	
	/**
     * 输出链表信息
     *
     * @param head 链表头结点
     */
    public static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    /**
     * 判断两个链表是否是同一个链表，不是值相同
     *
     * @param h1 链表头1
     * @param h2 链表头2
     * @return true：两个链表是同一个链表，false：不是
     */
    public static boolean isSame(ComplexListNode h1, ComplexListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }

        return h1 == null && h2 == null;
    }
    
    public static void main(String[] args) {
    	//          -----------------
    	//         \|/              |
    	//  1-------2-------3-------4-------5
    	//  |       |      /|\             /|\
    	//  --------+--------               |
    	//          -------------------------
    	ComplexListNode head = new ComplexListNode(1);
    	head.next = new ComplexListNode(2);
    	head.next.next = new ComplexListNode(3);
    	head.next.next.next = new ComplexListNode(4);
    	head.next.next.next.next = new ComplexListNode(5);

    	head.sibling = head.next.next;
    	head.next.sibling = head.next.next.next.next.next;
    	head.next.next.next.sibling = head.next;

    	ComplexListNode tmp = head;
    	printList(head);
    	ComplexListNode newHead = clone(head);
    	printList(head);
    	System.out.println(isSame(head, tmp));
    	printList(newHead);
    	System.out.println(isSame(head, newHead));


    	// 有指向自身的情况
    	//          -----------------
    	//         \|/              |
    	//  1-------2-------3-------4-------5
    	//         |       | /|\           /|\
    	//         |       | --             |
    	//         |------------------------|
    	ComplexListNode head2 = new ComplexListNode(1);
    	head2.next = new ComplexListNode(2);
    	head2.next.next = new ComplexListNode(3);
    	head2.next.next.next = new ComplexListNode(4);
    	head2.next.next.next.next = new ComplexListNode(5);

    	head2.next.sibling = head2.next.next.next.next;
    	head2.next.next.next.sibling = head2.next.sibling;
    	head2.next.next.sibling = head2.next.next;

    	System.out.println("\n");
    	tmp = head2;
    	printList(head2);
    	ComplexListNode newHead2 = clone(head2);
    	printList(head2);
    	System.out.println(isSame(head2, tmp));
    	printList(newHead2);
    	System.out.println(isSame(head2, newHead2));


    	ComplexListNode head3 = new ComplexListNode(1);

    	System.out.println("\n");
    	tmp = head3;
    	printList(head3);
    	ComplexListNode newHead3 = clone(head3);
    	printList(head3);
    	System.out.println(isSame(head3, tmp));
    	printList(newHead3);
    	System.out.println(isSame(head3, newHead3));

    	System.out.println("\n");
    	ComplexListNode head4 = clone(null);
    	printList(head4);
	}

}
