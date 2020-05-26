package algorithm.Sort;

/**
 * Created by MIHE on 11/19/2018.
 */
public class ShellSort<E extends Comparable<E>> implements Sort<E> {
  private static ShellSort ourInstance = new ShellSort();

  public static ShellSort getInstance() {
    return ourInstance;
  }

  private ShellSort() {
  }

  @Override
  public void sort(E[] array) {
    if (null == array || array.length < 2) {
      return;
    }
    int t = array.length;
    while (true) {
      t = t / 2;
      for (int j = 0; j < t; j++) {
        for (int y = j + t; y < array.length; y++) {
          E temp = array[y];
          int x = y - t;
          while (x > -1 && array[x].compareTo(temp) > 0) {
            array[x + t] = array[x];
            x -= t;
          }
          array[x + t] = temp;
        }
      }
      if (t == 1) {
        break;
      }
    }
  }
}
