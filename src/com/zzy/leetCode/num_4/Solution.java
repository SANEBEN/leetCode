package com.zzy.leetCode.num_4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 曾昭阳
 * @date 2021/1/5 16:34
 * @email 473811301@qq.com
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4, 5};
        solution.findMedianSortedArrays(nums1, nums2);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //TODO 比看起来难  有时间再继续吧
        int i = 0, j = 0, num = 0;
        while (num < (nums1.length + nums2.length) / 2) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
            num++;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return Math.min(nums1[i], nums2[j]);
        } else {
            return 0;
        }
    }
}
