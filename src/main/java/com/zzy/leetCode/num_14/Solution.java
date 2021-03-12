package com.zzy.leetCode.num_14;

/**
 * @author 曾昭阳
 * @date 2020/7/11 15:35
 * <p>
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"aa", "a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String common_prefix = "";
        String temp_prefix;
        if (strs.length > 0) {
            for (int i = strs.length - 1; i > 0; i--) {
                if (strs[i].length() < strs[i - 1].length()) {
                    String temp = strs[i];
                    strs[i] = strs[i - 1];
                    strs[i - 1] = temp;
                }
            }
            for (int i = 0; i < strs[0].length(); i++) {
                temp_prefix = strs[0].substring(0, i + 1);
                for (int j = 1; j < strs.length; j++) {
                    if (!strs[j].substring(0, i + 1).equals(temp_prefix)) {
                        return common_prefix;
                    }
                }
                common_prefix = temp_prefix;
            }
        }
        return common_prefix;
    }

}
