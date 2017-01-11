package easy;

import java.util.HashMap;
import java.util.HashSet;


/** 
 * 36. Valid Sudoku   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 104194
Total Submissions: 307504
Difficulty: Easy
Contributors: Admin
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * 
 * @author 郑元浩
 * @date 2017年1月11日  下午8:21:27 
 */
public class ValidSudoku36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isValidSudoku(char[][] board) {
		
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] > '9') {
					return false;
				}
				if (board[i][j] != '.' && !set.contains(board[i][j])) {
					set.add(board[i][j]);
				} else if (set.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		HashSet<Character> set2 = new HashSet<Character>();
		for (int i = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {
				if (board[i][j] > '9') {
					return false;
				}
				if (board[i][j] != '.' && !set2.contains(board[i][j])) {
					set2.add(board[i][j]);
				} else if (set2.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		HashSet<Character> set3 = new HashSet<Character>();
		for (int i = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {
				if (board[i][j] > '9') {
					return false;
				}
				if (board[i][j] != '.' && !set3.contains(board[i][j])) {
					set3.add(board[i][j]);
				} else if (set3.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		HashSet<Character> set4 = new HashSet<Character>();
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] > '9') {
					return false;
				}
				if (board[i][j] != '.' && !set4.contains(board[i][j])) {
					set4.add(board[i][j]);
				} else if (set4.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		HashSet<Character> set5 = new HashSet<Character>();
		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 6; j++) {
				if (board[i][j] > '9') {
					return false;
				}
				if (board[i][j] != '.' && !set5.contains(board[i][j])) {
					set5.add(board[i][j]);
				} else if (set5.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		HashSet<Character> set6 = new HashSet<Character>();
		for (int i = 3; i < 6; i++) {
			for (int j = 6; j < 9; j++) {
				if (board[i][j] > '9') {
					return false;
				}
				if (board[i][j] != '.' && !set6.contains(board[i][j])) {
					set6.add(board[i][j]);
				} else if (set6.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		HashSet<Character> set7 = new HashSet<Character>();
		for (int i = 6; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] > '9') {
					return false;
				}
				if (board[i][j] != '.' && !set7.contains(board[i][j])) {
					set7.add(board[i][j]);
				} else if (set7.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		HashSet<Character> set8 = new HashSet<Character>();
		for (int i = 6; i < 9; i++) {
			for (int j = 3; j < 6; j++) {
				if (board[i][j] > '9') {
					return false;
				}
				if (board[i][j] != '.' && !set8.contains(board[i][j])) {
					set8.add(board[i][j]);
				} else if (set8.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		HashSet<Character> set9 = new HashSet<Character>();
		for (int i = 6; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				if (board[i][j] > '9' || board[i][j] < '0') {
					return false;
				}
				if (board[i][j] != '.' && !set9.contains(board[i][j])) {
					set9.add(board[i][j]);
				} else if (set9.contains(board[i][j])) {
					return false;
				}
			}
		}
		
		
		
        for (int i = 0; i < board.length; i++) {
        	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.' && !map.keySet().contains(board[i][j])) {
					map.put(board[i][j], j);
				} else if (map.keySet().contains(board[i][j])) {
					return false;
				}
			}
		}
        
        for (int j = 0; j < board[0].length; j++) {
        	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] != '.' && !map.keySet().contains(board[i][j])) {
					map.put(board[i][j], j);
				} else if (map.keySet().contains(board[i][j])) {
					return false;
				}
			}
		}
        
		return true;
    }

}
