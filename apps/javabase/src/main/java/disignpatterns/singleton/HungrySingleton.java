package disignpatterns.singleton;

/**
 * Created by MIHE on 3/15/2019.
 * 饿汉模式，线程安全
 */
public class HungrySingleton {
  private static HungrySingleton ourInstance = new HungrySingleton();

  public static HungrySingleton getInstance() {
    return ourInstance;
  }

  private HungrySingleton() {
  }
}
