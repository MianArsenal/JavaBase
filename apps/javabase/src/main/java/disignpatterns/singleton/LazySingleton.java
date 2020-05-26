package disignpatterns.singleton;

/**
 * Created by MIHE on 3/15/2019.
 * 懒汉模式，存在线程安全问题
 */
public class LazySingleton {
  private static LazySingleton ourInstance;

  public static LazySingleton getInstance() {
    if(null == ourInstance) {
      ourInstance = new LazySingleton();
    }
    return ourInstance;
  }

  private LazySingleton() {
  }
}
