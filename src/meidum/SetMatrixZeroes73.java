package meidum;

import java.util.HashSet;
import java.util.Set;

/**  
 * 73. Set Matrix Zeroes   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 88125
Total Submissions: 250864
Difficulty: Medium
Contributors: Admin

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.   
 *  
 * @author 郑元浩 
 * @date 2017年1月9日 上午8:53:33 
 */
public class SetMatrixZeroes73 {

	public static void main(String[] args) {
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
//		int[][] matrix = {{1,2,3},{4,0,6},{7,8,9}};
//		int[][] matrix = {{0},{1}};
		setZeroes(matrix);
	}
	
	/**
	 * 如果允许额外存储行和列清零的信息，那么题目就没有意思了。
	 * 希望只用O(1)的存储空间的时候，我们就得利用矩阵本身的存储空间了：把清零的信息保存在第一行和第一列里。
	 * @param matrix
	 */
	public static void setZeroes(int[][] matrix) {
		
	}
	
	/**
	 * 循环数组，时间复杂度为O(m*n)，空间复杂度为O(m)
	 * @param matrix
	 */
	public static void setZeroes2(int[][] matrix) {
		Set<Integer> set = new HashSet<Integer>(); // 值为0的列下标
        for (int i = 0; i < matrix.length; i++) {
        	boolean col = false;
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) { // 值为0的列下标
					col = true;
					set.add(j);
				}
			}
			if (col) { // 设置该行的值全为0
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
        for (int a : set) { // 遍历列下标，设置该列的值全为0
//        	System.out.println(a);
        	for (int i = 0; i < matrix.length; i++) {
				matrix[i][a] = 0;
			}
		}
        
//        for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
    }

}
