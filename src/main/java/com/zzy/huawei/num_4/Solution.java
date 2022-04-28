package com.zzy.huawei.num_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private final List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int index = scanner.nextInt();
        System.out.println(new Solution().solution(number, index));
    }

    private String solution(int number, int index) {
        List<String> tmp = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            tmp.add(i + "");
        }
        backtrack(tmp, 0, tmp.size());
        List<Long> sort = new ArrayList<>();
        for (List<String> list : result) {
            StringBuilder builder = new StringBuilder();
            for (String s : list) {
                builder.append(s);
            }
            sort.add(Long.parseLong(builder.toString()));
        }
        Collections.sort(sort);
        return sort.get(index - 1).toString();
    }

    private void backtrack(List<String> tmp, int first, int last) {
        if (first == last - 1) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = first; i < last; i++) {
            Collections.swap(tmp, first, i);
            backtrack(tmp, first + 1, last);
            Collections.swap(tmp, first, i);
        }
    }
}
