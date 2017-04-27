package app1_2;
/**  
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。   
 *  
 * @author 郑元浩 
 * @date 2017年2月24日 下午8:51:52 
 */
public class T4_ReplaceSpace {

	public static void main(String[] args) {
		char[] string = new char[50];
		string[0] = ' ';
		string[1] = 'e';
		string[2] = ' ';
		string[3] = ' ';
		string[4] = 'r';
		string[5] = 'e';
		string[6] = ' ';
		string[7] = ' ';
		string[8] = 'a';
		string[9] = ' ';
		string[10] = 'p';
		string[11] = ' ';

//		int length = replaceBlank(string, 12);
        int length = replaceBlank2(string, 12);
        System.out.println(new String(string, 0, length));


		char[] string1 = new char[50];
		string1[0] = 'a';
		string1[1] = 'e';
		string1[2] = 'v';
		string1[3] = 'c';
		string1[4] = 'r';
		string1[5] = 'e';
		string1[6] = 'b';
		string1[7] = 'b';
		string1[8] = 'a';
		string1[9] = 'b';
		string1[10] = ' ';
		string1[11] = 'q';

		int length1 = replaceString(string1, 12);
		System.out.println(new String(string1, 0, length1));
	}

	/**
	 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 *
	 * @param string     要转换的字符数组
	 * @param usedLength 字符数组中已经使用的长度
	 * @return 转换后使用的字符长度，-1表示处理失败
	 */
	public static int replaceBlank(char[] string, int usedLength) {
		// 判断输入是否合法
		if (string == null || string.length < usedLength) {
			return -1;
		}

		// 统计字符数组中的空白字符数
		int whiteCount = 0;
		for (int i = 0; i < usedLength; i++) {
			if (string[i] == ' ') {
				whiteCount++;
			}
		}

		// 计算转换后的字符长度是多少
		int targetLength = whiteCount * 2 + usedLength;
		int temp = targetLength; // 保存长度结果用于返回
		if (targetLength > string.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
			return -1;
		}

		// 如果没有空白字符就不处理
		if (whiteCount == 0) {
			return usedLength;
		}

		usedLength--; // 从后往前，第一个开始处理的字符
		targetLength--; // 处理后的字符放置的位置

		// 字符中有空白字符，一直处理到所有的空白字符处理完
		while (usedLength >= 0 && usedLength < targetLength) {
			// 如果当前字符是空白字符，进行"%20"替换
			if (string[usedLength] == ' ') {
				string[targetLength--] = '0';
				string[targetLength--] = '2';
				string[targetLength--] = '%';
			} else { // 否则移动字符
				string[targetLength--] = string[usedLength];
			}
			usedLength--;
		}

		return temp;
	}

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param string     要转换的字符数组，长度远大于usedLength，方便存储改变后的字符串
     * @param usedLength 字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */
    public static int replaceBlank2(char[] string, int usedLength) {
        if (string == null || string.length < usedLength) {
            return -1;
        }

        int blankNum = 0; // 得到空格数
        for (int i = 0; i < usedLength; i++) {
            if (string[i] == ' ') {
                blankNum++;
            }
        }
        int newLength = usedLength + 2 * blankNum; // 新字符串长度
        if (blankNum == 0) { // 没有空格则直接返回
            return newLength;
        }
        if (newLength > string.length) { // 新串的长度大于字符数组的长度则返回-1
            return -1;
        }
        // 替换字符数组
        int i = usedLength - 1;
        int j = newLength - 1;
        while (i >= 0 && j >= 0 && i < j) {
            if (string[i] != ' ') {
                string[j] = string[i];
                i--;
                j--;
            } else {
                string[j--] = '0';
                string[j--] = '2';
                string[j--] = '%';
                i--;
            }
        }
        return newLength;
    }

	/**
	 * 一个字符串，删除其中所有的'a'，把所有的'b'用'cc'替换。不能用额外的辅助空间，a的个数大于b的个数
	 *
	 * @param string
	 * @param usedLength
	 * @return
	 */
	public static int replaceString(char[] string, int usedLength) {
		// 判断输入是否合法
		if (string == null || string.length < usedLength) {
			return -1;
		}

		// 统计字符数组中的a和b的字符数
		int aCount = 0;
		int bCount = 0;
		for (int i = 0; i < usedLength; i++) {
			if (string[i] == 'a') {
				aCount++;
			} else if (string[i] == 'b') {
				bCount++;
			}
		}

		// 计算转换后的字符长度是多少
		int targetLength = usedLength + bCount - aCount;
		int temp = targetLength; // 保存长度结果用于返回
		if (targetLength > string.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
			return -1;
		}

		// 如果没有空白字符就不处理
		if (aCount == 0 && bCount == 0) {
			return usedLength;
		}

		usedLength--; // 从后往前，第一个开始处理的字符
		targetLength--; // 处理后的字符放置的位置

		// 字符中有空白字符，一直处理到所有的空白字符处理完
		while (usedLength >= 0 && usedLength < targetLength) {
			// 如果当前字符是空白字符，进行"%20"替换
			if (string[usedLength] == 'b') {
				string[targetLength--] = 'c';
				string[targetLength--] = 'c';
				usedLength--;
			} else if (string[usedLength] == 'a') {
				usedLength--;
				string[targetLength--] = string[usedLength];
			} else { // 否则移动字符
				string[targetLength--] = string[usedLength];
				usedLength--;
			}
		}

		return temp;
	}
	

}
