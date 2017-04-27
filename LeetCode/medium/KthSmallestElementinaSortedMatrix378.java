package medium;

import java.util.Arrays;

/**  
 * 378. Kth Smallest Element in a Sorted Matrix   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 23824
Total Submissions: 55118
Difficulty: Medium
Contributors: Admin
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月5日 上午10:32:44 
 */
public class KthSmallestElementinaSortedMatrix378 {

	public static void main(String[] args) {
		int[][] matrix = {{ 1,  5,  9},{10, 11, 13},{12, 13, 15}};
		int k = 8;
		System.out.println(kthSmallest(matrix, k));
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[] num = new int[m*n];
		int index = 0;
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				num[index++] = matrix[i][j];
			}
		}
        Arrays.sort(num);
        return num[k-1];
    }
	
	
	/**
	 * Solution 2 : Binary Search
	We are done here, but let's think about this problem in another way:
	The key point for any binary search is to figure out the "Search Space". 
	For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest 
	number to the biggest number). Most usually, when the array is sorted in one direction, we can use 
	index as "search space", when the array is unsorted and we are going to find a specific number, we can use "range".
	
	Let me give you two examples of these two "search space"
	
	index -- A bunch of examples -- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ ( the array is sorted)
	range -- https://leetcode.com/problems/find-the-duplicate-number/ (Unsorted Array)
	The reason why we did not use index as "search space" for this problem is the matrix is sorted in two directions, 
	we can not find a linear way to map the number and its index.
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallest2(int[][] matrix, int k) {
		int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int count = 0,  j = matrix[0].length - 1;
			for(int i = 0; i < matrix.length; i++) {
				while(j >= 0 && matrix[i][j] > mid) j--;
				count += (j + 1);
			}
			if(count < k) lo = mid + 1;
			else hi = mid;
		}
		return lo;
	}

}
