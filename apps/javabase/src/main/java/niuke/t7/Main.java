package niuke.t7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (isValidChar(aChar)) {
                result.append(aChar);
            } else if ('-' == aChar && (i + 1 == chars.length || isValidChar(chars[i+1]))) {
                result.append(aChar);
            } else {
                while (!isValidChar(chars[i])) {
                    i++;
                }
                i--;
                result.append(" ");
            }
        }
        String[] strings = result.toString().split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            output.append(strings[i]).append(" ");
        }
        System.out.println(output.toString().substring(0, output.toString().length() - 1));
    }

    private static boolean isValidChar(char a) {
        return ('a' <= a && a <= 'z') || ('A' <= a && a <= 'Z') || ('0' <= a && a <= '9');
    }
}

