package com.zzy.leetCode.interview.num_5;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2022/4/13 9:24
 *
 */
public class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        for (int i = 0; i < chars.length; i++) {
            int length1 = expandAroundCenter(s, i, i);
            int length2 = expandAroundCenter(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > right - left) {
                left = i - (length - 1) / 2;
                right = i + length / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
