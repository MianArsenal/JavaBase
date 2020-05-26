package disignpatterns.factorymethod;

/**
 * Created by MIHE on 3/18/2019.
 * 工厂实现类-BusFactory
 */
public class BusFactory implements CarFactory {
  @Override
  public Car createCar() {
    return new Bus();
  }
}
