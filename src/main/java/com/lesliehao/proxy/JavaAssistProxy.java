package com.lesliehao.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/6/7下午7:50
 */
public class JavaAssistProxy {

    @Test
    public void testJDKProxy(){
        ObjectJDK o = (ObjectJDK) Proxy.newProxyInstance(ObjectJDK.class.getClassLoader(),
                ObjectJDK.class.getInterfaces(),
                new ObjectJDKHandler());
        o.say();
    }
}
