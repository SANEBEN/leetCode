package com.zzy.leetCode.num_49;

import java.util.*;

/**
 * @author 曾昭阳
 * @date 2020/7/15 17:02
 * <p>
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Solution {

    public static int[] table = new int[]{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
    };

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Double, List<String>> record = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            double hashcode = 1;
            for (char c : chars) {
                hashcode *= table[(int) c - 97];
            }
            if (!record.containsKey(hashcode)) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                record.put(hashcode, temp);
            } else {
                record.get(hashcode).add(str);
            }
        }
        List<List<String>> result = new ArrayList<>();
        record.forEach((key, value) -> result.add(value));
        return result;
    }
}
