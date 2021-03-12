package com.zzy.leetCode.num_17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曾昭阳
 * @date 2020/7/10 16:03
 * <p>
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <a>https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png</a>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {

    ArrayList<char[]> record = new ArrayList<>();

    public Solution() {
        record.add(new char[]{'a', 'b', 'c'});
        record.add(new char[]{'d', 'e', 'f'});
        record.add(new char[]{'g', 'h', 'i'});
        record.add(new char[]{'j', 'k', 'l'});
        record.add(new char[]{'m', 'n', 'o'});
        record.add(new char[]{'p', 'q', 'r', 's'});
        record.add(new char[]{'t', 'u', 'v'});
        record.add(new char[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        ArrayList<char[]> options = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            options.add(record.get(Integer.parseInt(digits.substring(i, i + 1)) - 2));
        }
        for (int i = 0; i < options.size(); i++) {
            if (i == 0) {
                for (char c : options.get(i)) {
                    result.add(String.valueOf(c));
                }
            } else {
                List<String> temp = new ArrayList<>();
                for (String s : result) {
                    for (char c : options.get(i)) {
                        temp.add(s + c);
                    }
                }
                result = temp;
            }
        }
        return result;
    }
}
