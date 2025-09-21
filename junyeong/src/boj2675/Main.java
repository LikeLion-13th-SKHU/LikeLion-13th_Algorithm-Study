package boj2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            String s = line[1];
            int j = s.length();

            for (int k = 0; k < j; k++) {
                for (int l = 0; l < r; l++) {
                    sb.append(s.charAt(k));
                }
            }
            System.out.println(sb);
            System.out.println();
            System.out.println();
        }
    }
}
