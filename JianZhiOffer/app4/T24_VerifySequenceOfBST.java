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
		int root = sequence[end]; // 最后一个结点为根节点
		// 遍历前半部分，值比根节点小，因此找到第一个比根节点值大的点就退出
		int i = start;
		for (;i <= end; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		// 遍历后半部分，如果存在比根节点小的就返回false，不是二叉搜索树
		int j = i;
		for (; j <= end; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		// 再判断左右子树
		boolean result1 = true;
		boolean result2 = true;
		if (i < start) {
			result1 = verifySequenceOfBST(sequence, i, start);
		}
		if (end > j) {
			result2 = verifySequenceOfBST(sequence, j, end);
		}
		return result1 && result2;
	}
	
	public static void main(String[] args) {
		// 正常测试
		int[] sequence = {5, 7, 6, 9, 11, 10, 8};
		System.out.println("true: " + verifySequenceOfBST(sequence));
		int[] sequence1 = {7, 4, 6, 5};
		System.out.println("false: " + verifySequenceOfBST(sequence1));
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
