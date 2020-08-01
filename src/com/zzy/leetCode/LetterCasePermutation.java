package com.zzy.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曾昭阳
 * @date 2019/9/24 20:19
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        List<String> record = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (char c : chars) {
            if (64 < c && c < 91) {
                characters.add(c);
                c += 32;
            } else if (96 < c && c < 123) {
                characters.add(c);
                c -= 32;
            }
            characters.add(c);
        }
        return record;
    }

}
