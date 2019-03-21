package disignpatterns.abstractfactory;

/**
 * Created by MIHE on 3/19/2019.
 * 抽象工厂类
 * 相对于工厂方法最大的区别在于抽象工厂生产的产品是由多个子产品组装而成的
 */
public abstract class AbstractFactory {
  public abstract ProductA createProductA();
  public abstract ProductB createProductB();
}
