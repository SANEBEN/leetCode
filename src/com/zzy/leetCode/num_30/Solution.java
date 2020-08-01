package com.zzy.leetCode.num_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 曾昭阳
 * @date 2020/7/12 16:19
 * <p>
 * 30. 串联所有单词的子串
 * <p>
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * 示例3：
 * <p>
 * s = "barfoofoobarthefoobarman"
 * words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 示例4：
 * <p>
 * s = "lingmindraboofooowingdingbarrwingmonkeypoundcake"
 * words = ["fooo","barr","wing","ding","wing"]
 * 输出：[13]
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("a", new String[]{"a"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        //TODO 越写越歪 emmmm 下次继续
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }else if(words.length == 1){
            if(words[0].equals(s)){
                result.add(0);
                return result;
            }
        }
        int unit_length = words[0].length();
        int length = words.length * words[0].length();
        int start = 0;
        int end = length - 1;
        if (!(s.length() < length)) {
            HashMap<String, Integer> record = new HashMap<>();
            for (String temp : words) {
                if (!record.containsKey(temp)) {
                    record.put(temp, 1);
                } else {
                    record.put(temp, record.get(temp) + 1);
                }
            }
            while (end <= s.length()) {
                int temp = start;
                HashMap<String, Integer> temp_record = new HashMap<>(record);
                while (temp != end) {
                    String check = s.substring(temp, temp + unit_length);
                    if (temp_record.containsKey(check)) {
                        if (temp_record.get(check) == 1) {
                            temp_record.remove(check);
                        } else {
                            temp_record.put(check, record.get(check) - 1);
                        }
                    } else {
                        break;
                    }
                    temp += unit_length;
                }
                if (temp_record.size() == 0) {
                    result.add(start);
                }
                start = start + 1;
                if ((s.length() - start) < length) {
                    break;
                } else {
                    end = start + length;
                }
            }
        }
        return result;
    }
}
