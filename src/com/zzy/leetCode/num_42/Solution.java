package com.zzy.leetCode.num_42;

/**
 * @author 曾昭阳
 * @date 2020/7/11 10:54
 * <p>
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * <a>https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png</a>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int S = 0;
        int left_max = 0;
        int right_max = 0;
        for (int i = 0; i < height.length; i++) {
            left_max = Math.max(left_max, height[i]);
            right_max = Math.max(right_max, height[height.length - i - 1]);
            S += left_max;
            S += right_max;
            S -= height[i];
        }
        S = S - left_max * height.length;
        return S;
    }
}
