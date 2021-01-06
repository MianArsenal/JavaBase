package test;

import java.util.Scanner;

public class StringMove {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        StringBuilder subStringBuilder = new StringBuilder();
        StringBuilder subStringBuilder2 = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if ("*".equals(String.valueOf(string.charAt(i)))) {
                subStringBuilder.append(string.charAt(i));
            } else {
                subStringBuilder2.append(string.charAt(i));
            }
        }
        System.out.println(subStringBuilder.append(subStringBuilder2));
    }
}
