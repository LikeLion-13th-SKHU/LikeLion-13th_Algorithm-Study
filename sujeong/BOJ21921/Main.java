// 블로그

package BOJ21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, count = 0, max = 0, freq = 0;
        for (int i = 0; i < N; i++) {
            sum += num[i];
            count++;

            if (count >= X) {
                if (sum > max) {
                    max = sum;
                    freq = 0;
                }
                if (max == sum) {
                    freq++;
                }
                sum = sum - num[i-X+1]; // X의 범위를 벗어나는 원소 값 빼기

            }

        }
        sb.append(max).append('\n').append(freq);

        if (max != 0) { // 최대 방문자 수가 0이 아니면 최대방문자 수, 기간 출력
            System.out.println(sb.toString());
        } else {
            System.out.println("SAD");  // 최대 방문자 수가 0이면 SAD 출력
        }

    }
}
