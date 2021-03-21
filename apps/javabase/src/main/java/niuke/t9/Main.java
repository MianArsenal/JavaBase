package niuke.t9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
题目】实现一个支持+-* /表达式计算的函数，输入是表达式字符串，输出是其计算结果值；输入保证按照格式。【样例】输入1+2*3；输出7。
/
 */

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if('*' == chars[i]) {
                deque.add(String.valueOf(Integer.valueOf(deque.pollLast()) * Integer.valueOf(chars[++i] + "")));
            } else if ('/' == chars[i]) {
                deque.add(String.valueOf(Integer.valueOf(deque.pollLast()) / Integer.valueOf(chars[++i] + "")));
            } else {
                deque.add("" + chars[i]);
            }
        }
        Deque<Integer> result = new ArrayDeque<>();
        while (deque.size() != 0) {
            String current = deque.pollFirst();
            if ("+".equals(current)) {
                String first = deque.pollFirst();
                result.add(result.pollLast() +  Integer.valueOf(first));
//                i++;
            } else if ("-".equals(current)) {
                String first = deque.pollFirst();
                result.add(result.pollLast() - Integer.valueOf(first));
//                i++;
            } else {
                result.add(Integer.valueOf(current));
            }
        }
        System.out.println(result.pop());
    }
}
