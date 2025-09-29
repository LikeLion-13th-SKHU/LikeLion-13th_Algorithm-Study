package boj11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        long maxKey = Long.MAX_VALUE;
        int maxValue = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue ||
                    (entry.getValue() == maxValue && entry.getKey() < maxKey)) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        System.out.println(maxKey);
    }
}
