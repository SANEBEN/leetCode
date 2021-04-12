package com.zzy.leetCode.medium.num_80;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/4/6 10:22
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        } else {
            int fast = 2, slow = 2;
            // 因为题目要求最多两个数相同，所以这么判断
            // 如果nums[slow - 2] == nums[fast]，代表已经有两个数相等，此时nums[fast]
            // 对应的数值不能放进结果之中。反之，如果nums[slow - 2] != nums[fast]，
            // 那么nums[fast]可以放进nums[slow]中，并且slow++，记录结果的长度。
            while (fast < length) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
