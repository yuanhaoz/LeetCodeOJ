package easy;
/**  
 * 463. Island Perimeter   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 19135
Total Submissions: 33830
Difficulty: Easy
Contributors: amankaraj

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:   
 *  
 * @author 郑元浩 
 * @date 2017年1月18日 下午12:03:05 
 */
public class IslandPerimeter463 {

	public static void main(String[] args) {

	}
	
	/**
	 * 4*所有值为1元素个数 - 2*所有相邻元素个数
	 * @param grid
	 * @return
	 */
	public static int islandPerimeter(int[][] grid) {
		int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
        
    }

}
