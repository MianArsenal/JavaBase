package disignpatterns.proxy.dynamicproxy;

/**
 * Created by MIHE on 3/28/2019.
 * 场景类
 */
public class Client {

  public static void main(String[] args) {
    Subject subject = SubjectDynamicProxy.newProxyInstance(new RealSubject("zhangsan"));
    subject.doSomething();
  }

}
