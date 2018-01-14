package medium;

import bean.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal Add to List
 * DescriptionHintsSubmissionsSolutions
 * Total Accepted: 81106
 * Total Submissions: 257267
 * Difficulty: Medium
 * Contributor: LeetCode
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * Subscribe to see which companies asked this question.
 * Created by yuanhao on 2017/4/28.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal106 {

    /**
     * 根据中序遍历和后序遍历构造二叉树
     *
     * @param inorder   中序遍历数组
     * @param postorder 后序遍历数组
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    /**
     * 递归构造二叉树
     *
     * @param inorder   中序遍历数组
     * @param il        中序数组起始位置
     * @param ir        中序数组终止位置
     * @param postorder 后序遍历数组
     * @param pl        后序数组起始位置
     * @param pr        后序数组终止位置
     * @return 根节点
     */
    public static TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
//        System.out.println("il:" + il + ",ir:" + ir + ",pl:" + pl + ",pr:" + pr);
        if (il > ir || pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pr]); // 根节点为后序遍历数组的最后一个元素
        int val = postorder[pr]; // 根节点的值
        int pos = il; // 根节点对应在中序遍历数组中的位置
        while (pos <= ir && inorder[pos] != val) {
//            System.out.println(inorder[pos] + " " + val);
            pos++;
        }
        if (pos > ir) {
            throw new RuntimeException("输入不合法");
        }
        root.left = buildTree(inorder, il, pos - 1, postorder, pl, pl + pos - il - 1);
        root.right = buildTree(inorder, pos + 1, ir, postorder, pl + pos - il, pr - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] postorder = {7, 4, 2, 5, 8, 6, 3, 1};
        TreeNode root = buildTree(inorder, postorder);
        root.traversal(root);
    }

}
