package daun.boj_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long [] arr = new long[n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int goodCount = 0;

        for (int i = 0; i < n; i++) {
            long target = arr[i]; // 현재 검사할 수
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (left == i){
                    left++;
                    continue;
                }
                if (right == i){
                    right--;
                    continue;
                }

                long sum = arr[left] + arr[right];

                if(sum == target){
                    goodCount++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(goodCount);
    }
}
