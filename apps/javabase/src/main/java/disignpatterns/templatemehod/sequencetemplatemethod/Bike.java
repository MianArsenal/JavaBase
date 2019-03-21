package disignpatterns.templatemehod.sequencetemplatemethod;

/**
 * Created by MIHE on 3/21/2019.
 */
public class Bike extends AbstractCar {
  @Override
  protected void start() {
    System.out.println("Bike start!");
  }

  @Override
  protected void shift() {
    System.out.println("Bike shift!");
  }

  @Override
  protected void stop() {
    System.out.println("Bike stop!");
  }
}
