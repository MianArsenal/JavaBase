package disignpatterns.factorymethod.Singleton;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by MIHE on 3/18/2019.
 * 单例工厂类V2-传入需要创建的单例类，创建对应的单例
 * 可以生产不同产品的单例工厂类
 */
public class SingletonFactoryV2 {

  private static Map<Class, Object> singletonsMap = new ConcurrentHashMap<>();

  public static <T extends Singleton> T getSingleton(Class<T> c) {
    Object singleton = singletonsMap.get(c);
    if(singleton == null) {
      try {
        Constructor constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        singleton = constructor.newInstance();
        singletonsMap.put(c, singleton);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return (T) singleton;
  }
}
