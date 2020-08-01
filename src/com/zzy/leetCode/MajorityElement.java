package com.zzy.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 曾昭阳
 * @date 2019/9/18 21:11
 */
/*
169
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        int[] nums = {3, 2, 3};
        System.out.print(element.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int number : nums) {
            if (record.containsKey(number)) {
                record.put(number, record.get(number) + 1);
            } else {
                record.put(number, 1);
            }
        }
        int target = 0;
        for (Integer key : record.keySet()) {
            if (record.get(key) > nums.length / 2) {
                target = key;
            }
        }
        return target;
    }

    public int dalao(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
