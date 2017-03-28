package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**  
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888  轻松搞定面试中的二叉树题目 
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html  算法大全（3） 二叉树 
 *  
 * 一定要能熟练地写出所有问题的递归和非递归做法！ 
 * 
 * 1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代） 
 * 2. 求二叉树的深度: getDepthRec（递归），getDepth  
 * 3. 前序遍历，中序遍历，后序遍历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec 
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2) 
 * 4.分层遍历二叉树（按层次从上往下，从左往右）: levelTraversal, levelTraversalRec（递归解法！） 
 * 5. 将二叉查找树变为有序的双向链表: convertBST2DLLRec, convertBST2DLL 
 * 6. 求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel 
 * 7. 求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf 
 * 8. 判断两棵二叉树是否相同的树：isSameRec, isSame 
 * 9. 判断二叉树是不是平衡二叉树：isAVLRec 
 * 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：mirrorRec, mirrorCopyRec 
 * 10.1 判断两个树是否互相镜像：isMirrorRec 
 * 11. 求二叉树中两个节点的最低公共祖先节点：getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2 
 * 12. 求二叉树中节点的最大距离：getMaxDistanceRec 
 * 13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec 
 * 14. 判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec    
 *  
 * @author 郑元浩 
 * @date 2017年3月22日 上午10:03:34 
 */
public class BinaryTree {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		root.left = t2;
		root.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		System.out.println(getNodeNumRec(root));
		System.out.println(getNodeNum(root));

	}
	
	/** 
     * 求二叉树中的节点个数递归解法： O(n) 
     * （1）如果二叉树为空，节点个数为0  
     * （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 
     *            右子树节点个数 + 1 
     */  
    public static int getNodeNumRec(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }
    
    /** 
     *  求二叉树中的节点个数迭代解法O(n)：基本思想同LevelOrderTraversal， 
     *  即用一个Queue，在Java里面可以用LinkedList来模拟  
     */  
    public static int getNodeNum(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	// 用队列保存树节点
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	int count = 1; // 节点数目
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.remove(); // 每次从队列中删除节点，并返回该节点信息
    		if (node.left != null) { // 左子节点，将该节点添加到队列中
				queue.add(node.left);
				count++;
			}
    		if (node.right != null) {
				queue.add(node.right); // 右子节点，将该节点添加到队列中
				count++;
			}
    	}
    	return count;
    }
    
    /** 
     * 求二叉树的深度（高度） 递归解法： O(n) 
     * （1）如果二叉树为空，二叉树的深度为0  
     * （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1 
     */  
    public static int getDepthRec(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	if (root.left == null || root.right == null) {
			return 1;
		}
    	int leftDepth = getDepthRec(root.left);
    	int rightDepth = getDepthRec(root.right);
    	return Math.max(leftDepth, rightDepth) + 1;
    }

}
