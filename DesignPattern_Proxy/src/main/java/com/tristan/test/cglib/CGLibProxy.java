package com.tristan.test.cglib;

import com.tristan.test.proxy.Human;
import com.tristan.test.proxy.HumanImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//使用CGLib实现动态代理，实现接口MethodInterceptor
public class CGLibProxy implements MethodInterceptor {

    //获得某个业务类的代理了，这个业务类可以没有实现任何接口
    public <T> T getProxy(Class<T> tClass) {

        return (T) Enhancer.create(tClass, this);
    }

    //需要代理的业务都要放到这个方法里
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("CGLib cook~~~~~~~~~~~~~~~~~~~~~");
    }

    private void after() {
        System.out.println("CGLib swap~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void main(String[] args) {

        CGLibProxy cgLibProxy = new CGLibProxy();
        Human humanProxy = cgLibProxy.getProxy(HumanImpl.class);
        humanProxy.eat("fish");

    }
}
