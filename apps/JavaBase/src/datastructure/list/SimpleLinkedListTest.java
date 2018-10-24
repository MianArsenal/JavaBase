package datastructure.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MIHE on 10/19/2018.
 */
public class SimpleLinkedListTest {

  public static void main(String args[]){
    SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();
    simpleLinkedList.add("A");
    simpleLinkedList.add("C");
//    simpleLinkedList.clear();
//    simpleLinkedList.remove("A");
    String[] strArr = {"A", "B"};
//    simpleLinkedList.removeAll(Arrays.asList(strArr));
    simpleLinkedList.addAll(Arrays.asList(strArr));
    printSimpleLinkedList(simpleLinkedList);
    System.out.println(simpleLinkedList.indexOf("A"));
    System.out.println(simpleLinkedList.lastIndexOf("A"));
    System.out.println(simpleLinkedList.isEmpty());
    System.out.println(simpleLinkedList.contains("D"));
    strArr = new String[]{"A", "A", "D"};
    System.out.println(simpleLinkedList.containAll(Arrays.asList(strArr)));
  }

  private static void printSimpleLinkedList(SimpleLinkedList list){
    for(int i = 0; i < list.size(); i++){
      System.out.println(list.get(i));
    }
    System.out.println("Size:" + list.size());
  }
}
