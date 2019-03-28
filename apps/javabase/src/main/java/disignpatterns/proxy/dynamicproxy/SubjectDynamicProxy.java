package disignpatterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;

/**
 * Created by MIHE on 3/28/2019.
 * 具体业务的动态代理类：对场景类和动态代理父类屏蔽一些它们无需关注的业务逻辑
 */
public class SubjectDynamicProxy extends DynamicProxy{

  public static <T> T newProxyInstance(Subject subject) {
    ClassLoader classLoader = subject.getClass().getClassLoader();
    Class<T>[] interfaces = (Class<T>[]) subject.getClass().getInterfaces();
    InvocationHandler handler = new MyInvocationHandler(subject);
    return newProxyInstance(classLoader, interfaces, handler);
  }

}
