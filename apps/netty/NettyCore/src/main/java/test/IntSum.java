package test;

import java.util.Arrays;
import java.util.Scanner;

public class IntSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) {
            int num = sc.nextInt();
            data[i] = num;
        }
        Arrays.sort(data);
        int ans = 0;
        int total = 0;
        ans = getAns(data, ans, data.length, 24);
        System.out.println(ans);
    }

    private static int getAns(int[] data, int ans, int length, int max) {
        int total;
        for (int i = length; i >= 0 ; i--) {
            for(int j = 0; j < i; j++) {
                total = data[i] + data[j];
                if (total > max) {
                    total = 0;
                    break;
                } else if (total == max){
                    total = 0;
                    ans++;
                    break;
                } else {
                }
            }
        }
        return ans;
    }

}
