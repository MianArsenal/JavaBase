package disignpatterns.proxy.dynamicproxy;

/**
 * Created by MIHE on 3/28/2019.
 * 代理的善后处理类
 */
public class AfterAdvice implements IAdvice {
  @Override
  public void exec() {
    System.out.println("AfterAdvice execute!");
  }
}
