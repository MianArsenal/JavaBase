package niuke.t1;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int min = 0;
        for (int i = 1; i < ints.length / 2; i++) {
            int tempResult = 1;
            int temp = ints[i];
            while (i + temp <= ints.length -1 ) {
                tempResult++;
                if (i + temp == ints.length -1) {
                    break;
                }
                temp += ints[i + temp];
            }
            if (i + temp == ints.length -1) {
                min = min > tempResult || min == 0 ? tempResult : min;
            }
        }
        System.out.println(min == 0 ? -1 : min);
    }

}
