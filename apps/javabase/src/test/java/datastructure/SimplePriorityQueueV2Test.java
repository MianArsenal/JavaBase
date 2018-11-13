package datastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MIHE on 11/12/2018.
 */
public class SimplePriorityQueueV2Test {
  private SimplePriorityQueueV2<String> simplePriorityQueueV2;

  @Before
  public void setUp() throws Exception {
    simplePriorityQueueV2 = new SimplePriorityQueueV2();
  }

  @After
  public void tearDown() throws Exception {
    simplePriorityQueueV2 = null;
  }

  @Test
  public void size() throws Exception {
    assertEquals(simplePriorityQueueV2.size(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getMax() throws Exception {
    simplePriorityQueueV2.getMax();
  }

  @Test
  public void insert() throws Exception {
    simplePriorityQueueV2.insert("Str3");
    simplePriorityQueueV2.insert("Str2");
    simplePriorityQueueV2.insert("Str4");
    simplePriorityQueueV2.insert("Str0");
    simplePriorityQueueV2.insert("Str6");
    simplePriorityQueueV2.insert("Str5");
    assertEquals(simplePriorityQueueV2.size(), 6);
    assertEquals(simplePriorityQueueV2.getMax(), "Str6");
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void delete() throws Exception {
    simplePriorityQueueV2.insert("Str3");
    simplePriorityQueueV2.insert("Str2");
    simplePriorityQueueV2.insert("Str4");
    simplePriorityQueueV2.insert("Str0");
    simplePriorityQueueV2.insert("Str6");
    simplePriorityQueueV2.insert("Str5");
    assertEquals(simplePriorityQueueV2.delete(), "Str6");
    assertEquals(simplePriorityQueueV2.size(), 5);
    assertEquals(simplePriorityQueueV2.delete(), "Str5");
    assertEquals(simplePriorityQueueV2.size(), 4);
    assertEquals(simplePriorityQueueV2.delete(), "Str4");
    assertEquals(simplePriorityQueueV2.size(), 3);
    assertEquals(simplePriorityQueueV2.delete(), "Str3");
    assertEquals(simplePriorityQueueV2.size(), 2);
    assertEquals(simplePriorityQueueV2.delete(), "Str2");
    assertEquals(simplePriorityQueueV2.size(), 1);
    assertEquals(simplePriorityQueueV2.delete(), "Str0");
    assertEquals(simplePriorityQueueV2.size(), 0);
    simplePriorityQueueV2.delete();
  }

}