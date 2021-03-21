package niuke.t8;

import java.util.*;

/**
 * 给定一个以逗号分隔的非空编程语言字符串，按照编程语言出现频次的高低顺序输出，频次出现相同的，按照编程语言字典序输出
 * <p>
 * 示例 1:
 * 输入: "Java,C,Js,Python,Js,C,C,Python,Js,Js"
 * 输出: Js C Python Java
 * 示例 2:
 * 输入: "C,Java,Python,C"
 * 输出: C Java Python
 */

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(",");
        Map<String, Integer> inputMap = new HashMap<>();
        for (String i : inputs) {
            if (inputMap.containsKey(i)) {
                inputMap.put(i, inputMap.get(i) + 1);
            } else {
                inputMap.put(i, 1);
            }
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(inputMap.entrySet());
        entries.sort((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue() - o1.getValue();
            }
            return o1.getKey().compareTo(o2.getKey());
        });
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
