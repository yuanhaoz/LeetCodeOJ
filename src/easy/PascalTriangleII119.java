package easy;

import java.util.ArrayList;
import java.util.List;

/** 
 * 119. Pascal's Triangle II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 98686
Total Submissions: 283033
Difficulty: Easy
Contributors: Admin
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author 郑元浩
 * @date 2016年12月29日  上午23:49:27 
 */
public class PascalTriangleII119 {

	public static void main(String[] args) {
		List<Integer> list = getRow(2);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	public static List<Integer> getRow(int rowIndex) {
		rowIndex = rowIndex + 1;
		List<List<Integer>> list = new ArrayList<List<Integer>>(rowIndex);
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex; i++) {
			List<Integer> line = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (i == 0 || j == 0 || i == j) {
					line.add(1);
				} else {
					line.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
				}
			}
			list.add(line);
			if(rowIndex == i+1){
				result = line;
			}
		}
        return result;
    }
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
		for (int i = 0; i < numRows; i++) {
			List<Integer> line = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (i == 0 || j == 0 || i == j) {
					line.add(1);
				} else {
					line.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
				}
			}
			list.add(line);
		}
        
        return list;
    }
	
	

}
