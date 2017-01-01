package meidum;
/**  
 * 240. Search a 2D Matrix II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 61206
Total Submissions: 161407
Difficulty: Medium
Contributors: Admin
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.   
 *  
 * @author 郑元浩 
 * @date 2017年1月5日 上午10:13:52 
 */
public class Searcha2DMatrixII240 {

	public static void main(String[] args) {
		int matrix[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int target = 3;
//		int matrix[][] = {};
//		int target = 0;
//		int matrix[][] = {{1}};
//		int target = 1;
//		int matrix[][] = {{1,1}};
//		int target = 1;
//		int matrix[][] = {{1,1},{2,2}};
//		int target = 2;
//		int matrix[][] = {{1,3,5,7},{10,11,16,16},{23,30,34,50}};
//		int target = 16;
		System.out.println(searchMatrix(matrix, target));
	}
	
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
				for (int i = 0; i < m; i++) {
					if (target > matrix[i][0]) {
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
			}
        }
        return false;
    }
	
	public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

}
