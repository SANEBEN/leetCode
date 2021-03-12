package com.zzy.leetCode;

import java.util.HashMap;

/**
 * @author 曾昭阳
 * @date 2019/9/13 10:56
 */
public class first_twoSum {

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    private static int[] faster(int[] nums, int target){
        int[] index = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                index[0] = i;
                index[1] = hash.get(nums[i]);
                return index;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return index;
    }
}
