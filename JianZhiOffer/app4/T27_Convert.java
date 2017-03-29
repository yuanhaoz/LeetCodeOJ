package app4;

import bean.TreeNode;

/**  
 * 面试题27：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中结点指针的指向。
 * 
 * 思路：
 * 1. 在二叉搜索树中，每个节点都有两个指向子节点的指针，与双向链表结构相似，同时也是排序的数据结构。由于要求转换之后的链表是排好序的，我们可以
 * 中序遍历树中的每一个结点，这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每一个结点。当遍历到根节点的时候，我们把树看成三部分：值为10的结点、
 * 根节点值为6的左子树、根节点值为14的右子树。根据排序链表的定义，值为10的节点将和它的左子树的最大一个节点（即值为8的节点）链接起来，同时它还将和右子树最小的
 * 节点（即值为12的节点）链接起来。
 * 按照中序遍历的顺序，当我们遍历转换到根节点（值为10的结点）时，它的左子树已经转换成一个排序的链表了，并且处在链表总的最后一个节点是当前值最大的节点。
 * 我们把值为8的节点和根节点链接起来，此时链表中的最后一个节点就是10了。接着我们去遍历转换右子树，并把根节点和右子树中最小的节点链接起来。可以递归实现。
 * 
 * 总结考点：
 * 为了把这个复杂的问题分析清楚，我们可以把树分为三个部分：根节点、左子树和右子树，然后把左子树中最大的节点、根节点、右子树中最小的节点链接起来。
 * 至于如何把左子树和右子树内部的结点连接成链表，那和原来的问题的实质是一样的，因此可以递归解决。解决这个问题的关键在于把一个大的问题分解成几个小问题，并递归解决
 *  
 * @author 郑元浩 
 * @date 2017年3月28日 上午9:17:28 
 */
public class T27_Convert {
	

    /**
     * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * @param root 二叉树的根结点
     * @return 双向链表的头结点
     */
	public static TreeNode convert(TreeNode root) {
		// 用于保存处理过程中的双向链表的尾节点
		TreeNode[] lastNode = new TreeNode[1];
		convert(root, lastNode);
		
		// 找到双向链表的头结点
		TreeNode head = lastNode[0];
		while (head != null && head.left != null) {
			head = head.left;
		}
		return head;
	}
	
	/**
     * 链表表转换操作
     *
     * @param node     当前的根结点
     * @param lastNode 已经处理好的双向链表的尾结点，使用一个长度为1的数组，类似C++中的二级指针
     */
	public static void convert(TreeNode node, TreeNode[] lastNode) {
		// 节点不为空
		if (node != null) {
			// 如果有左子树就先处理左子树
			if (node.left != null) {
				convert(node.left, lastNode);
			}
			// 将当前节点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾节点
			node.left = lastNode[0];
			// 如果左子树转换成的双向链表不为空，设置尾节点的后继
			if (lastNode[0] != null) {
				lastNode[0].right = node;
			}
			// 记录当前节点为尾节点
			lastNode[0] = node;
			// 处理右子树
			if (node.right != null) {
				convert(node.right, lastNode);
			}
		} else {
			return ;
		}
	}

    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    private static void printList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.right;
        }

        System.out.println("null");
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + "->");
            printTree(root.right);
        }
    }


    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        TreeNode node10 = new TreeNode(10);

        TreeNode node6 = new TreeNode(6);

        TreeNode node14 = new TreeNode(14);

        TreeNode node4 = new TreeNode(4);

        TreeNode node8 = new TreeNode(8);

        TreeNode node12 = new TreeNode(12);

        TreeNode node16 = new TreeNode(16);

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        TreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();

    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);

        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);

        TreeNode node5 = new TreeNode(5);

        node5.left = node4;
        node4.left = node3;
        node3.left = node2;
        node2.left = node1;

        System.out.print("Before convert: ");
        printTree(node5);
        System.out.println("null");
        TreeNode head = convert(node5);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
    	TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);

        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);

        TreeNode node5 = new TreeNode(5);

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        TreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 只有一个结点
    private static void test04() {
        TreeNode node1 = new TreeNode(1);

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        TreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 没有结点
    private static void test05() {
        System.out.print("Before convert: ");
        printTree(null);
        System.out.println("null");
        TreeNode head = convert(null);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
	
}
