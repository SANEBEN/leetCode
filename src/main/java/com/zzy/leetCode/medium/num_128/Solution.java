package com.zzy.leetCode.medium.num_128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2022/2/8 16:27
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> records = new HashSet<>();
        for (int num : nums) {
            records.add(num);
        }
        int max = 0;
        for (Integer record : records) {
            int tmp = record;
            int count = 1;
            while (records.contains(tmp + 1)) {
                count++;
                tmp++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
