package app7;

/**
 * Created by yuanhao on 2017/4/26.
 */
public class StringTest {

    public static void getLCString(char[] str1, char[] str2) {
        int xlen = str1.length; // 横向长度
        int ylen = str2.length; // 纵向长度
        int[] tmp = new int[xlen]; // 保存矩阵的上一行
        int[] arr = tmp; // 保存矩阵的当前行
        int maxlen = 0; // 矩阵元素中最大值
        int pos = 0; // 矩阵元素最大值出现在第几列

        for (int i = 0; i < ylen; i++) { // 对每一行元素的数组进行更新
            for (int j = 0; j < xlen; j++) {
                if (str2[i] == str1[j]) {
                    if (j == 0)
                        arr[j] = 1;
                    else
                        arr[j] = tmp[j - 1] + 1;
                    if (arr[j] > maxlen) {
                        maxlen = arr[j];
                        pos = j;
                    }
                }
            }
            tmp = arr;
        }
        for (int i = pos - maxlen + 1; i <= pos; i++) {
            System.out.print(str1[i]);
        }
    }

    public static void LCS(char[] str1, char[] str2) {
        int a = LCS(str1, 0, str2, 0);
        System.out.println(a);
    }

    public static int LCS(char[] str1, int s1, char[] str2, int s2) {
        if (s1 >= str1.length || s2 >= str2.length) {
            return 0;
        }
        if (str1[s1] == str2[s2]) {
            return 1 + LCS(str1, s1 + 1, str2, s2 + 2);
        } else {
            return LCS(str1, s1 + 1, str2, s2) > LCS(str1, s1, str2, s2 + 1) ? LCS(str1, s1 + 1, str2, s2) : LCS(str1, s1, str2, s2 + 1);
        }

    }

    public static void main(String[] args) {
        char[] str1 = {'b', 'a', 'b', 'a', 'c', 'a', 'b'};
        char[] str2 = {'c', 'a', 'b', 'a'};
        getLCString(str1, str2);
        getLCString("21232523311324".toCharArray(), "312123223445".toCharArray());
        LCS("ADEFG".toCharArray(), "ABCDEG".toCharArray());
    }
}
