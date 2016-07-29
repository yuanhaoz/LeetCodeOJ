package niuke;
 
import java.util.*;
 
/**
 * Created by markzuo on 15-5-18.
 */
public class dads {
    private int n;
 
    public dads(int n) {
        this.n = n;
    }
 
    public void print() {
        int[][] data = new int[n][n];
 
        data[0][0] = 1;
        data[n-1][n-1] = n * n;
 
        //根据蛇形矩阵的特点，分为上下两部分，以斜线为单位计算数据，从1开始编号
        //本矩阵将从左至右为开始
        //Top:上半部分，负责对角线，斜线数为k,1<=k<=(n-1),对于矩阵阶数n不区分奇偶，k区分
        //每条斜线的最小数成递增数列，以1为开始
        for (int k = 1; k <= n-1; k++) {
            if (k % 2 == 1) {  //当k为奇数时，没条线的最小数在上方
                data[0][k] = 1 + k * (k + 1)/2;
 
                for (int i = 1; i <= k; i++) { //每条线需要计算k条数据
                    data[i][k-i] = data[0][k] + i; //行与列之和为k,从上往下计算，列递减
                }
            } else {//当k为偶数时，没条线的最小数在下方
                data[k][0] = 1 + k * (k + 1)/2;
 
                for (int i = 1; i <= k; i++) {
                    data[k-i][i] = data[k][0] + i;
                }
            }
        }
 
        //Down:上半部分，不负责对角线，斜线数为k,1<=k<=(n-2),对于矩阵阶数n区分奇偶，k也区分
        ////每条斜线的最大数成递减数列，以n*n为开始
        if (n % 2 == 1) {//n为奇数
            for (int k = 1; k <= n - 2; k++) {
                if (k % 2 == 0) { //如果k为偶数，最大数在下方
                    data[k][n-1] = data[n-1][n-1] - (n - k - 1) * (n - k)/2;
                    for (int i = 1; i < n - k; i++) { //从上至下，依次计算n-1-k条数据
                        data[i + k][n-1-i] = data[k][n-1] - i;  //行递增，列递减，和为n+k-1
                    }
                } else {//如果k为偶数，最大数在下方
                    data[n - 1][k] = data[n - 1][n - 1] - (n - k - 1) * (n - k) / 2;
                    for (int i = 1; i < n - k; i++) { //从下至上，依次计算n-1-k条数据
                        data[n - 1 - i][i + k] = data[n - 1][k] - i;  //行递减，列递增，和为n+k-1
                    }
                }
            }
 
        } else { //n为奇数，正好与偶数情况相反
            for (int k = 1; k <= n - 2; k++) {
                if (k % 2 == 1) { //如果k为奇数，最大数在下方
                    data[n-1][k] = data[n-1][n-1] - (n - k - 1) * (n - k)/2;
                    for (int i = 1; i < n - k; i++) { //从上至下，依次计算n-1-k条数据
                        data[n-1-i][i+k] = data[n-1][k] - i;  //行递减，列递增，和为n+k-1
                    }
                } else {//如果k为偶数，最大数在上方
                    data[k][n-1] = data[n - 1][n - 1] - (n - k - 1) * (n - k) / 2;
                    for (int i = 1; i < n - k; i++) { //从下至上，依次计算n-1-k条数据
                        data[i+k][n-i-1] = data[k][n-1] - i;  //行递增，列递减，和为n+k-1
                    }
                }
            }
        }
 
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
 
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        System.out.println("请输入一个蛇形矩阵的阶数：");
        dads sn = new dads(scan.nextInt());
        sn.print();
    }
}