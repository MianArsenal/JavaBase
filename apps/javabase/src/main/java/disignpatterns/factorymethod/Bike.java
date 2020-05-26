package disignpatterns.factorymethod;

/**
 * Created by MIHE on 3/18/2019.
 * 产品实现类-Bike
 */
public class Bike implements Car {
  @Override
  public void goToWork() {
    System.out.println("go to work by bike!");
  }
}
