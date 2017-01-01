package meidum;
/**  
 * 64. Minimum Path Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 95629
Total Submissions: 257855
Difficulty: Medium
Contributors: Admin
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes 
the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Subscribe to see which companies asked this question   
 *  
 *  解决思路：
 *  动态规划的思想，S[i,j] = A[i, j] + Min(S[i, j-1](if j>0), S[i-1, j](if i>0))
 *  
 * @author 郑元浩 
 * @date 2017年1月1日 下午2:21:08 
 */
public class MinimumPathSum64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0}};
//		int[][] grid = {{1,2,3},{2,1,3}};
		minPathSum(grid);
	}
	
	/**
	 * 解决思路：动态规划的思想，S[i,j] = A[i, j] + Min(S[i, j-1](if j>0), S[i-1, j](if i>0))
	 * @param grid
	 * @return
	 */
	public static int minPathSum(int[][] grid) {
			int m = grid.length;
			int n = grid[0].length;
			int[][] S = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j <	n; j++) {
					if (i > 0 && j >0) {
						S[i][j] = grid[i][j] + Math.min(S[i-1][j], S[i][j-1]);
					} else if (i == 0 && j > 0) {
						S[i][j] = grid[i][j] + S[i][j-1];
					} else if (i > 0 && j == 0) {
						S[i][j] = grid[i][j] + S[i-1][j];
					} else if (i == 0 && j == 0) {
						S[i][j] = grid[0][0];
					}
				}
			}
			System.out.println(S[m-1][n-1]);
			return S[m-1][n-1];
    }

}
