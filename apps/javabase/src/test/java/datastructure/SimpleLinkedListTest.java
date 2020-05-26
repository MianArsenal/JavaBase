package datastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MIHE on 10/26/2018.
 */
public class SimpleLinkedListTest {
  private SimpleLinkedList<String> simpleLinkedList;

  @Before
  public void setUp() throws Exception {
    simpleLinkedList = new SimpleLinkedList<>();
  }

  @After
  public void tearDown() throws Exception {
    simpleLinkedList = null;
  }

  @Test
  public void size() throws Exception {
    assertEquals(simpleLinkedList.size(), 0);
  }

  @Test
  public void isEmpty() throws Exception {
    assertEquals(simpleLinkedList.isEmpty(), true);
  }

  @Test
  public void add() throws Exception {
    assertEquals(simpleLinkedList.add("Str1"), true);
    assertEquals(simpleLinkedList.isEmpty(), false);
    assertEquals(simpleLinkedList.size(), 1);
  }

  @Test
  public void addAll() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str3");
    assertEquals(simpleLinkedList.addAll(addList), true);
    assertEquals(simpleLinkedList.size(), 3);
  }

  @Test
  public void remove() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str3");
    simpleLinkedList.addAll(addList);
    assertEquals(simpleLinkedList.remove("Str2"), true);
    assertEquals(simpleLinkedList.get(1), "Str3");
    assertEquals(simpleLinkedList.size(), 2);
  }

  @Test
  public void removeAll() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str3");
    simpleLinkedList.addAll(addList);
    List<String> removeList = new ArrayList<>();
    removeList.add("Str1");
    removeList.add("Str2");
    assertEquals(simpleLinkedList.removeAll(removeList), true);
    assertEquals(simpleLinkedList.size(), 1);
  }

  @Test
  public void get() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str3");
    simpleLinkedList.addAll(addList);
    assertEquals(simpleLinkedList.get(1), "Str2");
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void clear() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str3");
    simpleLinkedList.addAll(addList);
    simpleLinkedList.clear();
    assertEquals(simpleLinkedList.size(), 0);
    simpleLinkedList.get(0);
  }

  @Test
  public void contains() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str3");
    simpleLinkedList.addAll(addList);
    assertEquals(simpleLinkedList.contains("Str1"), true);
    assertEquals(simpleLinkedList.contains("Str0"), false);
  }

  @Test
  public void containAll() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str3");
    simpleLinkedList.addAll(addList);
    List<String> testList = new ArrayList<>();
    testList.add("Str1");
    testList.add("Str2");
    testList.add("Str3");
    assertEquals(addList.containsAll(testList), true);
    testList.add("Str0");
    assertEquals(addList.containsAll(testList), false);
  }

  @Test
  public void indexOf() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str3");
    simpleLinkedList.addAll(addList);
    assertEquals(simpleLinkedList.indexOf("Str1"), 0);
    assertEquals(simpleLinkedList.indexOf("Str0"), -1);
  }

  @Test
  public void lastIndexOf() throws Exception {
    List<String> addList = new ArrayList<>();
    addList.add("Str1");
    addList.add("Str2");
    addList.add("Str1");
    simpleLinkedList.addAll(addList);
    assertEquals(simpleLinkedList.lastIndexOf("Str2"), 1);
    assertEquals(simpleLinkedList.lastIndexOf("Str1"), 2);
  }

}