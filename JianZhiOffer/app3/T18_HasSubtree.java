package app3;

import bean.TreeNode;

/**  
 * 面试题18：树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 * 
 * 思路：
 * 1. 分成两步：第一步在树A中找到和B的根节点的值一样的节点R，第二步再判断树A中以R为根节点的子树是不是包含和树B一样的结构。
 *  
 * @author 郑元浩 
 * @date 2017年3月24日 下午3:34:17 
 */
public class T18_HasSubtree {
	
	/**
	 * 输入两棵二叉树A和B，判断B是不是A的子结构。
     * 该方法是在A树中找到一个与B树的根节点相等的元素的结点，
     * 从这个相等的结点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
     * 否则直到所有的结点都找完为止。
	 * @param root1 树A的根结点
	 * @param root2 树B的根结点
	 * @return true：树B是树A的子结构，false：树B是不树A的子结构
	 */
	public static boolean hasSubTree(TreeNode root1, TreeNode root2){
		boolean result = false; // 用于判断是否包含子结构
		if (root1 != null && root2 != null) { // 判断根节点不为空
			if (root1.val == root2.val) { // 首先得到相同的根节点，然后再在相同的根节点的子树结构中判断是不是存在重复的元素
				result = doesTree1HaveTree2(root1, root2);
			}
			if (!result) { // 如果该根节点不对，则访问其左子树
				result = hasSubTree(root1.left, root2);
			}
			if (!result) { // 如果该根节点和左子树都不包含，则访问右子树
				result = hasSubTree(root1.right, root2);
			}
		}
		return result;
	}
	
	/**
	 * 判断树1是否包含树2
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
		if (root2 == null) { // 如果第二棵树的节点为空，说明是叶子节点，则返回true
			return true;
		}
		if (root1 == null) { // 如果第一棵树包含节点而第二棵树不包含，则返回false
			return false;
		}
		if (root1.val == root2.val) { // 如果两个根值相同，则分别比较两棵树的左右子树。
			return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.left));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));
	}

}
