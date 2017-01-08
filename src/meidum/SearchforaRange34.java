package meidum;
/**  
 * 34. Search for a Range   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 114961
Total Submissions: 372694
Difficulty: Medium
Contributors: Admin

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].   
 *  
 * @author 郑元浩 
 * @date 2017年1月7日 下午12:56:47 
 */
public class SearchforaRange34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {5,7,7,8,8,10};
		int target = 8;
//		int nums[] = {2,2};
//		int target = 3;
		searchRange(nums, target);
//		searchRange2(nums, target);
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int[] result = {-1, -1};
		if (nums.length == 0) {
			return result;
		}
        int left = 0;
        int right = nums.length - 1;
        // Search for the left one 找到左边的那个元素
        while (left < right) {
        	int mid = (left + right) / 2;
        	if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
        }
        if (nums[left] != target) {  // 如果没有找到，则说明不存在该元素
			return result;
		} else {
			result[0] = left;
		}
        
        // Search for the right one  找到右边的那个元素
        right = nums.length - 1; // We don't have to set i to 0 the second time. 第二次不需要改变left值，只需改变right的值
        while (left < right) {
        	int mid = (left + right) / 2 + 1;  // Make mid biased to the right  使得mid始终偏向右侧，一个trick技巧
        	if (nums[mid] > target) {
        		right = mid - 1;
			} else {
				left = mid;   // So that this won't make the search range stuck.
			}
        }
        result[1] = right;
        System.out.println(result[0] + " " + result[1]);
        return result;
	}
	
	public static int[] searchRange2(int[] nums, int target) {
		int[] result = {-1, -1};
		int len = nums.length;
		if (len == 0) {
			return result;
		}
        int right = 0;
        while (right < len) {
        	if (nums[right] < target) {
        		right++;
			} else {
				break;
			}
        }
        if (right > len - 1) {
        	return result;
		}
        if (nums[right] > target) {
			return result;
		}
        result[0] = right;
        while(right < len && nums[right] == target){
        	right++;
        }
        result[1] = right - 1;
        System.out.println(result[0] + " " + result[1]);
        return result;
        
    }

}
