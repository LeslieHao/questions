package com.lesliehao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/6/7下午8:01
 */
public class ObjectJDKHandler implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(proxy);
        return null;
    }
}
