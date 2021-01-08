package com.zzy.leetCode.num_509;

/**
 * @author 曾昭阳
 * @date 2021/1/4 8:27
 * @email 473811301@qq.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(4));
    }

    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] records = new int[2];
        records[1] = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = records[1];
            records[1] = records[0] + records[1];
            records[0] = temp;
        }
        return records[1];
    }
}
