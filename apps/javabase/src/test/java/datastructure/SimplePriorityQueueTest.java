package datastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MIHE on 11/9/2018.
 */
public class SimplePriorityQueueTest {
  private SimplePriorityQueue simplePriorityQueue;

  @Before
  public void setUp() throws Exception {
    simplePriorityQueue = new SimplePriorityQueue();
  }

  @After
  public void tearDown() throws Exception {
    simplePriorityQueue = null;
  }

  @Test
  public void isEmpty() throws Exception {
    assertEquals(simplePriorityQueue.isEmpty(), true);
  }

  @Test
  public void size() throws Exception {
    assertEquals(simplePriorityQueue.size(), 0);
  }

  @Test
  public void push() throws Exception {
    simplePriorityQueue.push(1);
    simplePriorityQueue.push(3);
    simplePriorityQueue.push(2);
    assertEquals(simplePriorityQueue.size(), 3);
    assertEquals(simplePriorityQueue.isEmpty(), false);
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void pop() throws Exception {
    simplePriorityQueue.push(1);
    simplePriorityQueue.push(3);
    simplePriorityQueue.push(2);
    assertEquals(simplePriorityQueue.pop(), 3);
    assertEquals(simplePriorityQueue.size(), 2);
    assertEquals(simplePriorityQueue.isEmpty(), false);
    assertEquals(simplePriorityQueue.pop(), 2);
    assertEquals(simplePriorityQueue.size(), 1);
    assertEquals(simplePriorityQueue.isEmpty(), false);
    assertEquals(simplePriorityQueue.pop(), 1);
    assertEquals(simplePriorityQueue.size(), 0);
    assertEquals(simplePriorityQueue.isEmpty(), true);
    simplePriorityQueue.pop();
    assertEquals(simplePriorityQueue.size(), 0);
    assertEquals(simplePriorityQueue.isEmpty(), true);
  }

}