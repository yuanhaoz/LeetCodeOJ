package easy;

import java.util.ArrayList;
import java.util.List;

/** 
 * 118. Pascal's Triangle   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 111193
Total Submissions: 304326
Difficulty: Easy
Contributors: Admin
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * 
 * @author 郑元浩
 * @date 2016年12月29日  上午9:39:27 
 */
public class PascalTriangle118 {

	public static void main(String[] args) {
		List<List<Integer>> list = generate(4);
		for (int i = 0; i < list.size(); i++) {
			List<Integer> line = list.get(i);
			for (int j = 0; j < line.size(); j++) {
				System.out.println(line.get(j) + " ");
			}
			System.out.println();
		}
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
