package disignpatterns.factorymethod;

/**
 * Created by MIHE on 3/18/2019.
 * 产品实现类-Bus
 */
public class Bus implements Car {
  @Override
  public void goToWork() {
    System.out.println("go to work by bus!");
  }
}
