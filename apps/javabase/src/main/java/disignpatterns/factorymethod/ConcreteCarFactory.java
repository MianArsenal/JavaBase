package disignpatterns.factorymethod;

/**
 * Created by MIHE on 3/18/2019.
 * 具体工厂实现类-反射的方式实现
 */
public class ConcreteCarFactory implements CarFactoryV2 {
  @Override
  public <T extends Car> T createCar(Class<T> c) {
    Car car = null;
    try {
      car = c.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return (T) car;
  }
}
