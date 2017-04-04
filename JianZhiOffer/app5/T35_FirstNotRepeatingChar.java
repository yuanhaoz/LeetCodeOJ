package app5;

import java.util.TreeMap;

/**  
 * 面试题35：第一个只出现一次的字符
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 * 
 * 思路：
 * 1. 从头开始扫描这个字符串中的每个字符。当访问到某字符时那这个字符和后面的字符比较，如果后面没有发现重复的字符，则这个字符就是只出现一次的字符。
 *    如果字符串有n个字符，每个字符可能与后面的O(n)个字符相比较，因此这种思路的时间复杂度是O(n^2)
 * 2. 可以使用哈希表统计每个字符在该字符串中出现的次数。需要从头开始扫描字符串两次。第一次扫描字符串时，每扫描到一个字符就在哈希表的对应项中把次数加1.
 *    接下来第二次扫描时，没扫描到一个字符就能从哈希表中得到该字符出现的次数。这样第一个只出现一次的字符就是符合要求的输出。（不能使用HashMap，因为它是无序的，
 *    可以使用TreeMap或者LinkedHashMap）
 *    
 * 测试用例：
 * 1.字符串中存在只出现一次的字符，不存在只出现一次的字符，每个字符都只出现一次。字符串为NULL指针。
 * 
 * 本题考点：
 * 1. 考查对数组、字符串的编程能力。
 * 2. 考查对哈希表的理解及运用。
 * 3. 考查对时间效率及空间效率的分析能力。
 *  
 * 本题扩展：
 * 1. 在前面的例子中，我们之所以可以把哈希表的大小设为256，是因为字符（char）是8个bit的类型，总共有256个字符。但实际上字符不只是256个，比如中文有几千个汉字。
 *    如果题目中要求考虑汉字，前面的算法是不是有问题？如果有，可以怎么解决？
 *    
 * 相关题目：
 * 1. 定义一个函数，输入两个字符串，从第一个字符串中删除在第二个字符串中出现过的所有字符。
 *    例如从第一个字符串"We are students."中删除在第二个字符串"aeiou"
 *    中出现过的字符得到的结果是"W r Stdnts."。为了解决这个问题，我们可以创建一个用数组实现的简单哈希表来存储第二个字符串。这样我们从头到尾扫描第一个字符串的
 *    每一个字符时，用O(1)时间就能判断出该字符是不是在第二个字符中。如果第一个字符串的长度是n，那么总的时间复杂度是O(n)。
 * 2. 定义一个函数，删除字符串中所有重复出现的字符。例如输入"google"，删除重复的字符之后的结果是"gole"。
 * 	     这个题目和上面的问题比较类似，我们可以创建一个用布尔数组
 *    实现的简单的哈希表。数组中元素的意义是其下标看做ASCII码后对应的字母在字符串中是否已经出现。我们先把数组中所有元素都设为false。以"google"为例，当扫描到
 *    第一个"g"时，g的ASCII码是103，那么我们把数组中下标为103的元素设为true。当扫描到第二个g时，我们发现数组中下标为103的元素值已经是true，就知道g在前面已经
 *    出现了。也就是说，我们用O(1)时间就能判断出每个字符是否在前面已经出现过。如果字符串的长度是n，那么总的时间复杂度是O(n)。
 * 3. 在英语中，如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，那么这两个单词互为变位词（Anagram）。例如silent与listen、evil与live等互为变位词。
 *    请完成一个函数，判断输入的两个字符串是不是互为变位词。
 *    我们可以创建一个用数组实现的简单哈希表，用来统计字符串中每个字符串出现的次数。当扫描到第一个字符串中的每个
 *    字符串时，为哈希表对应的项的值增加1.接下来扫描第二个字符串，扫描到每个字符串时，为哈希表对应的项的值减去1。如果扫描完第二个字符串后，哈希表中所有的值都是0，
 *    那么这两个字符串就互为变位词。
 *    
 * 举一反三：
 * 1. 如果需要判断多个字符是不是在某个字符串里出现过或者统计多个字符在某个字符串中出现的次数，我们可以考虑基于数组创建一个简单的哈希表。
 *    这样可以用很小的空间消耗换来时间效率的提升。
 * 
 * 
 * @author 郑元浩 
 * @date 2017年3月31日 上午9:50:25 
 */
public class T35_FirstNotRepeatingChar {
	
	public static void firstNotRepeatingChar(String s) {
		if (s.length() == 0) {
			System.err.println("字符串为空串或者字符串长度为0。。。");
		}
		TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (treeMap.containsKey(s.charAt(i))) {
				treeMap.put(s.charAt(i), treeMap.get(s.charAt(i)) + 1);
			} else {
				treeMap.put(s.charAt(i), 1);
			}
		}
//		for (Character c : treeMap.keySet()) {
//			System.out.println(c + "--->" + treeMap.get(c));
//		}
		boolean flag = false;
		for (Character c : treeMap.keySet()) {
			if (treeMap.get(c) == 1) {
				flag = true;
				System.out.println(c);
				break;
			}
		}
		if (!flag) {
			System.err.println("不存在出现次数为1的字符，每个字符至少出现1次以上。。。");
		}
	}

	public static void main(String[] args) {
		firstNotRepeatingChar("abaccdeff");
		firstNotRepeatingChar("abcd");
		firstNotRepeatingChar("aabbccdd");
		System.out.println("");
	}

}
