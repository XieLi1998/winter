package 牛客题霸.数组;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by xieli on 2020/12/4.
 */
public class 合并区间NC37 {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // 先按照区间起始位置排序，集合用 Collections 排序
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        ArrayList<Interval> res = new ArrayList<>();
        int len = intervals.size();
        int idx = 0;
        while (idx < len) {
            int left = intervals.get(idx).start;
            int right = intervals.get(idx).end;
            while (idx < len - 1 && intervals.get(idx + 1).start <= right) {
                // 防止给定区间 left > right
                right = Math.max(right, intervals.get(idx + 1).end);
                idx++;
            }
            res.add(new Interval(left, right));
            idx++;
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> test = new ArrayList<>();
        test.add(new Interval(10, 30));
        test.add(new Interval(20, 60));
        test.add(new Interval(80, 100));
        test.add(new Interval(150, 180));
        ArrayList<Interval> res = new ArrayList<>();
        res = merge(test);
        for (Interval interval : res) {
            System.out.println(interval.start + " " + interval.end);
        }

    }

}
