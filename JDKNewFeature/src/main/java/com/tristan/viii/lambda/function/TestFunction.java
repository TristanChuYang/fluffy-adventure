package com.tristan.viii.lambda.function;

import java.util.function.Function;

public class TestFunction {

    public static void main(String[] args) {

        //简单的,只有一行，可以理解为创建一个函数
        Function<Integer, String> function1 = (x) -> "test result: " + x;

        //标准的,有花括号, return, 分号.
        Function<String, String> function2 = (x) -> {
            return "after function1";
        };

        //可以直接调用函数，apply中实际就是函数中定义的入参
        System.out.println(function1.apply(6));
        System.out.println(function1.andThen(function2).apply(6));

    }
}
