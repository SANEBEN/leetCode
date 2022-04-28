package com.zzy.huawei.num_5;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("\\[", "");
        input = input.replaceAll("]", "");
        String[] split = input.split(",");
        List<int[]> params = new ArrayList<>();
        int[] tmp = new int[2];
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                tmp = new int[2];
                tmp[0] = Integer.parseInt(split[i]);
            } else {
                tmp[1] = Integer.parseInt(split[i]);
                params.add(tmp);
            }
        }
        System.out.println(new Solution().solution(params));
        Set
    }

    private int solution(List<int[]> books) {
        int[] dp = new int[books.size()];
        Arrays.fill(dp, 1);
        books.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int result = 1;
        for (int i = 1; i < books.size(); i++) {
            int[] book = books.get(i);
            for (int j = 0; j < i; j++) {
                int[] pre = books.get(j);
                if (book[0] > pre[0] && book[1] > pre[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
