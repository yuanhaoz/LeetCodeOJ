package medium;
/**  
 * 62. Unique Paths   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 117611
Total Submissions: 300775
Difficulty: Medium
Contributors: Admin
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.   
 *  
 *  解决思路：
 *  动态规划的思想，S[i,j] = S[i, j-1](if j>0) + S[i-1, j](if i>0))
 *  
 * @author 郑元浩 
 * @date 2017年1月1日 下午4:19:55 
 */
public class UniquePaths62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(1, 2));
		System.out.println(uniquePaths(3, 7));
	}
	
	/**
	 * 动态规划的思想，S[i,j] = S[i, j-1](if j>0) + S[i-1, j](if i>0))
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m, int n) {
        int[][] s = new int[m][n];
        s[0][0]=1;
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i>0&&j>0) {
					s[i][j] = s[i-1][j] + s[i][j-1];
				} else if (i==0&&j>0) {
					s[i][j] = s[i][j-1];
				} else if (i>0&&j==0) {
					s[i][j] = s[i-1][j];
				}
			}
		}
        return s[m-1][n-1];
    }

}
