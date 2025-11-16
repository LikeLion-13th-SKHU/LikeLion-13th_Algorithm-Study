package swea1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] snail = new int[n][n];
            int r = 0, c = 0;
            String dir = "right";
            for (int num = 1; num <= n * n; num++) {
                snail[r][c] = num;

                if ("right".equals(dir)) {
                    if (c + 1 == n || snail[r][c + 1] != 0) {
                        dir = "down";
                        r++;
                    } else {
                        c++;
                    }
                }
                else if ("down".equals(dir)) {
                    if (r + 1 == n || snail[r + 1][c] != 0) {
                        dir = "left";
                        c--;
                    } else {
                        r++;
                    }
                }
                else if ("left".equals(dir)) {
                    if (c - 1 < 0 || snail[r][c - 1] != 0) {
                        dir = "up";
                        r--;
                    } else {
                        c--;
                    }
                }
                else if ("up".equals(dir)) {
                    if (r - 1 < 0 || snail[r - 1][c] != 0) {
                        dir = "right";
                        c++;
                    } else {
                        r--;
                    }
                }
            }
            System.out.println("#" + (i+1));
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    System.out.print(snail[j][k]+" ");
                }
                System.out.println();

            }
        }
    }
}
