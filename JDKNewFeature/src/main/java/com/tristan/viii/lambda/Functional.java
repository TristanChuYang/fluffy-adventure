package com.tristan.viii.lambda;

//函数接口-指的是，只有一个函数的接口，只有这样的接口可以转换为Lambda表达式
//可以使用如下注解来定义函数接口
@FunctionalInterface
public interface Functional {

    void method();

    //有了注解后，只允许有一个函数方法，否则会报错
    //void method2();

    //默认方法和静态方法不会破坏@FunctionalInterface注解
    default void defaultMethod() {

    }

    static void staticMethod() {

    }

}
