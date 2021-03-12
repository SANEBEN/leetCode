package com.zzy.leetCode.num_3;

import java.util.HashSet;

/**
 * @author 曾昭阳
 * @date 2020/7/9 16:38
 * <p>
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Character> record = new HashSet<>();
        char temp;
        char[] symbols = s.toCharArray();
        while (end != symbols.length) {
            temp = symbols[end];
            if (!record.contains(temp)) {
                end += 1;
                if (max < (end - start)) {
                    max = end - start;
                }
                record.add(temp);
            } else {
                record.remove(symbols[start]);
                start += 1;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring_ASCII(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[256];
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }
}
