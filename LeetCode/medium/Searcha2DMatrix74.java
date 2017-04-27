package medium;
/**  
 * 74. Search a 2D Matrix   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 106143
Total Submissions: 297942
Difficulty: Medium
Contributors: Admin
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月5日 上午9:07:58 
 */
public class Searcha2DMatrix74 {
	
	public static void main(String[] args) {
//		int matrix[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//		int target = 3;
//		int matrix[][] = {};
//		int target = 0;
		int matrix[][] = {{1}};
		int target = 1;
//		int matrix[][] = {{1,1}};
//		int target = 1;
//		int matrix[][] = {{1,1},{2,2}};
//		int target = 2;
//		int matrix[][] = {{1,3,5,7},{10,11,16,16},{23,30,34,50}};
//		int target = 16;
		System.out.println(searchMatrix(matrix, target));
	}
	
	/**
	 * 1. 比较每一行的第一个元素，确定在第几行
	 * 2. 每一行内的比较使用二元查找，时间复杂度较低
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length != 0) { // 矩阵没有元素，长度为0时，返回flase，否则进行判断
	        int m = matrix.length;
	        int n = matrix[0].length;
	        if (n == 1) { // 只有一列
	        	for (int i = 0; i < m; i++) {
	        		if (target == matrix[i][0]) {
	        			return true;
	        		}
				}
			} else if (m == 1) { // 只有一行
				for (int i = 0; i < n; i++) {
	        		if (target == matrix[0][i]) {
	        			return true;
	        		}
				}
			} else { // 多行多列
				for (int i = 0; i < m - 1; i++) {
					if (target > matrix[i][0] && target < matrix[i + 1][0]) {
						int left = 0, right = n - 1;
						while (left <= right && left <= n - 1 && right <= n - 1) { // 二分查找
							int mid = (left + right) / 2;
							if (target == matrix[i][mid]) {
								return true;
							} else if (matrix[i][mid] < target) {
								left = mid + 1;
							} else {
								right = mid - 1;
							}
						}
					} else if (target == matrix[i][0]) {
						return true;
					}
				}
				if (target >= matrix[m - 1][0]) { // 最后一行判断
					for (int i = 0; i < n; i++) {
		        		if (target == matrix[m - 1][i]) {
		        			return true;
		        		}
					}
				}
			}
        }
        return false;
    }
	
	/**
	 * 循环遍历数组，但是时间复杂度是O(n*n)
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix.length != 0) {
			int i = 0, j = matrix[0].length - 1;
			while (i < matrix.length && j >= 0) {
				if (matrix[i][j] == target) {
					return true;
				} else if (matrix[i][j] > target) {
					j--;
				} else {
					i++;
				}
			}
		}
		return false;
	}

}
