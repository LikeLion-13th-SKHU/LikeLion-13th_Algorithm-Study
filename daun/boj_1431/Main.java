package daun.boj_1431;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = br.readLine();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return a.length() - b.length();
                int sumA = sumDigits(a);
                int sumB = sumDigits(b);
                if (sumA != sumB)
                    return sumA - sumB;
                return a.compareTo(b);
            }

            private int sumDigits(String s) {
                int sum = 0;
                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c)) sum += c - '0';
                }
                return sum;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s).append("\n");
        System.out.print(sb);
    }
}

