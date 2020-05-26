package disignpatterns.factorymethod;

/**
 * Created by MIHE on 3/18/2019.
 * 场景类
 */
public class Client {
  public static void main(String[] args) {
    CarFactory bikeFactory = new BikeFactory();
    Car car0 = bikeFactory.createCar();
    car0.goToWork();

    CarFactory busFactory = new BusFactory();
    Car car1 = busFactory.createCar();
    car1.goToWork();

    CarFactoryV2 carFactoryV2 = new ConcreteCarFactory();
    Car car2 = carFactoryV2.createCar(Bike.class);
    car2.goToWork();
    Car car3 = carFactoryV2.createCar(Bus.class);
    car3.goToWork();
  }
}
