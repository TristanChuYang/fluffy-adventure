package com.tristan.viii.lambda;

//Lambda表达式应用于替换匿名内部类的代码
//匿名内部类的使用情况多用于某个方法需要的参数是某个接口的实现类，通过Lambda就可以直接把视线作为参数传入
public class FunctionalInterfaceTest {

    void testLambda(Functional functional) {
        functional.method();
    }

    public static void main(String[] args) {

        FunctionalInterfaceTest functionalInterfaceTest = new FunctionalInterfaceTest();
        //没有参数时，使用()
        functionalInterfaceTest.testLambda(() -> System.out.println("Test Lambda..."));

    }

}
