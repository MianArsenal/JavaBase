package disignpatterns.proxy.dynamicproxy;

/**
 * Created by MIHE on 3/28/2019.
 * 代理的预处理类
 */
public class BeforeAdvice implements IAdvice {
  @Override
  public void exec() {
    System.out.println("BeforeAdvice execute!");
  }
}
