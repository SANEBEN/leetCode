package com.zzy.huawei.num_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> result = new Solution().solution(num);
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("Result:" + result.size());
    }

    private List<String> solution(int num) {
        int i, j, start;
        StringBuilder tmp;
        List<String> result = new ArrayList<>();
        result.add(num + "=" + num);
        for (i = 2; i < Math.sqrt(num) * 2; i++) {
            if (((num - i * (i - 1) / 2) % i) == 0) {
                start = (num - i * (i - 1) / 2) / i;
                tmp = new StringBuilder();
                tmp.append(num).append("=");
                if (start > 0) {
                    for (j = 0; j < i; j++) {
                        if (j == i - 1) {
                            tmp.append(start + j);
                        } else {
                            tmp.append(start + j).append("+");
                        }
                    }
                    result.add(tmp.toString());
                }
            }
        }
        return result;
    }
}
