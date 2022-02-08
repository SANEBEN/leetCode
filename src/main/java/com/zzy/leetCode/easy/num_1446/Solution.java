package com.zzy.leetCode.easy.num_1446;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/12/1 15:27
 */
public class Solution {
    public static int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        char tmp = '.';
        for (char c : s.toCharArray()) {
            if (c == tmp) {
                count++;
            } else {
                tmp = c;
                if (count > max) {
                    max = count;
                } else {
                    count = 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("abbcccddddeeeeedcba"));
    }
}
