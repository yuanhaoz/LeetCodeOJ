package niuke;

/**
 * LintCode 岛屿的个数
 标签： 算法java
 2015-08-22 23:06 925人阅读 评论(0) 收藏 举报
 分类： LintCode（4）
 版权声明：本文为博主原创文章，未经博主允许不得转载。

 题目:


 给一个01矩阵，求不同的岛屿的个数。

 0代表海，1代表岛，如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。

 样例
 在矩阵：

 [
 [1, 1, 0, 0, 0],
 [0, 1, 0, 0, 1],
 [0, 0, 0, 1, 1],
 [0, 0, 0, 0, 0],
 [0, 0, 0, 0, 1]
 ]
 中有 3 个岛.


 思想:

 运用了一些递归的思想,首先是双层for循环逐个遍历矩阵的元素.

 找到某个元素为1的时候,利用递归的思想将这个元素的上下左右,和它相邻的为true的上下左右元素,和相邻的相邻的....  这些元素改为false

 最后返回num


 * Created by yuanhao on 2017/5/10.
 */
public class NumIslands {

    public static void main(String[] args) {
        boolean[][] grid = {{true, true, false, false, false}, {false, true, false, false, true}, {false, false, false, true, true},
                {false, false, false, false, false}, {false, false, false, false, true}};
        System.out.println(numIslands(grid));
    }

    /**
     * 遍历矩阵的每一个元素，一旦遇到一个true岛屿数就加1，并且递归将该节点的相邻值为true的节点变成false
     * 递归的思想
     * @param grid
     * @return
     */
    public static int numIslands(boolean[][] grid) {
        int num = 0;
        if (grid == null)
            return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == true) {
                    num++;
                    grid = change(grid, i, j);
                }
            }
        }
        return num;
    }

    /**
     * 将某个为true的结点的上下左右节点的值都变为false，即对所有连续的岛屿，只用计算一次即可
     * 递归的思想
     * @param grid 岛屿矩阵
     * @param i 行
     * @param j 列
     * @return
     */
    public static boolean[][] change(boolean[][] grid, int i, int j) {
        // 修改为false
        grid[i][j] = false;
        // 修改上边的
        if (i > 0 && grid[i - 1][j] == true) {
            grid = change(grid, i - 1, j);
        }
        // 修改右边的
        if (j < grid[i].length - 1 && grid[i][j + 1] == true) {
            grid = change(grid, i, j + 1);
        }
        // 修改左边的
        if (j > 0 && grid[i][j - 1] == true) {
            grid = change(grid, i, j - 1);
        }
        // 修改下边的
        if (i < grid.length - 1 && grid[i + 1][j] == true) {
            grid = change(grid, i + 1, j);
        }
        return grid;
    }

}
