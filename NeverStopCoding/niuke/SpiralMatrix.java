package niuke;
import java.util.Scanner;
/**
* @文件名称 :CycleMatrix.java
* @功能描述 :java实现螺旋矩阵
* @创建者 :云守护    542335496@qq.com
*/
public class SpiralMatrix {	
	static int length;
	static int[][] snake;
	static int value=1;
	private static Scanner input;
	static enum Direction{
		Right,Down,Left,Up;
	}
	public static void main(String[] args) {
	
		exe();
//		for(int k=0;k<10;k++){
//			exe();
//		}
	}
	public static void exe(){
		input = new Scanner(System.in);
		System.out.println("input number:");
		length=Integer.parseInt(input.nextLine());
		snake=new int[length][length];
		initArray();
		for(int i=0;i<length ;i++){
			
			for(int j=0;j<length ;j++){
				System.out.print(snake[i][j]+" ");
			}
//			System.out.println("");
		}
		
		System.out.println("");
		for(int i=0;i<length ;i++){
			
			for(int j=0;j<length ;j++){
				System.out.print(snake[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void initArray() {
		int row=0;
		int line=0;
		Direction direction=Direction.Right;
		for(int i=0;i<length*length;i++){
			
			snake[row][line]=value;
			direction=getDirection(row,line,direction);
			switch (direction) {
			case Right:
				line++;
				break;
			case Down:
				row++;
				break;
			case Left:
				line--;
				break;
			case Up:
				row--;
				break;
			}
			value++;
		}
	}
	private static Direction getDirection(int row, int line, Direction direction) {
		Direction nextDirection=direction;
		if(direction==Direction.Right){
			if(line==length-1|| snake[row][line+1]!=0){
				nextDirection=Direction.Down;
			}
		}else if(direction==Direction.Down){
			if(row==length-1|| snake[row+1][line]!=0){
				nextDirection=Direction.Left;
			}
		}else if(direction==Direction.Left){
			if(line==0|| snake[row][line-1]!=0){
				nextDirection=Direction.Up;
			}
		}else if(direction==Direction.Up){
			if(snake[row-1][line]!=0){
				nextDirection=Direction.Right;
			}
		}	
		return nextDirection;
	}
	

}
