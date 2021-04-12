package com.zzy.leetCode.medium.num_179;

import java.util.Arrays;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/4/12 17:27
 */
public class Solution {
    public static void main(String[] args) {

    }

    public String largestNumber(int[] nums) {
        Integer[] nums_1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_1[i] = nums[i];
        }
        Arrays.sort(nums_1, (o1, o2) -> {
            return 0;
        });
        return "";
    }
}
