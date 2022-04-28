package com.zzy.leetCode.interview.num_3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2022/4/12 15:56
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> record = new HashSet<>();
        int n = s.length();
        int right = -1;
        int result = 0;
        for (int left = 0; left < n; left++) {
            if (left != 0) {
                record.remove(s.charAt(left - 1));
            }
            while (right + 1 < n && !record.contains(s.charAt(right + 1))) {
                record.add(s.charAt(right + 1));
                right++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
