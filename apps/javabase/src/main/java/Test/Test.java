package Test;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        if (null == a || a.length() != 32) {
            return;
        }
        int total1 = getTotal(a.substring(0, 8));
        int total2 = getTotal(a.substring(8, 16));
        int total3 = getTotal(a.substring(16, 24));
        int total4 = getTotal(a.substring(24, 32));
        System.out.println(new StringBuilder()
                .append(total1).append(".")
                .append(total2).append(".")
                .append(total3).append(".")
                .append(total4)
        );

    }

    private static int getTotal(String sub1) {
        int total = 0;
        String[] split = sub1.split("");
        for (int i = 0; i < split.length; i++) {
            total += Integer.valueOf(split[i]) * Math.pow(2, 7 - i);
        }
        return total;
    }
}
