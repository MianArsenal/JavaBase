package niuke.t2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                stringBuilder.append(aChar);
            } else {
                stringBuilder.append(" ");
            }
        }
        String[] subStrings = stringBuilder.toString().split(" ");
        int max = 0;
        for (String subString : subStrings) {
            int tempMax = getMax(subString);
            max = tempMax > max ? tempMax : max;
        }
        System.out.println(max);
    }

    private static int getMax(String subString) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = subString.toCharArray();
        int max = 0;
        boolean ifExistDuplicated = false;
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            if (i + 1 <= chars.length - 1) {
                int current = Integer.valueOf(chars[i] + "");
                int next = Integer.valueOf(chars[i + 1] + "");
                if (next == current) {
                    ifExistDuplicated = true;
                } else if (next > current) {

                } else {
                    if (ifExistDuplicated && stringBuilder.length() > max && !isAllTheSame(stringBuilder.toString().toCharArray())) {
                        max = stringBuilder.length();
                    }
                    stringBuilder = new StringBuilder();
                    ifExistDuplicated = false;
                }
            } else {
                if (ifExistDuplicated && stringBuilder.length() > max) {
                    max = stringBuilder.length();
                }
            }
        }
        return max;
    }

    private static boolean isAllTheSame(char[] toCharArray) {
        if (toCharArray.length < 2) {
            return false;
        }
        char ch0 = toCharArray[0];
        for (int i = 1; i < toCharArray.length; i++) {
            if (ch0 != toCharArray[i]) {
                return false;
            }
        }
        return true;
    }


}
