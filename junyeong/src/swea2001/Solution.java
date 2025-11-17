package swea2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                int[] inputNum = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int k = 0; k < n; k++) {
                    arr[j][k] = inputNum[k];
                }
            }

            int max = 0;
            for (int r = 0; r <= n - m; r++) {
                for (int c = 0; c <= n - m; c++) {
                    int sum = 0;

                    for (int x = r; x < r + m; x++) {
                        for (int y = c; y < c + m; y++) {
                            sum += arr[x][y];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }
            System.out.printf("#%d %d\n", i + 1, max);
        }
    }
}
