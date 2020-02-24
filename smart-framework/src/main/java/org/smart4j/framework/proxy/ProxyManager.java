package org.smart4j.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 代理管理器，用来创建代理对象（切面类调用）
 * @since 2017-07-11.
 */
public class ProxyManager {

    /**
     * 创建代理
     * @param targetClass 目标类
     * @param proxyList 一组Proxy接口的实现
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final Class<T> targetClass, final List<Proxy> proxyList) {
        // 使用CGLib提供的Enhance#create方法来创建代理对象
        // 将intercept的参数传入ProxyChain的构造器中
        return (T) Enhancer.create(targetClass,
                (MethodInterceptor) (targetObj, method, objects, methodProxy) ->
                        new ProxyChain(targetClass, targetObj, method, methodProxy, objects, proxyList).doProxyChain());
    }
}
