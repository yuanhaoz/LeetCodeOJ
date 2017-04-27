package easy;
/**  
 * 88. Merge Sorted Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 136386
Total Submissions: 435548
Difficulty: Easy
Contributors: Admin

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.   
 *  
 * @author 郑元浩 
 * @date 2016年12月30日 下午5:02:06 
 */
public class MergeSortedArray88 {

	public static void main(String[] args) {
		int[] nums1 = {0};
		int m = 0;
//		int[] nums2 = {1, 2, 3, 4, 6, 7};
//		int n = 6;
		int[] nums2 = {1};
		int n = 1;
		merge2(nums1, m, nums2, n);
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1;
		int j=n-1;
		int k = m+n-1;
		while(i >=0 && j>=0)
		{
			if(nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
		while(j>=0)
			nums1[k--] = nums2[j--];
		
//		for (int ll = 0; ll < nums1.length; ll++) {
//			System.out.print(nums1[ll] + " ");
//		}
    }
	
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int[] nums3 = new int[m + n];
		if (m != 0 && n != 0) {
			int p1 = 0, p2 = 0, index = 0;
	        int temp1 = nums1[0];
	        int temp2 = nums2[0];
	        while (p1 < m && p2 < n) {
	        	if (temp1 < temp2) {
					nums3[index++] = temp1;
					p1++;
					if (p1 != m) {
						temp1 = nums1[p1];
					}
				} else {
					nums3[index++] = temp2;
					p2++;
					if (p2 != n) {
						temp2 = nums2[p2];
					}
				}
	        }
	        
	        while (p1 == m && p2 < n) {
	        	nums3[index++] = temp2;
	        	p2++;
				if (p2 != n) {
					temp2 = nums2[p2];
				}
			}
	        
	        while (p2 == n && p1 < m) {
	        	nums3[index++] = temp1;
	        	p1++;
				if (p1 != m) {
					temp1 = nums1[p1];
				}
			}
	        nums1 = nums3;
	        
		} 
		if (m == 0 && n != 0) {
			nums1 = nums2;
		}
		
		if (m == 0 && n == 1) {
			nums1[0] = 1;
		}
		
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + " ");
		}
    }

}
