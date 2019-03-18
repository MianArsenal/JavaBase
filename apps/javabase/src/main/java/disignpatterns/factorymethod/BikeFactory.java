package disignpatterns.factorymethod;

/**
 * Created by MIHE on 3/18/2019.
 * 工厂实现类-BikeFactory
 */
public class BikeFactory implements CarFactory {
  @Override
  public Car createCar() {
    return new Bike();
  }
}
