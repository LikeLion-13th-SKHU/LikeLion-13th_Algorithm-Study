package boj7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String action = log[1];

            if (action.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        List<String> result = new ArrayList<>(set);
        result.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : result) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
