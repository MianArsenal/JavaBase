package datastructure;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MIHE on 11/5/2018.
 */
public class SimpleQueueTest {
  private SimpleQueue<String> simpleQueue;

  @Before
  public void setUp() throws Exception {
    simpleQueue = new SimpleQueue<>();
  }

  @After
  public void tearDown() throws Exception {
    simpleQueue = null;
  }

  @org.junit.Test
  public void size() throws Exception {
    assertEquals(simpleQueue.size(), 0);
  }

  @Test
  public void push() throws Exception {
    simpleQueue.push("Str1");
    simpleQueue.push("Str2");
    assertEquals(simpleQueue.size(), 2);
  }

  @Test
  public void pop() throws Exception {
    simpleQueue.push("Str1");
    simpleQueue.push("Str2");
    assertEquals(simpleQueue.pop(), "Str1");
    assertEquals(simpleQueue.size(), 1);
    assertEquals(simpleQueue.pop(), "Str2");
    assertEquals(simpleQueue.size(), 0);
    assertEquals(simpleQueue.pop(), null);
    assertEquals(simpleQueue.size(), 0);
  }

  @Test
  public void clear() throws Exception {
    simpleQueue.push("Str1");
    simpleQueue.push("Str2");
    simpleQueue.clear();
    assertEquals(simpleQueue.size(), 0);
  }

}