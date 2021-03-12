package com.zzy.leetCode;

/**
 * @author 曾昭阳
 * @date 2019/9/15 10:50
 */
public class UglyNumber {

    public boolean isUgly(int num) {

        while (num % 5 == 0 && num != 0) {
            num /= 5;
        }
        while (num % 3 == 0 && num != 0) {
            num /= 3;
        }
        while (num % 2 == 0 && num != 0) {
            num >>= 1;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(0));
    }
}
