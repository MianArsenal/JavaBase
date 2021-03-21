package niuke.t6;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final int DATE_FORMAT_LENGTH = DATE_FORMAT.length();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> result = new HashMap<>();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (result.isEmpty()) {
                result.put(input, 1);
                continue;
            }
            compute(input, result);
        }
        int resultNumber = 0;
        for (Integer value : result.values()) {
            resultNumber += value;
        }
        System.out.println(resultNumber);
    }

    private static void compute(String input, Map<String, Integer> result) {
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getKey().startsWith(input.substring(0, DATE_FORMAT_LENGTH))) {
                if (Integer.parseInt(input.substring(DATE_FORMAT_LENGTH + 1)) > Integer.parseInt(entry.getKey().substring(DATE_FORMAT_LENGTH + 1))) {
                    return;
                } else if (Integer.parseInt(input.substring(DATE_FORMAT_LENGTH + 1)) == Integer.parseInt(entry.getKey().substring(DATE_FORMAT_LENGTH + 1))){
                    entry.setValue(entry.getValue() + 1);
                    return;
                } else if (Integer.parseInt(input.substring(DATE_FORMAT_LENGTH + 1)) < Integer.parseInt(entry.getKey().substring(DATE_FORMAT_LENGTH + 1))){
                    result.remove(entry.getKey());
                    result.put(input, 1);
                    return;
                }
            }
        }
        result.put(input, 1);
    }

}
