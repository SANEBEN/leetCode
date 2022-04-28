package com.zzy.huawei.num_3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private final LinkedHashMap<String, Integer> container = new LinkedHashMap<>();

    public Solution() {
        container.put("2", 4);
        container.put("3", 4);
        container.put("4", 4);
        container.put("5", 4);
        container.put("6", 4);
        container.put("7", 4);
        container.put("8", 4);
        container.put("9", 4);
        container.put("10", 4);
        container.put("J", 4);
        container.put("Q", 4);
        container.put("K", 4);
        container.put("A", 4);
        container.put("B", 1);
        container.put("C", 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mine = scanner.nextLine();
        String exclude = scanner.nextLine();
        System.out.println(new Solution().solution(mine.split("-"), exclude.split("-")));
    }

    private String solution(String[] mine, String[] exclude) {
        String result = "NO-CHAIN";
        for (String s : mine) {
            if (container.containsKey(s)) {
                container.put(s, container.get(s) - 1);
            }
        }
        for (String s : exclude) {
            if (container.containsKey(s)) {
                container.put(s, container.get(s) - 1);
            }
        }
        int[] record = new int[12];
        int index = 0;
        Set<Map.Entry<String, Integer>> entries = container.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (!entry.getKey().equals("2") && !entry.getKey().equals("B") && !entry.getKey().equals("C")) {
                record[index] = entry.getValue();
                index++;
            }
        }
        int left = 0, right = 0;
        String[] mark = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < record.length; i++) {
            if (record[i] > 0) {
                int tmp_right = i;
                while (tmp_right + 1 < record.length && record[tmp_right + 1] > 0) {
                    tmp_right++;
                }
                if ((tmp_right - i) > (right - left)) {
                    right = tmp_right;
                    left = i;
                }
                i = tmp_right;
            }
        }
        if ((right - left + 1) >= 5) {
            StringBuilder builder = new StringBuilder();
            for (int j = left; j <= right; j++) {
                if (j == right) {
                    builder.append(mark[j]);
                } else {
                    builder.append(mark[j]).append("-");
                }
            }
            result = builder.toString();
        }
        return result;
    }
}
