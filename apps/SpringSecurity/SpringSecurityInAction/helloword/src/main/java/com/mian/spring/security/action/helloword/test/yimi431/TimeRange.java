package com.mian.spring.security.action.helloword.test.yimi431;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TimeRange {
    public static void main(String[] args) {
        int[] a0 = {1, 4};
        int[] a1 = {2, 5};
        int[] a2 = {8, 9};
        List<int[]> cases = new ArrayList<>();
        cases.add(a0);
        cases.add(a1);
        cases.add(a2);
        List<int[]> result = getCoverTimeRange(cases);
    }

    private static List<int[]> getCoverTimeRange(List<int[]> cases) {
        List<int[]> result = new ArrayList<>();
        cases.sort(Comparator.comparingInt(o -> o[0]));
        int min = cases.get(0)[0];
        int max = cases.get(0)[1];
        int i = 0;
        for (int[] case_: cases) {
            i++;
            if (max >= case_[0]) {
                max = case_[1];
                if (i == cases.size()) {
                    result.add(new int[]{min, max});
                }
            } else {
                result.add(new int[]{min, max});
                min = case_[0];
                max = case_[1];
                if (i == cases.size()) {
                    result.add(new int[]{min, max});
                }
            }
        }
        return result;
    }
}
