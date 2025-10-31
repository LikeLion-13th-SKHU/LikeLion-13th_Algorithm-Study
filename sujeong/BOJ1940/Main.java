// 주몽

package BOJ1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int start = 0;
        int end = N-1;
        int count = 0;

        while (start < end) {
            int sum = num[start] + num[end];

            if (M == sum) {
                count++;
                start++;
                end--;
            } else if (M > sum) {
                start++;
            } else {
                end--;
            }

        }
        System.out.println(count);

    }
}
