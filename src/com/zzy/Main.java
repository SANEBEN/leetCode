package com.zzy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        char[] chars = "没人比我更懂java".toCharArray();
        int sum = 0;
        System.out.println("没人比我更懂java".getBytes(StandardCharsets.UTF_8).length);
    }


}


