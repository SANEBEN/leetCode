package com.zzy.leetCode.medium.num_50;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/12 16:44
 * <p>
 * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * <p>
 * -100.0 <x< 100.0
 * -231<= n <=231-1
 * -104 <= xn <= 104
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().quickMul(-2.0, 1));
    }

    double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    //快速幂和迭代
    public double quickMul(double x, long n) {
        double answer = 1.0;
        double tmp = x;
        while (n != 0) {
            if (n % 2 == 1) {
                answer *= tmp;
            }
            tmp *= tmp;
            n = n / 2;
        }
        return answer;
    }
}
