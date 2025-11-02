// 먹을 것인가 먹힐 것인가

package BOJ7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st1.nextToken());
            int M = Integer.parseInt(st1.nextToken());

            // 생명체 A
            int[] A = new int[N];
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st2.nextToken());
            }

            // 생명체 B
            int[] B = new int[M];
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st3.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int count = 0;
            int start_B = 0;

            for (int start_A = 0; start_A < N; start_A++) {

                while (start_B < M && A[start_A] > B[start_B]) {
                    start_B++;
                }
                count += start_B;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb.toString());

    }
}
