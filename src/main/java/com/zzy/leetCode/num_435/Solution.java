package com.zzy.leetCode.num_435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 3}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        } else {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int end = intervals[0][1];
            int count = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < end) {
                    end = Math.min(end, intervals[i][1]);
                    count++;
                } else {
                    end = intervals[i][1];
                }
            }
            return count;
        }
    }
}
