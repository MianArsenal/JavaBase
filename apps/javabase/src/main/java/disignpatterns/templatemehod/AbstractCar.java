package disignpatterns.templatemehod;

/**
 * Created by MIHE on 3/19/2019.
 * 模板类
 * 基本方法为protected
 * 模板方法设置为final, 避免被子类重写
 */
public abstract class AbstractCar {
  protected abstract void start();
  protected abstract void shift();
  protected abstract void stop();
  public final void run() {
    start();
    shift();
    stop();
  }
}
