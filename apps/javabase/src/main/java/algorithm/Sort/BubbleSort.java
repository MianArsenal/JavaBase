package algorithm.Sort;

/**
 * Created by MIHE on 11/19/2018.
 */
public class BubbleSort<E extends Comparable<E>> implements Sort<E>{
  private static BubbleSort ourInstance = new BubbleSort();

  public static BubbleSort getInstance() {
    return ourInstance;
  }

  private BubbleSort() {
  }

  @Override
  public void sort(E[] array) {
    if(array == null || array.length < 2) {
      return;
    }
    for(int i = 0; i < array.length - 1; i ++) {
      for(int j = 0; j < array.length - 1 - i; j++) {
        if(array[j].compareTo(array[j + 1]) > 0) {
          E temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }
}
