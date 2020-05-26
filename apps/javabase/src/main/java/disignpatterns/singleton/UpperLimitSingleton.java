package disignpatterns.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by MIHE on 3/15/2019.
 * 单例模式扩展：上限单例模式，将“单例”的数量变成大于1的其它固定值
 */
public class UpperLimitSingleton {

  private static int maxNum = 3;
  private static List<UpperLimitSingleton> singletons = new ArrayList<>();
  static {
    for (int i = 0; i < maxNum; i++) {
      singletons.add(new UpperLimitSingleton(String.valueOf(i)));
    }
  }

  private String name;

  public static UpperLimitSingleton getInstance() {
    return singletons.get(new Random().nextInt(maxNum));
  }

  private UpperLimitSingleton(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
