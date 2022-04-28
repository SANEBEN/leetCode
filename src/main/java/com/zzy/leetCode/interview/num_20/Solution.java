package com.zzy.leetCode.interview.num_20;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2022/4/13 15:32
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("}}"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> check = new Stack<>();
        HashMap<Character, Character> record = new HashMap<>();
        record.put('(', ')');
        record.put('{', '}');
        record.put('[', ']');
        char[] array = s.toCharArray();
        for (char c : array) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    check.push(c);
                    break;
                default:
                    if (check.size() > 0) {
                        char top = check.pop();
                        if (record.get(top) != c) {
                            return false;
                        }
                    } else {
                        return false;
                    }
            }
        }
        return check.size() == 0;
    }
}
