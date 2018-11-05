package datastructure;

/**
 * Created by MIHE on 11/5/2018.
 */
public class SimpleQueue<E> {

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public int size() {
    return size;
  }

  public void push(E e) {
    if (size == 0) {
      head = new Node<>(null, null, e);
      tail = head;
      size++;
      return;
    }
    Node<E> temp = new Node<>(tail, null, e);
    tail.next = temp;
    tail = temp;
    size++;
  }

  public E pop() {
    if (size == 0) {
      return null;
    }
    Node<E> temp = head;
    if (size == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.pre = null;
    }
    size--;
    return temp.value;
  }

  public void clear(){
    head = null;
    tail = null;
    size = 0;
  }

  private class Node<E> {
    private Node<E> pre;
    private Node<E> next;
    private E value;

    public Node(Node<E> pre, Node<E> next, E value) {
      this.pre = pre;
      this.next = next;
      this.value = value;
    }
  }
}
