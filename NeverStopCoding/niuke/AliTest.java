package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class AliTest {
	
	static int result = 0;
	
	static int cut(int[] parts) {
		Arrays.sort(parts);
		if (parts.length > 2) {
			for (int i = 0; i < parts.length; i++) {
				result += parts[i];
			}
		}
		mSort(parts, 0, parts.length - 1);
		return result;
    }
	
	public static void mSort(int[] arr, int left, int right) {
		if (left == right) {
			return ;
		}
		if (left + 1 == right) {
			result += arr[left] + arr[right];
			return ;
		}
		int mid = (left + right) / 2;
		mSort(arr, left, mid);
		mSort(arr, mid + 1, right);
	}
	
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));
    }

}
