package disignpatterns.factorymethod.SimpleFactory;

import disignpatterns.factorymethod.Car;

/**
 * Created by MIHE on 3/18/2019.
 * 简单工厂模式/静态工厂模式-没有工厂接口，且生产产品的方法为静态方法
 * 简化了结构，但不利于工厂的扩展
 */
public class SimpleFactory {
  public static <T extends Car> T createCar(Class<T> c) {
    Car car = null;
    try {
      car = c.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return (T) car;
  }
}
