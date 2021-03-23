package com.zzy;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/15 9:23
 */
public class Test {
    public static void main(String[] args) {
        String tmp = "123.zip";
        int index = tmp.lastIndexOf(".");
        System.out.println(tmp.substring(index+1));
    }
}
