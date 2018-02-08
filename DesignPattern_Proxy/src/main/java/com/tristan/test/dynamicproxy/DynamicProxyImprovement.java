package com.tristan.test.dynamicproxy;

import com.tristan.test.proxy.Human;
import com.tristan.test.proxy.HumanImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//根据DynamicProxy再优化
//优点：cook和swap可以任意被复用，method.invoke(target, args);可以是任意的接口实现和方法
//缺点：这种代理需要接口，如果一个类并没有实现任何接口，就有问题了
public class DynamicProxyImprovement implements InvocationHandler {

    //被代理类
    private Object target;

    //需要一个构造方法去传入被代理类的实现
    public DynamicProxyImprovement(Object target) {

        this.target = target;
    }

    //代理的逻辑要写到这里
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object result = method.invoke(target, args);
        after();
        return null;
    }

    //通过JDK提供的动态代理，直接拿到被代理类的代理
    public <T> T getProxy() {

        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    private void before() {
        System.out.println("dynamic cook~~~~~~~~~~~~~~~~~~~~~");
    }

    private void after() {
        System.out.println("dynamic swap~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void main(String[] args) {

        Human human = new HumanImpl();

        //创建动态代理类时传入被代理类
        DynamicProxyImprovement dynamicProxy = new DynamicProxyImprovement(human);

        //动态拿到一个代理的实例
        Human humanProxy = dynamicProxy.getProxy();
        //直接通过动态代理去调用，接口改变了，代理类完全不需要改变了
        humanProxy.eat("fish");

    }
}
