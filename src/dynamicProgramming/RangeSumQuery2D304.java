package dynamicProgramming;

/**
 * 304. Range Sum Query 2D - Immutable
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 * @author 郑元浩
 * @date 2017年8月30日 下午5:43:11
 *
 */
public class RangeSumQuery2D304 {
	
	private int[][] dp;

	public RangeSumQuery2D304(int[][] matrix) {
	    if(   matrix           == null
	       || matrix.length    == 0
	       || matrix[0].length == 0   ){
	        return;   
	    }
	    
	    int m = matrix.length;
	    int n = matrix[0].length;
	    
	    dp = new int[m + 1][n + 1];
	    for(int i = 1; i <= m; i++){
	        for(int j = 1; j <= n; j++){
	            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] -dp[i - 1][j - 1] + matrix[i - 1][j - 1] ; // 动态规划
	        }
	    }
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
	    int iMin = Math.min(row1, row2);
	    int iMax = Math.max(row1, row2);
	    
	    int jMin = Math.min(col1, col2);
	    int jMax = Math.max(col1, col2);
	    
	    return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];    
	}
	
//	int[][] matrix;
//	
//	/**
//	 * 构造函数
//	 * @param matrix
//	 */
//	public RangeSumQuery2D304(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				if (i == 0 && j > 0) { // 第一行，加上左边
//					matrix[i][j] += matrix[i][j - 1];
//				} else if (j == 0 && i > 0) { // 第一列，加上上边
//					matrix[i][j] += matrix[i - 1][j];
//				} else { // 中间的元素，加上上边和左边，减去左上角（因为上边和左边加了两次）
//					matrix[i][j] += matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1];
//				}
//			}
//		}
//        this.matrix = matrix;
//    }
//    
//	/**
//	 * 
//	 * @param row1
//	 * @param col1
//	 * @param row2
//	 * @param col2
//	 * @return
//	 */
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        if (row1 == 0 && col1 == 0) {
//			return matrix[row2][col2];
//		} else if (row1 == 0) {
//			return matrix[row2][col2] - matrix[row1][col1 - 1];
//		} else if (col1 == 0) {
//			return matrix[row2][col2] - matrix[row1 - 1][col1];
//		} else {
//			return matrix[row2][col2] - matrix[row1 - 1][col1 - 1];
//		}
//    }

}
