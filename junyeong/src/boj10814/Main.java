package boj10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] members = new String[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            members[i][0] = input[0];
            members[i][1] = input[1];
        }

        Arrays.sort(members, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(members[i][0]).append(" ").append(members[i][1]).append("\n");
        }

        System.out.print(sb);
    }
}
