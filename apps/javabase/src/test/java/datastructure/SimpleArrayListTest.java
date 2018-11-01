package datastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MIHE on 10/26/2018.
 */
public class SimpleArrayListTest {
  private SimpleArrayList<String> simpleArrayList;

  @Before
  public void setUp() throws Exception {
    simpleArrayList = new SimpleArrayList<>();
  }

  @After
  public void tearDown() throws Exception {
    simpleArrayList = null;
  }

  @Test
  public void size() throws Exception {
    assertEquals(simpleArrayList.size(), 0);
    simpleArrayList.add("Str1");
    assertEquals(simpleArrayList.size(), 1);
    simpleArrayList.add("Str2");
    assertEquals(simpleArrayList.size(), 2);
    simpleArrayList.remove("Str2");
    assertEquals(simpleArrayList.size(), 1);
    simpleArrayList.remove("Str0");
    assertEquals(simpleArrayList.size(), 1);
    simpleArrayList.remove("Str2");
    assertEquals(simpleArrayList.size(), 1);
  }

  @Test
  public void isEmpty() throws Exception {
    assertEquals(simpleArrayList.isEmpty(), true);
    simpleArrayList.add("Str1");
    assertEquals(simpleArrayList.isEmpty(), false);
    simpleArrayList.remove("Str1");
    assertEquals(simpleArrayList.isEmpty(), true);
  }

  @Test
  public void contains() throws Exception {
    assertEquals(simpleArrayList.contains("Str1"), false);
    simpleArrayList.add("Str1");
    assertEquals(simpleArrayList.contains("Str1"), true);
    simpleArrayList.remove("Str1");
    assertEquals(simpleArrayList.contains("Str1"), false);
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void get() throws Exception {
    simpleArrayList.add("Str0");
    assertEquals(simpleArrayList.get(0), "Str0");
    simpleArrayList.get(1);
  }

  @Test
  public void iterator() throws Exception {
    assertEquals(simpleArrayList.iterator() instanceof Iterator, true);
  }

  @Test
  public void toArray() throws Exception {
    simpleArrayList.add("Str0");
    assertEquals(simpleArrayList.toArray()[0], "Str0");
  }

  @Test
  public void toArray1() throws Exception {
  }

  @Test
  public void add() throws Exception {
    assertEquals(simpleArrayList.add("Str0"), true);
  }

  @Test
  public void remove() throws Exception {
    assertEquals(simpleArrayList.remove("Str0"), true);
  }

  @Test
  public void containsAll() throws Exception {
    List<String> testList = new ArrayList<>();
    testList.add("Str1");
    testList.add("Str2");
    simpleArrayList.add("Str1");
    simpleArrayList.add("Str2");
    simpleArrayList.add("Str3");
    assertEquals(simpleArrayList.containsAll(testList), true);
    testList.add("Str0");
    assertEquals(simpleArrayList.containsAll(testList), false);
  }

  @Test
  public void addAll() throws Exception {
    List<String> testList = new ArrayList<>();
    testList.add("Str1");
    testList.add("Str2");
    simpleArrayList.addAll(testList);
    assertEquals(simpleArrayList.get(0), "Str1");
    assertEquals(simpleArrayList.get(1), "Str2");
  }

  @Test
  public void removeAll() throws Exception {
    List<String> testList = new ArrayList<>();
    testList.add("Str1");
    testList.add("Str2");
    simpleArrayList.add("Str1");
    simpleArrayList.add("Str2");
    simpleArrayList.add("Str3");
    assertEquals(simpleArrayList.removeAll(testList), true);
    assertEquals(simpleArrayList.get(0), "Str3");
    assertEquals(simpleArrayList.size(), 1);
  }

  @Test
  public void retainAll() throws Exception {
  }

  @Test
  public void clear() throws Exception {
    simpleArrayList.add("Str1");
    simpleArrayList.add("Str2");
    simpleArrayList.add("Str3");
    simpleArrayList.clear();
    assertEquals(simpleArrayList.size(), 0);
  }

}