package com.zzy.leetCode;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;


/**
 * @author 曾昭阳
 * @date 2019/9/17 20:54
 */
public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> record = new TreeMap<>();
        char[] characters = s.toCharArray();
        for (char character : characters) {
            if (record.containsKey(character)) {
                record.put(character, record.get(character) + 1);
            } else {
                record.put(character, 1);
            }
        }
        // 按值排序降序
        Map<Character, Integer> sorted = record
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
        StringBuilder result = new StringBuilder();
        sorted.forEach((c, number) -> {
            for (int i = 0; i < number; i++) {
                result.append(c);
            }
        });
        return result.toString();
    }

    public String dalao(String s) {
        if (s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int dic[] = new int[129];
        for (int i = 0; i < s.length(); i++) dic[s.charAt(i)]++;
        boolean zero = true;
        int max = 0, index = -1;
        while (true) {
            zero = true;
            for (int i = 0; i < 129; i++) {
                if (dic[i] == 0) continue;
                if (dic[i] > max) {
                    zero = false;
                    max = dic[i];
                    index = i;
                }
            }
            if (zero) break;
            dic[index] = 0;
            while (max != 0) {
                max--;
                sb.append((char) index);
            }
        }
        return sb.toString();
    }
}
