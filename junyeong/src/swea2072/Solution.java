package swea2072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int sum = 0;
            int[] arr = new int[10];
            arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int k : arr) {
                if (k % 2 != 0) {
                    sum += k;
                }
            }
            System.out.printf("#%d %d\n",i+1,sum);
        }
        br.close();
    }
}
