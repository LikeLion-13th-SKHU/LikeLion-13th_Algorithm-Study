// 수들의 합2

package BOJ2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());

        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = parseInt(st.nextToken());
        }

        while (end <= N) {

            // sum이 M보다 작을 때까지 end가 오른쪽으로 이동하며 탐색
            if (sum < M) {
                if (end < N) {
                    sum += num[end];
                }
                end++;
            }

            else {
                if (sum == M) {
                    count++;
                }

                // sum이 M보다 커지면 start의 값을 빼고 start도 오른쪽으로 이동
                sum -= num[start];
                start++;
            }

        }
        System.out.println(count);


    }
}
