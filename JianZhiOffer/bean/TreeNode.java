package bean;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的定义
 * Definition for binary tree
 *  
 * @author 郑元浩 
 * @date 2017年3月8日 下午10:17:36 
 */
public class TreeNode {
	public int val;
	public TreeNode left = null;
	public TreeNode right = null;
	
	public TreeNode(int x){
		val = x;
	}
	
	public TreeNode(){
		
	}

    public void traversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            System.out.print(node.val + " ");
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
        r1.traversal(r1);
    }

}
