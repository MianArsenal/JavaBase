package disignpatterns.templatemehod;

/**
 * Created by MIHE on 3/19/2019.
 */
public class Bus extends AbstractCar {
  @Override
  protected void start() {
    System.out.println("Start bus!");
  }

  @Override
  protected void shift() {
    System.out.println("Shift bus!");
  }

  @Override
  protected void stop() {
    System.out.println("Stop bus!");
  }
}
