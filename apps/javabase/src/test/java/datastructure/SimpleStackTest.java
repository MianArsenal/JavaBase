package datastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MIHE on 10/26/2018.
 */
public class SimpleStackTest {
  private SimpleStack<String> simpleStack;

  @Before
  public void setUp() throws Exception {
    simpleStack = new SimpleStack<>();
  }

  @After
  public void tearDown() throws Exception {
    simpleStack = null;
  }

  @Test
  public void size() throws Exception {
    assertEquals(simpleStack.size(), 0);
  }

  @Test
  public void isEmpty() throws Exception {
    assertEquals(simpleStack.isEmpty(), true);
  }

  @Test
  public void peek() throws Exception {
    assertEquals(simpleStack.peek(), null);
  }

  @Test
  public void push() throws Exception {
    simpleStack.push("Str1");
    simpleStack.push("Str2");
    assertEquals(simpleStack.isEmpty(), false);
    assertEquals(simpleStack.size(), 2);
  }

  @Test
  public void pop() throws Exception {
    assertEquals(simpleStack.pop(), null);
    assertEquals(simpleStack.isEmpty(), true);
    assertEquals(simpleStack.size(), 0);
    simpleStack.push("Str1");
    simpleStack.push("Str2");
    assertEquals(simpleStack.pop(), "Str2");
    assertEquals(simpleStack.isEmpty(), false);
    assertEquals(simpleStack.size(), 1);
  }

}