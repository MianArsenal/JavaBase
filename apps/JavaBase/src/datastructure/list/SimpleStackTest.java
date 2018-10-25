package datastructure.list;

/**
 * Created by MIHE on 10/25/2018.
 */
public class SimpleStackTest {

  public static void main(String[] args){
    SimpleStack<String> simpleStack = new SimpleStack<>();
    printSimpleStack(simpleStack);
    System.out.println(simpleStack.pop());
    simpleStack.push("A");
    simpleStack.push("B");
    printSimpleStack(simpleStack);
    System.out.println(simpleStack.pop());
    printSimpleStack(simpleStack);
    System.out.println(simpleStack.pop());
    printSimpleStack(simpleStack);
  }

  private static void printSimpleStack(SimpleStack<String> simpleStack) {
    System.out.println("----------");
    System.out.println(simpleStack.isEmpty());
    System.out.println(simpleStack.size());
    System.out.println(simpleStack.peek());
    System.out.println("----------");
  }

}
