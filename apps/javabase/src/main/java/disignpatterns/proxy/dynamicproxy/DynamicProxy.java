package disignpatterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by MIHE on 3/28/2019.
 * 动态代理类
 */
public class DynamicProxy {

  public static <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler handler) {
    return (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
  }

}
