package com.tristan.test.dynamicproxy;

import com.tristan.test.proxy.Human;
import com.tristan.test.proxy.HumanImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//这是一个动态代理类
public class DynamicProxy implements InvocationHandler {

    private Object target;

    //需要一个构造方法去传入被代理类的实现
    public DynamicProxy(Object target) {

        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object result = method.invoke(target, args);
        after();
        return null;
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
        DynamicProxy dynamicProxy = new DynamicProxy(human);

        //动态拿到一个代理的实例
        Human humanProxy = (Human) Proxy.newProxyInstance(human.getClass().getClassLoader(),
                                human.getClass().getInterfaces(),
                                dynamicProxy);
        //直接通过动态代理去调用，接口改变了，代理类完全不需要改变了
        humanProxy.eat("fish");

    }
}
