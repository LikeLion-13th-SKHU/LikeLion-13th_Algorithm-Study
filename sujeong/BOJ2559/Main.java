// 수열

package BOJ2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());  // 연속적인 날 수

        int[] num = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        int first_sum = 0;
        for (int i = 0; i < K; i++) {
            first_sum += num[i];
        }

        int max = first_sum;    // max를 첫 번째 합으로 초기화
        int sum = 0, count = 0;

        for (int i = 0; i < N; i++) {
            sum += num[i];
            count++;

            if (count >= K) {
                if (max < sum) {
                    max = sum;
                }
                sum = sum - num[i-K+1]; // K의 범위를 벗어나는 원소 값 빼기
            }
        }
        System.out.println(max);
    }
}
