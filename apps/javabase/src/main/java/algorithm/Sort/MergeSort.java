package algorithm.Sort;

/**
 * Created by MIHE on 11/21/2018.
 */
public class MergeSort<E extends Comparable<E>> implements Sort<E> {
  private static MergeSort ourInstance = new MergeSort();

  public static MergeSort getInstance() {
    return ourInstance;
  }

  private MergeSort() {
  }

  @Override
  public void sort(E[] array) {
    if (null == array || array.length < 2) {
      return;
    }
    E[] temp = (E[]) new Comparable[array.length];
    mergeSort(array, 0, array.length - 1, temp);
  }

  private void mergeSort(E[] array, int left, int right, E[] temp) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(array, left, mid, temp);
      mergeSort(array, mid + 1, right, temp);
      merge(array, left, mid, right, temp);
    }
  }

  private void merge(E[] array, int left, int mid, int right, E[] temp) {
    int i = left;
    int j = mid + 1;
    int t = 0;
    while (i <= mid && j <= right) {
      if (array[i].compareTo(array[j]) > 0) {
        temp[t++] = array[j++];
      } else {
        temp[t++] = array[i++];
      }
    }
    while (i <= mid) {
      temp[t++] = array[i++];
    }
    while ((j <= right)) {
      temp[t++] = array[j++];
    }
    t = 0;
    while (left <= right) {
      array[left++] = temp[t++];
    }
  }
}
