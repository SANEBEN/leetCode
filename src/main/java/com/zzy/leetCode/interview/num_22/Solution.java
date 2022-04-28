package com.zzy.leetCode.interview.num_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2022/4/13 14:49
 * 
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 * 
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
public class Solution {
    ArrayList<ArrayList<String>> cache = new ArrayList<>();

    public List<String> generate(int n) {
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generate(c)) {
                    for (String right : generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache.add(n, ans);
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }
}
