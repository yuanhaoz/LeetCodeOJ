package app4;

import java.util.LinkedList;
import java.util.Queue;

import bean.TreeNode;

/**  
 * 面试题23：从上往下打印二叉树
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 * 
 * 思路：
 * 1. 用队列实现，每一次打印一个结点的时候，如果该结点有子结点，则把该结点的子结点放到一个队列的末尾。接下来到队列的头部取出最早进入队列的结点，
 * 重复前面的打印操作，直至队列中所有的结点都被打印出来为止。
 * 
 * 扩展：
 * 1. 如何广度优先遍历一个有向图？这同样也可以基于队列实现。树是图的一种特殊退化形式，从上到下按层遍历二叉树，从本质上来说就是广度优先遍历二叉树。
 * 2. 不管是广度优先遍历一个有向图还是一棵树，都要用到队列。第一步我们把起始结点（对树而言是根节点）放入队列中。我们接下来每一次从队列的头部取出一个结点，
 * 遍历这个结点之后把从它能到达的结点（对树而言是子节点）都依次放入队列。我们重复这个遍历过程，直到队列中的结点全部被遍历为止。
 *  
 * @author 郑元浩 
 * @date 2017年3月26日 下午8:19:19 
 */
public class T23_PrintFromTopToBottom {

	public static void main(String[] args) {
	   //	    8
       //    /    \
       //   6     10
       //  / \   / \
       // 5   7 9  11
		
		TreeNode root = new TreeNode(8);
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(11);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		printFromTopToBottom(root);
	}
	
	/**
	 *  从上往下打印出二叉树的每个结点，向一层的结点按照从左往右的顺序打印。
     * 例如下的二叉树，
     *       8
     *    /    \
     *   6     10
     *  /  \   / \
     * 5   7  9  11
     * 则依次打印出8、6、10、5、3 、9、11.
     * 
	 * @param root 树的结点
	 */
	public static void printFromTopToBottom(TreeNode root) {
		if (root == null) {
			return ;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 队列
		queue.add(root); // 添加根节点
		TreeNode node; // 当前处理的结点
		while (!queue.isEmpty()) { // 队列不为空
			node = queue.remove(); // 删除队首元素
			System.out.println(node.val);
			if (node.left != null) { // 当前处理结点的左子节点不为空
				queue.add(node.left);
			}
			if (node.right != null) { // 当前处理结点的右子节点不为空
				queue.add(node.right);
			}
			
		}
	}

}
