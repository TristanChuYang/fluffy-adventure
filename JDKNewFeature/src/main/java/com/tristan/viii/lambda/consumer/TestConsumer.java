package com.tristan.viii.lambda.consumer;

import java.util.function.Consumer;

public class TestConsumer {

    public static void main(String[] args) {

        Consumer<String> consumer1 = (x) -> System.out.print(x);
        Consumer<String> consumer2 = (x) -> {
            System.out.println(" after consumer 1");
        };
        consumer1.andThen(consumer2).accept("test consumer1");

    }

}
