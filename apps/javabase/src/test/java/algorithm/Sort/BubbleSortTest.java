package algorithm.Sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MIHE on 11/19/2018.
 */
public class BubbleSortTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getInstance() throws Exception {
    assertEquals(BubbleSort.getInstance() == BubbleSort.getInstance(), true);
  }

  @Test
  public void sort() throws Exception {
    String[] strings = { "Str4", "Str2", "Str5", "Str4", "Str3" };
    String[] results = { "Str2", "Str3", "Str4", "Str4", "Str5" };
    BubbleSort.getInstance().sort(strings);
    assertArrayEquals(strings, results);
  }

}