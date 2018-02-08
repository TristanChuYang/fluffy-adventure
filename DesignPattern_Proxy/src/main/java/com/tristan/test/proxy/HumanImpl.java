package com.tristan.test.proxy;

//实现接口的被代理类，他只专注于自己的业务，其他的业务需要proxy帮他去做
public class HumanImpl implements Human {

    public void eat(String food) {
        System.out.println("被代理类调用：eat______________" + food);
    }
}
