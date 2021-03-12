package com.zzy.leetCode;

/**
 * @author 曾昭阳
 * @date 2019/9/15 10:17
 */
public class PrimeNumber {

    /**
     * 厄拉多塞筛法求解
     *
     * @param n 寻找从1-n内的所有质数个数
     * @return 返回质数的个数
     */
    public int countPrimes(int n) {
        int[] temp = new int[n];
        int result = 0;
        for (int i = 1; i < n; i++) {
            temp[i] = i;
        }
        for (int i = 2; i < n; i++) {
            if (temp[i] != 0) {
                for (int j = 2; j * i < n; j++) {
                    temp[j * i] = 0;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (temp[i] != 0) {
                result++;
            }
        }
        return result;//因为在创建数组的时候，数组的第零位为零，消除零的影响
    }

    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        System.out.println(primeNumber.countPrimes(10000));
    }
}
