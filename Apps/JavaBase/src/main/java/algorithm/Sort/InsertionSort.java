package algorithm.Sort;

/**
 * Created by MIHE on 11/19/2018.
 */
public class InsertionSort<E extends Comparable<E>> implements Sort<E> {
  private static InsertionSort ourInstance = new InsertionSort();

  public static InsertionSort getInstance() {
    return ourInstance;
  }

  private InsertionSort() {
  }

  @Override
  public void sort(E[] array) {
    if (null == array || array.length < 2) {
      return;
    }
    for (int i = 1; i < array.length; i++) {
      E temp = array[i];
      int j = i - 1;
      while (j > -1 && array[j].compareTo(temp) > 0) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = temp;
    }
  }
}
