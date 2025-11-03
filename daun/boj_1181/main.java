package daun.boj_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine().trim());
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return a.length() - b.length();
                return a.compareTo(b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
    }
}
