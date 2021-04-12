package com.zzy.leetCode.hard.面试题17_21;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/4/2 9:52
 * <p>
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(nums));
    }

    public int trap(int[] height) {
        int length = height.length;
        if(length == 0){
            return 0;
        }
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int max = height[0];
        for (int i = 0; i < length; i++) {
            if (max > height[i]) {
                leftMax[i] = max - height[i];
            } else {
                max = height[i];
            }
        }
        max = height[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            if (max > height[i]) {
                rightMax[i] = max - height[i];
            } else {
                max = height[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]);
        }
        return sum;
    }
}
