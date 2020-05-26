package disignpatterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by MIHE on 3/28/2019.
 * 代理的处理器类
 */
public class MyInvocationHandler implements InvocationHandler {

  private Subject subject;

  public MyInvocationHandler(Subject subject) {
    this.subject = subject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    IAdvice beforeAdvice = new BeforeAdvice();
    beforeAdvice.exec();
    Object result = method.invoke(this.subject, args);
    IAdvice afterAdvice = new AfterAdvice();
    afterAdvice.exec();
    return result;
  }
}
