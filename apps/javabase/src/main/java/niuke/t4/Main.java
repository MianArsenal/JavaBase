package niuke.t4;

import java.util.*;
/*
题目：投票计数器
内容：给定一组名字字符串，名字和名字之间逗号隔开，
按照票数高低的顺序输出名字空格票数，相同票数的按照字母升序输出
输入例如：xiaoming,xiaozhang,xiaoli,zhangsan,xiaoming
输出：xiaoming 2,xiaoli 1,xiaozhang 1,zhangsan 1

 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splits = input.split(",");
        Map<String, Integer> result = new HashMap<>();
        for (String split : splits) {
            if (result.containsKey(split)) {
                result.put(split, result.get(split) + 1);
            } else {
                result.put(split, 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = result.entrySet();
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(entries);
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (!o1.getValue().equals(o2.getValue())) {
                    return -(o1.getValue() - o2.getValue());
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i).getKey() + " " + String.valueOf(resultList.get(i).getValue()));
            if (i != resultList.size() - 1) {
                System.out.print(",");
            }
        }
    }

}
