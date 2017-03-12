package app;
/**  
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。  
 *  
 * @author 郑元浩 
 * @date 2017年2月24日 下午8:20:32 
 */
public class TwoArraySearch {

	public static void main(String[] args) {
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int target = 5;
		System.out.println(Find(target, array));
		target = 7;
		System.out.println(Find(target, array));
	}
	
	/**
	 * 总结查找过程，发现如下规律：
	 * 首先选取数组中右上角的数字。
	 * 如果该数字等于要查找的数字，查找过程结束；
	 * 如果该数字大于要查找的数字，剔除这个数字所在的列；（往左移动一列）
	 * 如果该数字小于要查找的数字，剔除这个数字所在的行。（往下移动一行）
	 * 也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或者一列，
	 * 这样每一步都可以缩小要查找的范围，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
	 * 
	 * @param target
	 * @param array
	 * @return
	 */
	public static boolean Find(int target, int [][] array){
		int rowSum = array.length;
		int columnSum = array[0].length;
		int row = 0;
		int col = columnSum - 1;
		while (row < rowSum && col >= 0) {
			if (array[row][col] == target) {
				return true;
			} else if (array[row][col] > target) {
//				System.out.println(array[row][col] + ">" + target);
				col--;
			} else if (array[row][col] < target) {
//				System.out.println(array[row][col] + "<" + target);
				row++;
			}
		}
		return false;
	}

}
