package dataStructure;

/**
 * 与字符串相关的一系列算法：
 * 1. 求两个字符串的最长公共子串
 * 2. 求两个字符串的最长公共子序列
 * 3.
 * 4.
 *
 * Created by yuanhao on 2017/5/10.
 */
public class StringUtils {

    public static void main(String[] args) {
        /**
         * 1. 求两个字符串的最长公共子串
         */
        String aa = "abc123edf";
        String bb = "bc123jg";
        System.out.println(getMaxSubstringLen(aa, bb));

        /**
         * 2. 求两个字符串的最长公共子序列
         * 保留空字符串是为了方法的完整性也可以不保留
         * 但是在方法中必须额外的初始化c[][]第一行第一列
         */
        String[] x = {"", "A", "B", "C", "B", "D", "A", "B"};
        String[] y = {"", "B", "D", "C", "A", "B", "A"};
        int[][] b = getLongestCommonSubsequence(x, y);
        display(b, x, x.length - 1, y.length - 1);
        System.out.println();

        String aaa = "Tom Hanks";
        String bbb = "Hankcs";
        aaa = "ABCBDAB";
        bbb = "BDCABA";
        System.out.println(getLongestCommonSubsequence2(aaa, bbb));

    }

    /**
     * 1. 求出两个字符串的最长公共子串
     * 问题：有两个字符串str1和str2，求出两个字符串中最长公共字符串
     * 例如：'acbbsdef'和'abbsced'的最长公共字符串是'bbs'
     * 算法思路：
     *  1）把两个字符串分别以行和列组成一个二维矩阵
     *  2）比较二维矩阵中行和列对应的每个点的字符是否相同，是设置这个点为1，否设置这个点为0
     *  3）通过查找值为1的最长对角线来找到最长公共字符串
     *  通过上面str1和str2两个字符串，分别得出以行和列组成的一个二维矩阵如下图：
     *    a c b b s d e f
     *  a 1 0 0 0 0 0 0 0
     *  b 0 0 1 1 0 0 0 0
     *  b 0 0 1 2 0 0 0 0
     *  s 0 0 0 0 3 0 0 0
     *  c 0 1 0 0 0 0 0 0
     *  e 0 0 0 0 0 0 1 0
     *  d 0 0 0 0 0 1 0 0
     *  从上图可以看到，str1和str2共有3个公共子串"bbs"，公共子串长度为3
     *  为了便面后序查找对角线长度的操作：
     *  可以先计算二维矩阵值得时候顺便计算出来当前最长的公共子串的长度
     *  即：某个二维矩阵元素的值由item[i][j]=1演变为item[i][j]=1+item[i-1][j-1]
     *
     * @param str1
     * @param str2
     * @return
     */
    public static StringBuilder getMaxSubstringLen(String str1, String str2) {
        // 把字符串转成字符数组
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        // 把两个字符串分别以行和列组成一个二维矩阵
        int[][] temp = new int[arr1.length][arr2.length];
        // 存储最长公共子串长度
        int length = 0;
        // start表明最长公共子串的起始点，end表明最长公共子串的终止点
        int end = 0;
        int start = 0; // 由终止点减去长度加1得到
        // 初始化二维矩阵中的第一行
        for (int i = 0; i < arr2.length; i++) {
            temp[0][i] = (arr1[0] == arr2[i]) ? 1 : 0;
        }
        // 初始化二维矩阵中的第一列
        for (int i = 0; i < arr1.length; i++) {
            temp[i][0] = (arr1[i] == arr2[0]) ? 1 : 0;
        }
        // 嵌套for循环：比较二维矩阵中每个点对应行列字符是否相等，相等的话设置为1，否则设置为0
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;

                    // 更新最长子串的长度和结束点
                    if (temp[i][j] > length) {
                        length = temp[i][j];
                        end = j;
                    }
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        // 求出最长公共子串的起始点
        start = end - length + 1;
        StringBuilder sb = new StringBuilder();
        // 通过查找出值为1的最长对角线就能找到最长公共子串
        for (int i = start; i < end + 1; i++) {
            sb.append(arr2[i]);
        }
        return sb;
    }

    /**
     * 2. 求两个字符序列的最长公共字符子序列
     * 问题描述：字符序列的子序列是指从给定的字符序列中随意地（不一定连续）去掉若干个字符（可能一个也不去）后所形成的字符序列。令给定的字符序列X='x0,x1,...,xm-1',
     * 序列Y='y0,y1,...,yk-1'是X的子序列，存在X的一个严格递增下标序列<i0,i1,...ik-1>，使得对所有的j=0,1,...k-1，有xij=yj。例如，X='ABCBDAB',Y='BCDB'是X的一个子序列。
     * 考虑最长公共子序列问题如何分解成子问题，设A='a0,a1,...am-1'，B='b0,b1,...,bm-1'，并Z='z0,z1,...,zk-1'为它们的最长公共子序列。不难证明有以下性质：
     * （1） 如果am-1=bn-1，则zk-1=am-1=bn-1，且“z0，z1，…，zk-2”是“a0，a1，…，am-2”和“b0，b1，…，bn-2”的一个最长公共子序列；
     * （2） 如果am-1!=bn-1，则若zk-1!=am-1，蕴涵“z0，z1，…，zk-1”是“a0，a1，…，am-2”和“b0，b1，…，bn-1”的一个最长公共子序列；
     * （3） 如果am-1!=bn-1，则若zk-1!=bn-1，蕴涵“z0，z1，…，zk-1”是“a0，a1，…，am-1”和“b0，b1，…，bn-2”的一个最长公共子序列。（可以忽略。。。）
     *
     * 这样，在找A和B的公共子序列时，如有am-1=bn-1，则进一步解决一个子问题，找“a0，a1，…，am-2”和“b0，b1，…，bm-2”的一个最长公共子序列；
     * 如果am-1!=bn-1，则要解决两个子问题，找出“a0，a1，…，am-2”和“b0，b1，…，bn-1”的一个最长公共子序列和找出“a0，a1，…，am-1”和“b0，b1，…，bn-2”的一个最长公共子序列，
     * 再取两者中较长者作为A和B的最长公共子序列。
     * 求解：
     *
     * 引进一个二维数组c[][]，用c[i][j]记录X[i]与Y[j]的LCS长度，b[i][j]记录c[i][j]是通过哪一个子问题的值求得的，以决定搜索的方向。
     * 我们是自底向上进行递推计算，那么在计算c[i][j]之前，c[i-1][j-1], c[i-1][j]与c[i][j-1]均已计算出来。此时我们根据X[i]=Y[j]还是X[i]!=Y[j]，就可以计算出c[i][j]。
     * 问题的递归写成：
     *
     *                0,                           if i = 0 or j = 0
     *      c[i][j] = c[i-1, j-1] + 1,             if i,j > 0 and xi = yi
     *                max(c[i, j-1], c[i-1, j]),   if i,j > 0 and xi != yi
     *
     * 算法分析：
     * 由于每次调用至少向上或向左（或向上向左同时）移动一步，故最多调用（m*n）次就会遇到i = 0或j = 0的情况，此时开始返回。
     * 返回时与递归调用时方向相反，步数相同，故算法复杂度为O(m*n)
     *
     */
    public static int[][] getLongestCommonSubsequence(String[] x, String[] y) {
        int[][] b = new int[x.length][y.length];
        int[][] c = new int[x.length][y.length]; // 记录LCS长度

        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < y.length; j++) {
                // 对应第一个性质
                if (x[i] == y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1; // 三个值表示不同的情况
                }
                // 对应第一个性质
                else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 0;
                }
                // 对应第二个性质
                else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = -1;
                }
            }
        }

        return b;
    }

    // 回溯的基本实现，采用递归的方式
    public static void display(int[][] b, String[] x, int i, int j) {
        if (i == 0 || j == 0) {
            return ;
        }
        if (b[i][j] == 1) { // 说明是公共子串，可以打印
            display(b, x,i- 1, j - 1);
            System.out.print(x[i] + " ");
        } else if (b[i][j] == 0) { // 向上移动
            display(b, x, i - 1, j);
        } else if (b[i][j] == -1) { // 向左移动
            display(b, x, i, j-1);
        }
    }

    /**
     * 2. 求两个字符序列的最长公共字符子序列
     * 另外一个程序
     * @param string1
     * @param string2
     * @return
     */
    public static int getLongestCommonSubsequence2(String string1, String string2) {
        // 初始化
        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();
        int subStringLength1 = str1.length;
        int subStringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS长度
        int[][] opt = new int[subStringLength1 + 1][subStringLength2 + 1];

        // 从后往前，动态规划计算所有子问题。也可以从前到后。
        for (int i = subStringLength1 - 1; i >= 0; i--) {
            for (int j = subStringLength2 - 1; j >= 0; j--) {
                if (str1[i] == str2[j]) {
                    opt[i][j] = opt[i + 1][j + 1] + 1; // 状态转移方程
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]); // 状态转移方程
                }
            }
        }

        System.out.println("subString1：" + new String(str1));
        System.out.println("subString2：" + new String(str2));

        // 遍历打印LCS
        int i = 0, j = 0;
        while (i < subStringLength1 && j < subStringLength2) {
            if (str1[i] == str2[j]){
                System.out.print(str1[i]);
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println();
        return opt[0][0];
    }

}
