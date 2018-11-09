package datastructure;

/**
 * Created by MIHE on 11/2/2018.
 */
public class SimplePriorityQueue {
  private SimpleNode head;
  private SimpleNode tail;
  private int size;

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  public void push(int e) {
    if (size == 0) {
      head = new SimpleNode(null, null, e);
      tail = head;
      size++;
      return;
    }
    SimpleNode temp = head;
    boolean needContinue = true;
    while (needContinue) {
      if (temp.value >= e) {
        temp = temp.next;
        if (temp == null) {
          SimpleNode newNode = new SimpleNode(tail, null, e);
          tail.next = newNode;
          tail = newNode;
          needContinue = false;
        }
      } else {
        SimpleNode newNode = new SimpleNode(temp.pre, temp, e);
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

  public int pop() {
    if (size == 0) {
      throw new ArrayIndexOutOfBoundsException(-1);
    }
    SimpleNode temp = head;
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

  private class SimpleNode {
    private SimpleNode pre;
    private SimpleNode next;
    private int value;

    public SimpleNode(SimpleNode pre, SimpleNode next, int value) {
      this.pre = pre;
      this.next = next;
      this.value = value;
    }
  }
}
