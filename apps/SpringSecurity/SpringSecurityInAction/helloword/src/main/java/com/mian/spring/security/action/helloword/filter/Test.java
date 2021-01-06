package com.mian.spring.security.action.helloword.filter;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        for (int i : getMaxSubArray(array)) {
            System.out.println(i);
        }
    }

    private static int[] getMaxSubArray(int[] array) {
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int total = array[0];
        for (int i = 0; i < array.length; i++) {
            int tempTotal = array[i];
            for (int j = i + 1; j < array.length; j ++) {
                tempTotal += array[j];
                if (tempTotal > total) {
                    total = tempTotal;
                    maxStartIndex = i;
                    maxEndIndex = j;
                }
            }
        }
        return Arrays.copyOfRange(array, maxStartIndex, maxEndIndex + 1);
    }
}
