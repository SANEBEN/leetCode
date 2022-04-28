package com.zzy.bank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    Map<Integer, Set<String>> record = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution().validNum(1));
    }

    public int validNum(int N) {
        if (N == 1) {
            return 2;
        } else {
            int left, right = 2, result = 3;
            for (int i = 2; i < N; i++) {
                left = right;
                right = result;
                result = left + right;
            }
            return result;
        }
    }

    public Set<String> backtrack(int n) {
        Set<String> result = new HashSet<>();
        if (record.containsKey(n)) {
            return record.get(n);
        }
        if (n == 1) {
            result.add("C");
            result.add("M");
        } else {
            Set<String> pre = backtrack(n - 1);
            for (String s : pre) {
                result.add("M" + s);
                result.add(s + "M");
                if (s.charAt(0) == 'M') {
                    result.add("C" + s);
                }
                if (s.charAt(s.length() - 1) == 'M') {
                    result.add(s + "C");
                }
            }
        }
        record.put(n, result);
        return result;
    }
}
