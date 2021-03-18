package com.zzy.leetCode.medium.num_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/12 15:47
 * <p>
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        backtrack(result, "", 3, 3);
        return result;
    }

    public void backtrack(List<String> result, String tmp, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(tmp);
            return;
        }
        if (left == right) {
            backtrack(result, tmp + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                backtrack(result, tmp + "(", left - 1, right);
            }
            backtrack(result, tmp + ")", left, right - 1);
        }
    }
}
