package com.tristan.viii.lambda.supplier;

import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {

        //Supplier传入什么，得到什么，可以用于构造方法
        //简写
        Supplier<String> supplier1 = () -> "Test supplier";
        System.out.println(supplier1.get());

        //标准格式
        Supplier<Integer> supplier2 = () -> {
            return 20;
        };
        System.out.println(supplier2.get() instanceof Integer);

    }
}
