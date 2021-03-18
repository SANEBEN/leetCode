package com.zzy;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/15 9:23
 */
public class Test {
    public static void main(String[] args) {
        String[] result = "test.zip".split("\\.");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
