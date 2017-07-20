package utils;

import java.util.Collections;
import java.util.List;

public class ListCompare {

	public static void main(String[] args) {

	}
	
	/**
	 * 使用泛型对所有基层Comparable的类都可以使用Collections进行从小到大排序，然后再一一对比元素。
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
		if (a.size() != b.size()) {
			return false;
		}
		Collections.sort(a);
		Collections.sort(b);
		for (int i = 0; i < a.size(); i++) {
			if (!a.get(i).equals(b.get(i))) {
				return false;
			}
		}
		return true;
	}

}
