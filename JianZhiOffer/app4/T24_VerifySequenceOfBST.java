package app4;
/**  
 * 面试题24：二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。   
 *  
 * @author 郑元浩 
 * @date 2017年3月26日 下午8:54:37 
 */
public class T24_VerifySequenceOfBST {
	
	/**
	 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
     * 例如：{5,7,6,9,11,10,8}
     *
     * @param sequence 某二叉搜索树的后序遍历的结果
     * @return true：该数组是某二叉搜索树的后序遍历的结果。false：不是
	 */
	public static boolean verifySequenceOfBST(int[] sequence){
		if (sequence.length == 0) {
			return false;
		}
		return verifySequenceOfBST(sequence, 0, sequence.length - 1);
	}
	
	/**
	 * /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 【此方法与上一个方法不同，未进行空值判断，对于数组度为0的情况返回的true也于上题不同，
     * 此方法只是上面一个方法的辅助实现，对于数数组为null和数组长度为0的情况，执行结果并非相同】
     * 【也就是说此方法只有数组中有数据的情况下才与上面的方法返回同样的结点，
     * verifySequenceOfBST(sequence) ===
     * verifySequenceOfBST(sequence, 0, sequence.length - 1)
     * 当sequence中有数据才成立
     * 】
     *
     * @param sequence 某二叉搜索树的后序遍历的结果
     * @param start    处理的开始位置
     * @param end      处理的结束位置
     * @return true：该数组是某二叉搜索树的后序遍历的结果。false：不是
	 */
	public static boolean verifySequenceOfBST(int[] sequence, int start, int end){
        if (start >= end) { // 只有一个元素
            return true;
        }
        int root = sequence[end];
        // 遍历左子树，此时i的值为右子树的第一个节点
        int i = start;
        while (i < end && sequence[i] < root) {
            i++;
        }
        // 遍历右子树，正确的话j的值应该是end
        int j = i;
        while (j < end && sequence[j] > root) {
            j++;
        }
        if (j != end) {
            return false;
        }
        // 递归判断左右子树
        return verifySequenceOfBST(sequence, start, i - 1) && verifySequenceOfBST(sequence, i, end - 1);
    }
	
	public static void main(String[] args) {
		// 正常测试
		int[] sequence = {5, 7, 6, 9, 11, 10, 8};
		System.out.println("true: " + verifySequenceOfBST(sequence));
		int[] sequence1 = {7, 4, 6, 5};
		System.out.println("false: " + verifySequenceOfBST(sequence1));
		int[] sequence2 = {7, 4, 6, 5, 9, 11, 10, 8};
		System.out.println("false: " + verifySequenceOfBST(sequence2));
		// 只有左子树
		int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySequenceOfBST(data3));
        // 只有右子树
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySequenceOfBST(data4));
        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySequenceOfBST(data5));
        
	}

}
