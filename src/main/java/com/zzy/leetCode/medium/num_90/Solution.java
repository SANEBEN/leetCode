package com.zzy.leetCode.medium.num_90;

import java.util.*;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/31 11:29
 */
public class Solution {

    List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(new Solution().subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return results;
    }

    public void backtrack(int[] nums, int startIndex, List<Integer> result) {
        results.add(result);
        Set<Integer> record = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!record.contains(nums[i])) {
                List<Integer> tmp = new ArrayList<>(result);
                tmp.add(nums[i]);
                record.add(nums[i]);
                backtrack(nums, i + 1, tmp);
            }
        }
    }
}
