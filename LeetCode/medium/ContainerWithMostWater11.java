package medium;
/**  
 * 11. Container With Most Water
Description  Submission  Solutions  Add to List
Total Accepted: 115513
Total Submissions: 319423
Difficulty: Medium
Contributors: Admin

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Subscribe to see which companies asked this question.   
 *  
 * @author 郑元浩 
 * @date 2017年2月14日 下午9:24:59 
 */
public class ContainerWithMostWater11 {

	public static void main(String[] args) {
//		int[] height = {3, 2, 1, 3, 2, 1, 6, 4, 5};
//		int[] height = {1, 1};
		int[] height = {1, 2, 4, 3};
		int area = maxArea(height);
		System.out.println(area);
	}
	
	/**
	 * 因为容易不可以倾斜（决定容器必须是矩形），所以可以容纳的水应该是ai,aj中小的那个数和x轴构成的矩阵，因为取大的值水会溢出
	 * 每次移动两个数中值较小的那个数的指针，因为移动大的下一次的面积不变，面积只会更小。
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
        return max;
    }

}
