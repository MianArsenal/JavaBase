package disignpatterns.templatemehod;

/**
 * Created by MIHE on 3/19/2019.
 */
public class Client {

  public static void main(String[] args) {
    AbstractCar bike = new Bike();
    bike.run();
    AbstractCar bus = new Bus();
    bus.run();
  }

}
