package datastructure;

/**
 * Created by MIHE on 11/2/2018.
 */
public class SimplePriorityQueue<E extends Comparable<E>> {
  private SimpleNode<E> head;
  private SimpleNode<E> tail;
  private int size;

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  public void push(E e) {
    if (size == 0) {
      head = new SimpleNode(null, null, e);
      tail = head;
      size++;
      return;
    }
    SimpleNode<E> temp = head;
    boolean needContinue = true;
    while (needContinue) {
      if (temp.value.compareTo(e) >= 0) {
        temp = temp.next;
        if (temp == null) {
          SimpleNode<E> newNode = new SimpleNode(tail, null, e);
          tail.next = newNode;
          tail = newNode;
          needContinue = false;
        }
      } else {
        SimpleNode<E> newNode = new SimpleNode(temp.pre, temp, e);
        if (temp.pre != null) {
          temp.pre.next = newNode;
        } else {
          head = newNode;
        }
        temp.pre = newNode;
        needContinue = false;
      }
    }
    size++;
  }

  public E pop() {
    if (size == 0) {
      throw new ArrayIndexOutOfBoundsException(-1);
    }
    SimpleNode<E> temp = head;
    if (size == 1) {
      head = null;
      tail = null;
    } else {
      head.next.pre = null;
      head = head.next;
    }
    size--;
    return temp.value;
  }

  private class SimpleNode<E> {
    private SimpleNode<E> pre;
    private SimpleNode<E> next;
    private E value;

    public SimpleNode(SimpleNode pre, SimpleNode next, E value) {
      this.pre = pre;
      this.next = next;
      this.value = value;
    }
  }
}
