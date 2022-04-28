package com.zzy.bank.num_2;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().extraNum("c12m23b3n4t56"));
    }


    public ArrayList<Integer> extraNum(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int sum = chars[i] - 48;
                while (i + 1 < chars.length && Character.isDigit(chars[++i])) {
                    sum = sum * 10 + chars[i] - 48;
                }
                result.add(sum);
            }
        }
        return result;
    }

}
