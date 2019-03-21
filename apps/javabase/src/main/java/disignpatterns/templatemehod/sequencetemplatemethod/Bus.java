package disignpatterns.templatemehod.sequencetemplatemethod;

/**
 * Created by MIHE on 3/21/2019.
 */
public class Bus extends AbstractCar{
  @Override
  protected void start() {
    System.out.println("Bus start!");
  }

  @Override
  protected void shift() {
    System.out.println("Bus shift!");
  }

  @Override
  protected void stop() {
    System.out.println("Bus stop!");
  }
}
