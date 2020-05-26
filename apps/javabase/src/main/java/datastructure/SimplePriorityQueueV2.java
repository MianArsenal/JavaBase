package datastructure;

import com.sun.xml.internal.bind.util.Which;

import java.util.Arrays;

/**
 * Created by MIHE on 11/9/2018.
 */
public class SimplePriorityQueueV2<E extends Comparable<E>> {

  private static final int DEFAULT_SIZE = 100;

  private E[] data;
  private int size;

  public SimplePriorityQueueV2() {
    data = (E[]) new Comparable[DEFAULT_SIZE];
  }

  public int size() {
    return this.size;
  }

  public E getMax() {
    if (this.size == 0) {
      throw new IllegalArgumentException("can't get value of empty queue");
    }
    return data[0];
  }

  public void insert(E e) {
    if (size == data.length) {
      enlargeDataArraySize();
    }
    data[size] = e;
    swim(size);
    size++;
  }

  private int getParentIndex(int i) {
    return (i - 1) / 2;
  }

  private void swim(int i) {
    while (i > 0 && getParentIndex(i) < size) {
      if (data[i].compareTo(data[getParentIndex(i)]) > 0) {
        exchange(i, getParentIndex(i));
        i = getParentIndex(i);
      } else {
        break;
      }
    }
  }

  private void exchange(int currentIndex, int parentIndex) {
    E temp = data[currentIndex];
    data[currentIndex] = data[parentIndex];
    data[parentIndex] = temp;
  }

  private void enlargeDataArraySize() {
    if (Integer.MAX_VALUE / 2 < data.length) {
      throw new ArrayIndexOutOfBoundsException("The queue is out of its max size.");
    }
    data = Arrays.copyOf(data, data.length * 2);
  }

  public E delete() {
    if (size == 0) {
      throw new ArrayIndexOutOfBoundsException("Not exist value to delete now.");
    }
    E temp = data[0];
    exchange(0, size - 1);
    data[size - 1] = null;
    size--;
    sink(0);
    return temp;
  }

  private void sink(int i) {
    while (i >= 0 && i < size) {
      int temp = getMaxValueChildIndex(i);
      if (i == temp || temp == -1) {
        return;
      }
      exchange(i, temp);
      i = temp;
    }
  }

  private int getMaxValueChildIndex(int i) {
    int left = (i + 1) * 2 - 1;
    int right = left + 1;
    if (left > size - 1) {
      return i;
    }
    if (right > size - 1) {
      return data[i].compareTo(data[left]) > 0 ? -1 : left;
    }
    return data[left].compareTo(data[right]) > 0 ? left : right;
  }
}
