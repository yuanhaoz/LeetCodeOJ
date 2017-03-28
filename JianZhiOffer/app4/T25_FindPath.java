package app4;

import java.util.List;
import java.util.Stack;

import bean.TreeNode;

/**  
 * 面试题25：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 
 * 思路：
 * 1. 当用前序遍历的方式访问某一节点时，我们把该节点添加到路径上，并累加该结点的值。
 * 如果该结点为叶结点并且路径中结点值的和刚好等于输入的整数，则当前的路径符合要求，我们把它打印出来。
 * 如果当前节点不是叶节点，则继续访问它的子节点。当前节点访问结束后，递归函数将自动回到它的父节点。
 * 因此我们在函数退出之前要在路径上删除当前节点并减去当前节点的值，以确保返回父节点时路径刚好是从根节点到父节点的路径。
 * 我们不难看出保存路径的数据结构实际上是一个栈，因为路径要与递归调用状态一致，而递归的本质就是一个压栈和出栈的过程。
 *  
 * @author 郑元浩 
 * @date 2017年3月27日 上午9:27:42 
 */
public class T25_FindPath {

	public static void findPath(TreeNode root, int expectedSum){
		if (root == null) {
			return ;
		}
		int curSum = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		findPath(root, expectedSum, stack, curSum);
	}
	
	/**
	 * 
	 * @param node
	 * @param expectedSum
	 * @param stack
	 * @param curSum
	 */
	public static void findPath(TreeNode node, int expectedSum, Stack<TreeNode> stack, int curSum){
		curSum += node.val; // 当前路径上值的和
		stack.push(node); // 在路径栈中添加该节点
//		System.out.println(curSum);
		// 如果是叶子节点，并且路径上结点的和等于输入的值，打印这条路径
		boolean isLeaf = (node.left == null) && (node.right == null);
		if (curSum == expectedSum && isLeaf) {
			System.out.println("找到一条路径。。。");
			for (TreeNode treeNode : stack) {
				System.out.print(treeNode.val + " ");
			}
			System.out.println();
		}
		// 当前值不为希望值，且不是叶子节点时，遍历它的子节点
		if (node.left != null) {
			findPath(node.left, expectedSum, stack, curSum);
		}
		if (node.right != null) {
			findPath(node.right, expectedSum, stack, curSum);
		}
		// 弹出该叶子节点回到父节点继续遍历：1.当前值不为希望值，且是叶子节点；2.当前值是希望值，且是叶子节点
		// 在返回父节点之前，在路径上删除当前节点，并在curSum中减去当前节点的值
		curSum -= node.val;
		stack.pop();
	}
	
	public static void main(String[] args) {
		// 一条路径
	   //	    8
       //    /    \
       //   6     10
       //  / \   / \
       // 5   7 9  11
		
//		TreeNode root = new TreeNode(8);
//		TreeNode n1 = new TreeNode(6);
//		TreeNode n2 = new TreeNode(10);
//		TreeNode n3 = new TreeNode(5);
//		TreeNode n4 = new TreeNode(7);
//		TreeNode n5 = new TreeNode(9);
//		TreeNode n6 = new TreeNode(11);
//		root.left = n1;
//		root.right = n2;
//		n1.left = n3;
//		n1.right = n4;
//		n2.left = n5;
//		n2.right = n6;
//		findPath(root, 19);
		
		// 两条路径
	   //	    10
       //    /    \
       //   5     12
       //  / \  
       // 4   7 
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(12);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(7);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		findPath(root, 22);
	}
	
	/**
     * @param root        当前要处理的结点
     * @param curSum      当前记录的和（还未加上当前结点的值）
     * @param expectedSum 要求的路径和
     * @param result      根结点到当前处理结点的所经过的结点，（还未包括当前结点）
     */
    public static void findPath(TreeNode root, int curSum, int expectedSum, List<Integer> result) {

        // 如果结点不为空就进行处理
        if (root != null) {
            // 加上当前结点的值
            curSum += root.val;
            // 将当前结点入队
            result.add(root.val);
            // 如果当前结点的值小于期望的和
            if (curSum < expectedSum) {
                // 递归处理左子树
            	findPath(root.left, curSum, expectedSum, result);
                // 递归处理右子树
            	findPath(root.right, curSum, expectedSum, result);
            }
            // 如果当前和与期望的和相等
            else if (curSum == expectedSum) {
                // 当前结点是叶结点，则输出结果
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                }
            }
            // 移除当前结点
            result.remove(result.size() - 1);
        }
    }


}
