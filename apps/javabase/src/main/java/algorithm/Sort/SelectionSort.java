package algorithm.Sort;

/**
 * Created by MIHE on 11/13/2018.
 */
public class SelectionSort<E extends Comparable<E>> implements Sort<E> {
  private static SelectionSort ourInstance = new SelectionSort();

  public static SelectionSort getInstance() {
    return ourInstance;
  }

  @Override
  public void sort(E[] array) {
    if (null == array || array.length < 2) {
      return;
    }
    for (int i = 0; i < array.length - 1; i++) {
      int max = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[max].compareTo(array[j]) < 0) {
          max = j;
        }
      }
      if (max != i) {
        E temp = array[i];
        array[i] = array[max];
        array[max] = temp;
      }
    }
  }
}
