package meidum;

public class RemoveDuplicatesFromSortedArrayII82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesFromSortedArrayII82 a = new RemoveDuplicatesFromSortedArrayII82();
		int[] nums = {1,1,1,2,2,3};
		int length = a.removeDuplicates(nums);
		System.out.println("³¤¶ÈÎª£º" + length);
	}
	
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		int i, j, cnt;
		for(i = j = cnt = 0; i < n; i++){
			if(0 != j && nums[j - 1] == nums[i]){
				cnt++;
			} else {
				cnt = 0;
			}
			if(cnt < 2){
				nums[j++] = nums[i];
			}
		}
		for(i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
		return j;
    }

}
