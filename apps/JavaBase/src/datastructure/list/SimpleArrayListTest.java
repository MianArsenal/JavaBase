package datastructure.list;

import java.util.*;

public class SimpleArrayListTest {

  public static void main(String[] args) {
    List<String> samples = new ArrayList<>();
    samples.add("a");
    samples.add("b");
    samples.add("c");
    samples.add("d");
    samples.add("e");
    printCollection(samples);
    for (Iterator itr = samples.iterator(); itr.hasNext(); ) {
      if ("b".equals(itr.next())) {
        itr.remove();
      }
    }
    for (String s :
        samples) {
      System.out.println(s);
    }
    samples.get(0);

    SimpleArrayList<String> simpleArrayList = new SimpleArrayList<>();
    simpleArrayList.add("A");
    simpleArrayList.add("B");
    simpleArrayList.add("C");
    simpleArrayList.add("D");
    simpleArrayList.add("E");
    printCollection(simpleArrayList);
    simpleArrayList.remove("A");
    printCollection(simpleArrayList);
    System.out.println(simpleArrayList.get(0));
    try {
      System.out.println(simpleArrayList.get(4));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    SimpleArrayList<String> simpleArrayListRemoved = new SimpleArrayList<>();
    simpleArrayListRemoved.add("C");
    simpleArrayListRemoved.add("D");
    simpleArrayListRemoved.add("T");
    System.out.println("Contains All:" + simpleArrayList.containsAll(simpleArrayListRemoved));
    simpleArrayList.removeAll(simpleArrayListRemoved);
    printCollection(simpleArrayList);
    System.out.println("Is Empty:" + simpleArrayList.isEmpty());
    System.out.println(simpleArrayList.contains("B"));
    simpleArrayList.clear();
    printCollection(simpleArrayList);
  }

  private static void printCollection(Collection<String> collection) {
    for (String sample : collection) {
      System.out.println(sample);
    }
    System.out.println("Size:" + collection.size());
  }

}
