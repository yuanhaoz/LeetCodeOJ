package niuke;

import java.util.Scanner;

public class Wangyi_hechangtuan {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		workflow();
	}
	
	public static void workflow(){
		sc = new Scanner(System.in);
		int n = sc.nextInt(); // 学生的个数
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt(); // 每个学生的能力值 ai
		}
		int k = sc.nextInt(); // 从这 n 个学生中按照顺序选取 k 名学生
		int d = sc.nextInt(); // 要求相邻两个学生的位置编号的差不超过 d
		
		System.out.println(computeBestK(a, k , d));
	}
	
	public static long computeBestK(int[] array, int k, int d) {

        if(array.length == 0 || k == 0 || d ==0)
            return 0;
        if(array.length == 1 && k == 1 )
            return array[0];

        if(array.length >1 && k >=1 )
        {
            long max = Long.MIN_VALUE;

            for (int i = k-1; i < array.length; i++) {
                long maxEndByCurrent = computeMaxEndBy(array, k, d, i);
                if( max < maxEndByCurrent)
                    max = maxEndByCurrent;
            }
            return max;

        }
        else
        {
            System.out.println("input case error");
            return -1;
        }
    }

    private static long computeMaxEndBy(int[] array, int k, int d, int end) {
        if(k == 1)
            return array[end];

        long max = Long.MIN_VALUE;

        for (int j = 1; j <= d && (end-j)>=0 &&  (end-j)>= (k-1)-1; j++) {
            //(end-j)>= (k-1)-1 是需要保证在向前寻找的时候，结尾元素之前至少还需要有k-1个元素，否则元素数目不够
            long res1 = array[end] * computeMaxEndBy(array, k-1, d, end-j);   ;
            long res2 = array[end] * computeMinEndBy(array, k-1, d, end-j);

            long larger = res1 > res2 ? res1: res2;

            if(max < larger)
                max = larger;
        }

        return max;
    }

    private static long computeMinEndBy(int[] array, int k, int d, int end) {
        if(k == 1)
            return array[end];

        long min = Long.MAX_VALUE;
        for( int j =1 ; j <= d && (end-j)>=0 && (end-j)>= (k-1)-1; j++)
            //(end-j)>= (k-1)-1 是需要保证在向前寻找的时候，结尾元素之前至少还需要有k-1个元素，否则元素数目不够
        {
            long res1 = array[end] * computeMaxEndBy(array, k-1, d, end-j);   ;
            long res2 = array[end] * computeMinEndBy(array, k-1, d, end-j);

            long smaller = res1 < res2 ? res1: res2;

            if(min > smaller)
                min = smaller;
        }
        if( min == Long.MAX_VALUE)
            System.out.println("k"+k+"d"+d+"end"+end);

        return min;
    }


}
