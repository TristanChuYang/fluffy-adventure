package com.tristan.test.proxy;

//代理类，与被代理类实现相同的接口
public class HumanProxy implements Human {

    //持有一个被代理类的引用
    private Human human;

    HumanProxy() {
        human = new HumanImpl();
    }

    //好处在于：如果要改变eat前后的逻辑，只需修改proxy，并不需要修改真正的实现类
    //如果有需要实现cook和swap的其他业务时，只需要在proxy中再实现一个接口，继续代理其他类即可
    //缺点：如果有需要复用eat时，就需要再实现接口
    //接口改变时，被代理类和proxy都需要改变
    public void eat(String food) {

        //除了调用被代理类做其业务外，在proxy中也要做一些其他的业务
        System.out.println("代理类调用~~~~~~~~~~~~~~");
        before();
        human.eat(food);
        after();

    }

    private void before() {
        System.out.println("cook~~~~~~~~~~~~~~~~~~~~~");
    }

    private void after() {
        System.out.println("swap~~~~~~~~~~~~~~~~~~~~~~");
    }
}
