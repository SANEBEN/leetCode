package com.zzy.leetCode;

/**
 * @author 曾昭阳
 * @date 2019/9/18 22:25
 */

/* 693
给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 */
public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        String number = Integer.toBinaryString(n);
        char[] data = number.toCharArray();
        int i = data[0];
        for (int j = 1; j < data.length; j++) {
            if ((i ^ data[j]) == 0) {
                return false;
            } else {
                i = data[j];
            }
        }
        return true;
    }
}
