package com.tristan.viii.lambda.predicate;

import java.util.function.Predicate;

public class TestPredicate {

    public static void main(String[] args) {

        //定义一个Predicate，用于判断
        Predicate<String> predicate = (x) -> x.length() > 0;
        System.out.println(predicate.test("String"));
    }
}
