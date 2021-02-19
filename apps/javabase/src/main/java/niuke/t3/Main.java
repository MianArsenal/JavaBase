package niuke.t3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int min = Integer.parseInt(scanner.nextLine());
            String[] inputs = input.split(",");
            if (inputs.length == 0 || inputs.length < min) {
                System.out.println("None");
                return;
            }
            List<String> temp = new ArrayList<>();
            List<List<String>> allGroups = new ArrayList<>();
            HashSet<String> set = new HashSet<>(Arrays.asList(inputs));
            if (set.size() < min) {
                System.out.println("None");
                return;
            }
            compute(allGroups, temp, new ArrayList<>(set), 0);
            List<String> result = new ArrayList<>();
            for (List<String> g : allGroups) {
                if (g.size() >= min) {
                    Collections.sort(g);
                    result.add(buildResult(g));
                }
            }
            Collections.sort(result);
            result.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("None");
        }
    }

    private static String buildResult(List<String> g) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : g) {
            stringBuilder.append(s).append(",");
        }
        return  stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static void compute(List<List<String>> allGroups, List<String> temp, List<String> inputs, int i) {
        if (!temp.isEmpty()) {
            allGroups.add(new ArrayList<>(temp));
        }
        for (int k = i; k < inputs.size(); k++) {
            temp.add(inputs.get(k));
            compute(allGroups, temp, inputs, k + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
