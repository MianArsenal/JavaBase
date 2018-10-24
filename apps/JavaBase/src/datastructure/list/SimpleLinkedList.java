package datastructure.list;

import java.util.Collection;

/**
 * Created by MIHE on 10/19/2018.
 */
public class SimpleLinkedList<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  public SimpleLinkedList() {
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return 0 == size;
  }

  public boolean add(E value) {
    if (last == null) {
      first = new Node<>(null, value, null);
      last = first;
      size = 1;
    } else {
      Node<E> newNode = new Node<>(last, value, null);
      last.next = newNode;
      last = newNode;
      size++;
    }
    return true;
  }

  public boolean addAll(Collection<E> collection) {
    if (null == collection || collection.size() == 0) {
      return true;
    }
    for (E c :
        collection) {
      add(c);
    }
    return true;
  }

  public boolean remove(E e) {
    if (size == 0) {
      return true;
    }
    Node<E> currentNode = first;
    int total = size;
    while (total-- > 0) {
      currentNode = removeCurrentNode(currentNode, e);
    }
    return true;
  }

  private Node<E> removeCurrentNode(Node<E> currentNode, E e) {
    if (currentNode.value == e) {
      if (size == 1) {
        first = null;
        last = null;
      } else {
        if (currentNode.prev != null) {
          currentNode.prev.next = currentNode.next;
        }
        if (currentNode.next != null) {
          currentNode.next.prev = currentNode.prev;
        }
      }
      size--;
    }
    return currentNode.next;
  }

  public boolean removeAll(Collection<E> collection) {
    if (null == collection || collection.size() == 0) {
      return true;
    }
    for (E c :
        collection) {
      remove(c);
    }
    return true;
  }

  public E get(int i) {
    if (size == 0 || i < 0 || i > size) {
      return null;
    }
    boolean isFirstHalf = size / 2 >= i;
    Node<E> currentNode = isFirstHalf ? first : last;
    int cycleTimes = isFirstHalf ? i : size - i - 1;
    for (int temp = 0; temp <= cycleTimes; temp++) {
      if (temp == cycleTimes) {
        return currentNode.value;
      }
      currentNode = isFirstHalf ? currentNode.next : currentNode.prev;
    }
    return null;
  }

  public void clear() {
    first = null;
    last = null;
    size = 0;
  }

  public boolean contains(E e) {
    if (size == 0) {
      return false;
    }
    Node<E> currentNode = first;
    for (int i = 0; i < size; i++) {
      if (currentNode.value == e) {
        return true;
      }
      currentNode = currentNode.next;
    }
    return false;
  }

  public boolean containAll(Collection<E> collection) {
    if (null == collection || collection.size() == 0) {
      return true;
    }
    for (E c :
        collection) {
      if (!contains(c)) {
        return false;
      }
    }
    return true;
  }

  public int indexOf(E e) {
    if (size == 0) {
      return -1;
    }
    Node<E> currentNode = first;
    for(int i = 0; i < size; i++){
      if(currentNode.value == e){
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(E e){
    if(size == 0){
      return -1;
    }
    Node<E> currentNode = last;
    for(int i = size - 1; i >= 0; i--){
      if(currentNode.value == e){
        return i;
      }
      currentNode = currentNode.prev;
    }
    return -1;
  }

  private class Node<E> {

    private Node<E> prev;
    private E value;
    private Node<E> next;

    public Node(Node<E> prev, E value, Node<E> next) {
      this.prev = prev;
      this.value = value;
      this.next = next;
    }
  }

}
