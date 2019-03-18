package disignpatterns.factorymethod.SimpleFactory;

import disignpatterns.factorymethod.Bike;
import disignpatterns.factorymethod.Bus;
import disignpatterns.factorymethod.Car;

/**
 * Created by MIHE on 3/18/2019.
 * 场景类
 */
public class Client {
  public static void main(String[] args) {
    Car bike = SimpleFactory.createCar(Bike.class);
    bike.goToWork();
    Car bus = SimpleFactory.createCar(Bus.class);
    bus.goToWork();
  }
}
