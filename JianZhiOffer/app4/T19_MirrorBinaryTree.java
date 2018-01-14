package app4;

import bean.TreeNode;

/**  
 * 面试题19：二叉树的镜像
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 
 * 思路：
 * 1. 递归处理二叉树的每个节点，交换该节点的左右子节点，然后遍历二叉树的每个节点都执行这个操作。
 * 
 * 注意：
 * 1. 树的根节点为空，空树的情况
 * 2. 普通的二叉树，二叉树的所有节点都没有左子树或者右子树，只有一个节点的二叉树
 * 
 * @author 郑元浩 
 * @date 2017年3月24日 下午4:35:42 
 */
public class T19_MirrorBinaryTree {
	
	/**
	 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
	 * @param root 二叉树的根节点
	 */
	public static void MirrorRecursively(TreeNode root) {
		// 树根节点为空或者树的左右节点为空
		if (root == null || (root.left == null && root.right == null)) {
			return ;
		}
		// 交换左右根节点的值
		TreeNode tmpNode = root.left;
		root.left = root.right;
		root.right = tmpNode;
		// 遍历左右两个子树
		if (root.left != null) { // 判断左子节点是否为空，若为空则不需要镜像
			MirrorRecursively(root.left);
		} else if (root.right != null) { // 判断右子节点是否为空，若为空则不需要镜像
			MirrorRecursively(root.right);
		}
		
	}

	/**
	 * 递归的解法
	 * @param root
	 */
	public static void MirrorRecursively2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return ;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if (root.left != null) {
			MirrorRecursively2(root.left);
		} else if (root.right != null) {
			MirrorRecursively2(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		TreeNode r7 = new TreeNode(7);
		TreeNode r8 = new TreeNode(8);
		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r4.left = r7;
		r3.left = r5;
		r3.right = r6;
		r6.left = r8;
		MirrorRecursively2(r1);
		r1.traversal(r1);
	}

}
