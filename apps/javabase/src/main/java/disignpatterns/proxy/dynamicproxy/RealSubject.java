package disignpatterns.proxy.dynamicproxy;

/**
 * Created by MIHE on 3/28/2019.
 * 真实主题类，被代理类
 */
public class RealSubject implements Subject {

  private String name;

  public RealSubject(String name) {
    this.name = name;
  }

  @Override
  public void doSomething() {
    System.out.println(name + " do something!");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
