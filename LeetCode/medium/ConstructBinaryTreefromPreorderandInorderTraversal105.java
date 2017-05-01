package medium;

import bean.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal Add to List
 * DescriptionHintsSubmissionsSolutions
 * Total Accepted: 96417
 * Total Submissions: 306368
 * Difficulty: Medium
 * Contributor: LeetCode
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * Created by yuanhao on 2017/4/28.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {

    /**
     * 根据前序遍历和中序遍历构造二叉树
     *
     * @param preorder 先序遍历数组
     * @param inorder  中序遍历数组
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    /**
     * 遍历构造二叉树
     *
     * @param preorder 先序遍历数组
     * @param pl       先序数组起始下标
     * @param pr       先序数组终止下标
     * @param inorder  后序遍历数组
     * @param il       后序数组起始下标
     * @param ir       后序数组终止下标
     * @return 根节点
     */
    public static TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]); // 根节点
        int val = preorder[pl]; // 根节点的值
        // 根节点在中序遍历数组中的位置
        int pos = il;
        while (pos <= ir && inorder[pos] != val) {
            pos++;
        }
//        if (pos > ir) { // 不会存在不合法的情况
//            throw new RuntimeException("输入不合法");
//        }
        // 根据pos遍历得到根节点的左右子树
        root.left = buildTree(preorder, pl + 1, pl + pos - il, inorder, il, pos - 1);
        root.right = buildTree(preorder, pl + pos - il + 1, pr, inorder, pos + 1, ir);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] postorder = {7, 4, 2, 5, 8, 6, 3, 1};
        TreeNode root = buildTree(preorder, inorder);
        TreeNode.traversal(root);
    }

}
