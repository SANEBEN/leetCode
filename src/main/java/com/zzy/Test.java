package com.zzy;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/15 9:23
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //00dac3c83ab52d3edaf329800ffdf332
        String md5 = DigestUtils.md5Hex(new FileInputStream("C:\\Users\\zhaoyang.zeng\\Desktop\\新建文本文档.txt"));
        System.out.println(md5);
    }
}
