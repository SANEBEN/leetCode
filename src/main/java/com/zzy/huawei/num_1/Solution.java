package com.zzy.huawei.num_1;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        String[] array = tmp.split(" ");
        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }
        int target = scanner.nextInt();
        System.out.println(new Solution().solution(nums, target));
    }

    public int solution(int[] nums, int target) {
        int left, right, sum = 0, min = nums.length;
        for (int num : nums) {
            if (num < target) {
                sum++;
            }
        }
        if (sum == nums.length || sum == 0) {
            return 0;
        } else {
            left = 0;
            right = sum;
            while (right <= nums.length) {
                int tmp = 0;
                for (int i = left; i < right; i++) {
                    if (nums[i] >= target) {
                        tmp++;
                    }
                }
                min = Math.min(min, tmp);
                left++;
                right++;
            }
            return min;
        }
    }
}
