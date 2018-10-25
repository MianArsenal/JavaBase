package datastructure.list;

/**
 * Created by MIHE on 10/25/2018.
 */
public class SimpleStack<E> {

  private SimpleNode<E> first;
  private SimpleNode<E> last;
  private int size;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E peek() {
    return first == null ? null : first.value;
  }

  public void push(E e) {
    if (first == null) {
      first = new SimpleNode<>(null, null, e);
      last = first;
      size = 1;
      return;
    }
    SimpleNode<E> newNode = new SimpleNode<>(null, last, e);
    first.perv = newNode;
    first = newNode;
    size++;
  }

  public E pop() {
    if (first == null) {
      return null;
    }
    SimpleNode<E> tempNode = first;
    if (first.next == null) {
      first = null;
      last = null;
    } else {
      first = first.next;
      first.perv = null;
    }
    size--;
    return tempNode.value;
  }

  private class SimpleNode<E> {

    private SimpleNode<E> perv;
    private SimpleNode<E> next;
    private E value;

    public SimpleNode(SimpleNode<E> perv, SimpleNode<E> next, E value) {
      this.perv = perv;
      this.next = next;
      this.value = value;
    }
  }

}
