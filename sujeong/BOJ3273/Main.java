// 두 수의 합

package BOJ3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        int start = 0;  // 첫 번째 원소에서 시작
        int end = n - 1;   // 마지막 원소에서 시작
        int count = 0;

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = parseInt(st.nextToken());
        }

        Arrays.sort(num);   // 오름차순 정렬

        int m = parseInt(br.readLine());

        while (start < end) {   // start가 end보다 작을 때 반복
            int sum = num[start] + num[end];

            if (m == sum) {
                count++;
                start++;
                end--;
            } else if (m > sum) {
                start++;
            } else {
                end--;
            }

        }

        System.out.println(count);
    }
}
