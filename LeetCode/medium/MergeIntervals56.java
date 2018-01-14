package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals Add to List
 DescriptionHintsSubmissionsSolutions
 Total Accepted: 118785
 Total Submissions: 405568
 Difficulty: Medium
 Contributor: LeetCode
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 * Created by yuanhao on 2017/5/4.
 */
public class MergeIntervals56 {

    public static void main(String[] args) {
        MergeIntervals56 mergeIntervals56 = new MergeIntervals56();
        List<Interval> list = new ArrayList<>();
        Interval interval1 = new Interval(1,4);
        Interval interval2 = new Interval(3,6);
        Interval interval3 = new Interval(7,8);
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        List<Interval> result = mergeIntervals56.merge(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }

    /**
     * 思想：两个指针，一个指向start，一个指向end，每次遍历list元素的时候更新这两个元素的值
     * 实现：
     * 1. 对list按照start元素大小进行排序
     * 2. 当前元素的start小于等于end值时，说明有重叠的区域，更新end的值，继续判断下一个元素有没有重叠的区间
     * 3. 当前元素的start大于end值时，说明没有重复的区域，添加(start,end)构成的节点，更新这两个值为新节点的值
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        // Sort by ascending starting point using an anoymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) { // 有重叠区间，更新end的值
                end = Math.max(end, interval.end);
            } else { // 没有重叠区间，添加当前start和end构成的节点，并更新两个节点的值
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // 添加最后一个更新过的start和end
        result.add(new Interval(start, end));
        return result;
    }

//    Definition for an interval.
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

}
