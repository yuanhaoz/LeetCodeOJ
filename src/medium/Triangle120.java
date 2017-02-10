package medium;

import java.util.ArrayList;
import java.util.List;

/**  
 * 120. Triangle   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 90851
Total Submissions: 280295
Difficulty: Medium
Contributors: Admin
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.   
 *  
 * @author 郑元浩 
 * @date 2017年1月2日 下午9:32:27 
 */
public class Triangle120 {

	public static void main(String[] args) {
		
	}
	
	/**
	 * This problem is quite well-formed in my opinion. The triangle has a tree-like structure, 
	 * which would lead people to think about traversal algorithms such as DFS. However, if you look closely, 
	 * you would notice that the adjacent nodes always share a 'branch'. In other word, there are overlapping subproblems. 
	 * Also, suppose x and y are 'children' of k. Once minimum paths from x and y to the bottom are known, 
	 * the minimum path starting from k can be decided in O(1), that is optimal substructure. 
	 * Therefore, dynamic programming would be the best solution to this problem in terms of time complexity.

	What I like about this problem even more is that the difference between 'top-down' and 'bottom-up' DP 
	can be 'literally' pictured in the input triangle. For 'top-down' DP, starting from the node on the very top, 
	we recursively find the minimum path sum of each node. When a path sum is calculated, we store it in an array 
	(memoization); the next time we need to calculate the path sum of the same node, just retrieve it from the array.
	 However, you will need a cache that is at least the same size as the input triangle itself to store the pathsum,
	  which takes O(N^2) space. With some clever thinking, it might be possible to release some of the memory that
	   will never be used after a particular point, but the order of the nodes being processed is not 
	   straightforwardly seen in a recursive solution, so deciding which part of the cache to discard can 
	   be a hard job.
		
		'Bottom-up' DP, on the other hand, is very straightforward: we start from the nodes on the bottom row; 
		the min pathsums for these nodes are the values of the nodes themselves. From there, the min pathsum at
		 the ith node on the kth row would be the lesser of the pathsums of its two children plus the value of itself,
		  i.e.:
		
		minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
		Or even better, since the row minpath[k+1] would be useless after minpath[k] is computed, we can simply 
		set minpath as a 1D array, and iteratively update itself:
		
		For the kth level:
		minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i]; 
		Thus, we have the following solution
		
		从下往上遍历数组，每次将该行的值替换为下一行相邻两个数中小的数和它相加的值，最终到头元素的时候获得最小的值。
		
	 * @param triangle
	 * @return
	 */
	public static int minimumTotal(List<List<Integer>> triangle) {
		for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++){
            	/**
            	 * 获得下一层相邻两个数中小的那一个
            	 */
            	int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
            	/**
            	 * 更新本层该位置的值
            	 */
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        return triangle.get(0).get(0);
    }
	
	public static int minimumTotal2(List<List<Integer>> triangle) {
        List<Integer> list = new ArrayList<Integer>();
        int[] s = new int[triangle.size()];
        s[0] = triangle.get(0).get(0);
        list.add(0);
        int i = 1;
        while (i < triangle.size()) {
        	if(triangle.get(i).get(list.get(i-1)) < triangle.get(i).get(list.get(i-1)+1)){
        		list.add(list.get(i-1));
        	} else {
        		list.add(list.get(i-1)+1);
        	}
			s[i] = s[i-1] + Math.min(triangle.get(i).get(list.get(i-1)), triangle.get(i).get(list.get(i-1)+1));
			i++;
		}
        return s[triangle.size()-1];
    }

}
