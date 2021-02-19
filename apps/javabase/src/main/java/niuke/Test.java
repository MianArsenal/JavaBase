package niuke;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("4");
        test.add("2");
        test.add("3");
        Collections.sort(test);
        test.stream().forEach(System.out::println);
    }
}
