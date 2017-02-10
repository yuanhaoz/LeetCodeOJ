package medium;
/**  
 * 63. Unique Paths II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 87977
Total Submissions: 284980
Difficulty: Medium
Contributors: Admin
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.   
 *  
 *  解决思路：
 *  动态规划的思想，S[i,j] = S[i, j-1](if obstacleGrid[i][j-1]!=1) + S[i-1, j](if obstacleGrid[i-1][j]!=1))
 *  
 * @author 郑元浩 
 * @date 2017年1月1日 下午4:32:15 
 */
public class UniquePathsII63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int obstacleGrid[][] = {{0}};
//		int obstacleGrid[][] = {{1}};
		int obstacleGrid[][] = {{0, 1}};
//		int obstacleGrid[][] = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
	
	/**
	 * 动态规划的思想，S[i,j] = S[i, j-1](if obstacleGrid[i][j-1]!=1) + S[i-1, j](if obstacleGrid[i-1][j]!=1))
	 * @param obstacleGrid
	 * @return
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int s[][] = new int[m][n];
        if (obstacleGrid[0][0]!=1 && obstacleGrid[m-1][n-1]!=1) {
        	s[0][0] = 1;
        	for (int i = 0; i < m; i++) {
    			for (int j = 0; j < n; j++) {
    				if (i>0 && j>0 && obstacleGrid[i-1][j]!=1 && obstacleGrid[i][j-1]!=1) {
    						s[i][j] = s[i-1][j] + s[i][j-1];
    				} else if (i>0 && j>0 && obstacleGrid[i-1][j]==1 && obstacleGrid[i][j-1]!=1) {
    					s[i][j] = s[i][j-1];
    				} else if (i>0 && j>0 && obstacleGrid[i-1][j]!=1 && obstacleGrid[i][j-1]==1) {
    					s[i][j] = s[i-1][j];
    				} else if (i==0 && j>0 && obstacleGrid[i][j-1]!=1) {
    					s[i][j] = s[i][j-1];
    				} else if (j==0 && i>0 && obstacleGrid[i-1][j]!=1) {
    					s[i][j] = s[i-1][j];
    				}
    			}
    		}
            return s[m-1][n-1];
		} else {
			return 0;
		}
        
    }
	
	// 简单一点的方法
//	if(obstacleGrid[i][j] == 1)
//        obstacleGrid[i][j] = 0;

}
