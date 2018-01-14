package medium;

import java.util.*;

/**
 * 90. Subsets II Add to List
 DescriptionHintsSubmissionsSolutions
 Total Accepted: 104802
 Total Submissions: 298448
 Difficulty: Medium
 Contributor: LeetCode
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 *
 * Created by yuanhao on 2017/5/3.
 */
public class SubsetsII90 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> list = subsetsWithDup(nums);
        System.out.println(list);
//        Map<Integer, Integer> map1 = new HashMap<>();
//        map1.put(1,1);
//        map1.put(2,2);
//        Map<Integer, Integer> map2 = new HashMap<>();
//        map2.put(1,1);
//        map2.put(2,2);
//        System.out.println(map1.equals(map2));
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(1);
//        System.out.println(list1.equals(list2));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> init = new ArrayList<Integer>(); // 构造第一个元素
        init.add(nums[0]);
        list.add(init); // 第一个元素
        list.add(new ArrayList<Integer>()); // 空元素
        for (int i = 1; i < nums.length; i++) {
            subsets(nums, list, i);
        }

        return removeDuplicate(list);
    }

    /**
     * 使用递归的方法，第n个数的所有情况是第n-1个数的每个list基础上，加上当前元素。然后当前元素单独可以构成一个。
     * 注意对象的引用传递的是对象在堆中的地址，需要重新赋值。
     *
     * @param nums
     * @param list
     * @param n
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums, List<List<Integer>> list, int n) {
        // 保存原来的list数据
        List<List<Integer>> listCopy = new ArrayList<List<Integer>>();
        for (List<Integer> list2 : list) {
            List<Integer> list2Copy = new ArrayList<Integer>();
            for (Integer integer : list2) {
                list2Copy.add(integer);
            }
            listCopy.add(list2Copy);
        }
        // 添加新的元素
        for (List<Integer> list2 : list) {
            list2.add(nums[n]);
        }
        // 加上原来的数据
        list.addAll(listCopy);
        return list;
    }

    public static List<List<Integer>> removeDuplicate(List<List<Integer>> list) {
        List<List<Integer>> listNew = new ArrayList<>(); // 没有重复元素的list
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list1 = list.get(i);
            Map<Integer, Integer> map1 = new HashMap<>(); // 两个list中的元素及其出现次数的map
            // 生成两个map
            for (int k = 0; k < list1.size(); k++) {
                if (!map1.containsKey(list1.get(k))){
                    map1.put(list1.get(k), 1);
                } else {
                    map1.put(list1.get(k), map1.get(list1.get(k)) + 1);
                }
            }

            boolean flag = false; // 标志位判断是否存在重复的list
            for (int j = i + 1; j < list.size(); j++) { // 遍历后面的list元素
                List<Integer> list2 = list.get(j);
                if (list1.size() == list2.size()) { // 首先保证两个list大小相同
                    Map<Integer, Integer> map2 = new HashMap<>(); // {1,4,4}和{4,1,4}被认为是重复的元素
                    for (int k = 0; k < list2.size(); k++) {
                        if (!map2.containsKey(list2.get(k))){
                            map2.put(list2.get(k), 1);
                        } else {
                            map2.put(list2.get(k), map2.get(list2.get(k)) + 1);
                        }
                    }
                    flag = map1.equals(map2);

                    int count = 0;
                    for (int k = 0; k < list1.size(); k++) {
                        if (list1.get(k) == list2.get(k)) {
                            count++;
                        }
                    }
                    if (count == list1.size()){
                        flag = true;
                    }
                }
            }
            if (!flag) {
                listNew.add(list1);
            }
        }
        return listNew;
    }



    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        helper(res, each, 0, nums);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }

}
