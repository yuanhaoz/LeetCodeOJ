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
		// TODO Auto-generated method stub

	}
	
	public boolean Find(int [][] array,int target) {
		boolean flag = false;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				int s = array[i][j];
				if(target == s){
					flag = true;
					break;
				}
			}
		}
		return flag;
    }

}
