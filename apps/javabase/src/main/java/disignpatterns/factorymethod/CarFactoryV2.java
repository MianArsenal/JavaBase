package disignpatterns.factorymethod;

/**
 * Created by MIHE on 3/18/2019.
 * 工厂接口-需要传入产品类反射生产产品
 * 减少扩展的难度，即当有新的产品时，无需创建新的工厂类
 * 但是当每个工厂创建产品的方法不相同时，就不适合使用这种方法，仍需要创建不同的子类工厂
 */
public interface CarFactoryV2 {
  <T extends Car> T createCar(Class<T> c);
}
