package algorithm.Sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MIHE on 11/13/2018.
 */
public class SelectionSortTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getInstance() throws Exception {
    assertEquals(SelectionSort.getInstance() == SelectionSort.getInstance(), true);
  }

  @Test
  public void sort() throws Exception {
    String[] strings = { "Str4", "Str2", "Str5", "Str4", "Str3" };
    String[] results = { "Str5", "Str4", "Str4", "Str3", "Str2" };
    SelectionSort.getInstance().sort(strings);
    assertArrayEquals(strings, results);
  }

}