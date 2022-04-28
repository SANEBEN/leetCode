package com.zzy.leetCode.interview.num_1;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2022/4/12 15:53
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > target) {
                continue;
            }
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] == tmp) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

}
