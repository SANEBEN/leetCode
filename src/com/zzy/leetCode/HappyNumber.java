package com.zzy.leetCode;

import java.util.HashSet;

/**
 * @author 曾昭阳
 * @date 2019/9/14 19:35
 */
public class HappyNumber {

    private static int bitSquareSum(int n) {
        int temp = 0;
        while (n > 0) {
            temp += (int) Math.pow(n % 10, 2);
            System.out.print(temp + " ");
            n /= 10;
        }
        System.out.println();
        return temp;
    }

    /**
     * 尝试使用哈希表求解快乐数问题
     *
     * @param n 带判断的整数
     * @return 返回判断结果
     */
    public static boolean isHappyByHash(int n) {
        HashSet<Integer> record = new HashSet<>();
        record.add(1);
        while (true) {
            if (record.contains(n)) {
                return n == 1;
            } else {
                record.add(n);
                n = bitSquareSum(n);
            }
        }
    }

    public static boolean fastSlow(int n) {
        int slow = n;
        int fast = bitSquareSum(n);
        while (slow != fast) {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        }
        return slow == 1;
    }

    public static void main(String[] args) {
        boolean result = fastSlow(2);
        System.out.println("最终的结果是" + result);
    }
}
