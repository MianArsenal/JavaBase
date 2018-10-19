package datastructure.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by MIHE on 10/17/2018.
 */
public class SimpleArrayList<E> implements Collection<E> {

  private static final int DEFAULT_SIZE = 10;
  private Object[] elements;
  private int size;

  public SimpleArrayList() {
    this(DEFAULT_SIZE);
  }

  public SimpleArrayList(int size) {
    super();
    if (size < 0) {
      throw new IllegalArgumentException("Illegal Size: " + size);
    }
    elements = new Object[size];
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean contains(Object o) {
    if (isEmpty()) {
      return false;
    }
    for (Object element : elements) {
      if (element.equals(o)) {
        return true;
      }
    }
    return false;
  }

  public E get(int index){
    if(index >= size){
      throw new ArrayIndexOutOfBoundsException(index);
    }
    return (E) elements[index];
  }

  @Override
  public Iterator<E> iterator() {
    return new SimpleIterator(0);
  }

  @Override
  public Object[] toArray() {
    return elements;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return a;
  }

  @Override
  public boolean add(E e) {
    if (size == Integer.MAX_VALUE) {
      throw new ArrayIndexOutOfBoundsException(size);
    }
    if (elements.length < size + 1) {
      elements = Arrays.copyOf(elements, growCapacity());
    }
    elements[size] = e;
    size++;
    return true;
  }

  private int growCapacity() {
    int currentLength = elements.length;
    if (currentLength > (Integer.MAX_VALUE >> 1)) {
      return Integer.MAX_VALUE;
    }
    return currentLength * 2;
  }

  @Override
  public boolean remove(Object o) {
    Object[] newElements = new Object[elements.length];
    int j = 0;
    for (int i = 0; i < size; i++) {
      if (elements[i] != o) {
        newElements[j] = elements[i];
        j++;
      }
    }
    elements = newElements;
    size = j;
    return true;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    if (null == c) {
      return true;
    }
    for (Iterator itr = c.iterator(); itr.hasNext(); ) {
      int i = 0;
      Object value = itr.next();
      for (Object element : elements) {
        if (value == element) {
          break;
        }
        i++;
        if (i == elements.length) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    if (null == c) {
      return true;
    }
    for (Iterator itr = c.iterator(); itr.hasNext(); ) {
      add((E) itr.next());
    }
    return true;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    if (null == c) {
      return true;
    }
    for (Iterator itr = c.iterator(); itr.hasNext(); ) {
      remove(itr.next());
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    if (null == c) {
      elements = new Object[elements.length];
      size = 0;
      return true;
    }
    Object[] newElements = new Object[elements.length];
    int i = 0;
    for (Object element : elements) {
      for (Iterator itr = c.iterator(); itr.hasNext(); ) {
        if (element == itr.next()) {
          newElements[i] = element;
          i++;
        }
      }
    }
    elements = newElements;
    size = i;
    return true;
  }

  @Override
  public void clear() {
    elements = new Object[elements.length];
    size = 0;
  }

  private class SimpleIterator implements Iterator<E> {

    private int cursor;

    public SimpleIterator() {
      super();
    }

    public SimpleIterator(int index) {
      super();
      cursor = index;
    }

    @Override
    public boolean hasNext() {
      return size > cursor;
    }

    @Override
    public E next() {
      if (size < cursor) {
        throw new ArrayIndexOutOfBoundsException(cursor);
      }
      return (E) elements[cursor++];
    }

    @Override
    public void remove() {
      for (int i = cursor; i < size - 1; i++) {
        elements[i] = elements[i + 1];
      }
      elements[size - 1] = null;
      size--;
    }

    @Override
    public void forEachRemaining(Consumer action) {
    }
  }
}
