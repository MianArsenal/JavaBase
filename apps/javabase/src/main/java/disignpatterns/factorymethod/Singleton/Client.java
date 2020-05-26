package disignpatterns.factorymethod.Singleton;

/**
 * Created by MIHE on 3/18/2019.
 */
public class Client {

  public static void main(String[] args) {
    SingletonFactory.getSingleton().doSomething();
    SingletonFactoryV2.getSingleton(Singleton.class).doSomething();
  }
}
