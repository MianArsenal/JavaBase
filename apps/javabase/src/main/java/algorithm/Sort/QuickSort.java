package algorithm.Sort;

/**
 * Created by MIHE on 11/26/2018.
 */
public class QuickSort<E extends Comparable<E>> implements Sort<E> {
  private static QuickSort ourInstance = new QuickSort();

  public static QuickSort getInstance() {
    return ourInstance;
  }

  private QuickSort() {
  }

  @Override
  public void sort(E[] array) {
    if (null == array || array.length < 2) {
      return;
    }
    quickSort(array, 0, array.length - 1);
  }

  private void quickSort(E[] array, int low, int high) {
    if (low >= high) {
      return;
    }
    int index = partition(array, low, high);
    quickSort(array, low, index - 1);
    quickSort(array, index + 1, high);
  }

  private int partition(E[] array, int low, int high) {
    E key = array[low];
    while (low < high) {
      while (array[high].compareTo(key) >= 0 && low < high) {
        high--;
      }
      array[low] = array[high];
      while (array[low].compareTo(key) <= 0 && low < high) {
        low++;
      }
      array[high] = array[low];
    }
    array[high] = key;
    return high;
  }
}
