package boj10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] numbers = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        int v = Integer.parseInt(br.readLine());

        int count = 0;

        for (int j = 0; j < n; j++) {
            if (arr[j] == v) {
                count++;
            }
        }

        System.out.println(count);

    }
}
