package com.tristan.viii.lambda;

import java.util.Arrays;
import java.util.List;

//JDK8新支持的特性-Lambda表达式
public class LambdaTest {
    public static void main(String[] args) {

        //传统的方式
        List<String> list = Arrays.asList("a","b","c");
        for (String string : list) {
            System.out.println("list element: " + string);
        }

        //Lambda表达式写法
        Arrays.asList("a","b","c").forEach(e -> System.out.println("list element: " + e));

    }


}
