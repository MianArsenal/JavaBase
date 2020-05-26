package disignpatterns.factorymethod.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by MIHE on 3/18/2019.
 * 单例工厂类-单一产品的单例工厂类
 */
public class SingletonFactory {
  private static Singleton singleton;

  static {
    try {
      Class sc = Class.forName(Singleton.class.getName());
      Constructor constructor = sc.getDeclaredConstructor();
      constructor.setAccessible(true);//设置无参构造方法可访问
      singleton = (Singleton) constructor.newInstance();
    } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
      e.printStackTrace();
    }
  }

  public static Singleton getSingleton() {
    return singleton;
  }
}
