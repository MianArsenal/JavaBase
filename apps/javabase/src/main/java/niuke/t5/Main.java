package niuke.t5;

import javafx.util.Pair;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[][] input = new int[5][5];
        int count = 5;
        while (count-- > 0) {
            String line = scanner.nextLine();
            String[] nums = line.split(" ");
            for (int j = 0; j < nums.length; j++) {
                input[count][j] = Integer.valueOf(nums[j]);
            }
        }
        List<List<Pair<Integer, Integer>>> result = getPairs(input);
        result.forEach(list -> {
            list.forEach(i -> {
                System.out.println(i.getKey() + " " + i.getValue());
            });
            System.out.println("-----------");
        });
    }

    private static List<List<Pair<Integer, Integer>>> getPairs(int[][] input) {
        List<List<Pair<Integer, Integer>>> result = new ArrayList<>();
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 1 && !set.contains(new Pair<>(i, j))) {
                    Set<Pair<Integer, Integer>> temp = new HashSet<>();
                    getPairList(input, i, j, temp);
                    set.addAll(temp);
                    result.add(new ArrayList<>(temp));
                }
            }
        }
        return result;
    }

    private static void getPairList(int[][] input, int i, int j, Set<Pair<Integer, Integer>> temp) {
        Pair<Integer, Integer> e = new Pair<>(i, j);
        if(temp.contains(e)) {
            return;
        }
        temp.add(e);
        if (i + 1 < input.length && input[i + 1][j] == 1) {
            getPairList(input, i + 1, j, temp);
        }
        if (i - 1 >= 0 && input[i - 1][j] == 1) {
            getPairList(input, i - 1, j, temp);
        }
        if (j + 1 < input[i].length && input[i][j + 1] == 1) {
            getPairList(input, i, j + 1, temp);
        }
        if (j - 1 >= 0 && input[i][j - 1] == 1) {
            getPairList(input, i, j - 1, temp);
        }
    }

}
