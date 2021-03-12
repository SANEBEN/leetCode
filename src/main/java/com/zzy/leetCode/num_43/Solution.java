package com.zzy.leetCode.num_43;

import java.util.Arrays;

/**
 * @author 曾昭阳
 * @date 2020/7/11 11:07
 *
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("12", "41"));
    }

    public String multiply(String num1, String num2) {

        //TODO 没考虑到所有情况，想好接着写
        char[] numbers_long = num1.toCharArray();
        char[] numbers_short = num2.toCharArray();
        int carry = 0;//进位
        int remainder;//余数
        if (numbers_long.length < numbers_short.length) {
            char[] temp = numbers_long;
            numbers_long = numbers_short;
            numbers_short = temp;
        }
        char[] result = new char[numbers_long.length + 1];
        Arrays.fill(result, '0');
        for (int i = numbers_short.length - 1; i >= 0; i--) {
            for (int j = numbers_long.length - 1; j >= 0; j--) {
                int temp = Integer.parseInt(String.valueOf(numbers_short[i])) * Integer.parseInt(String.valueOf(numbers_long[j]));
                remainder = temp % 10;
                result[j + 1] = (char) (remainder + carry + result[j + 1]);
                carry = temp / 10;
            }
        }
        result[0] = (char) (carry + result[0]);
        return new String(result);
    }
}
