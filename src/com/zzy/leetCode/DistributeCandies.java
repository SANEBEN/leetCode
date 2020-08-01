package com.zzy.leetCode;

/**
 * @author 曾昭阳
 * @date 2019/9/19 21:38
 */
public class DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        int[] records = new int[num_people];
        for (int i = 1; candies > 0; i++) {
            if (candies > i) {
                records[(i - 1) % num_people] += i;
                candies -= i;
            } else {
                records[(i - 1) % num_people] += candies;
                candies = 0;
            }
        }
        return records;
    }
}
