// 암기왕

package BOJ2776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                note1[j] = Integer.parseInt(st1.nextToken());
            }
            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st2.nextToken());

                int left = 0;   // 왼쪽에서부터 시작
                int right = N - 1;  // 오른쪽에서부터 시작
                boolean found = false;

                while (left <= right) {
                    int mid = left + (right - left) / 2;    // 중앙 인덱스 계산

                    if (note1[mid] == num) {
                        found = true;
                        break;
                    } else if (note1[mid] < num) {  // num이 중앙값보다 크면 오른쪽 절반 탐색
                        left = mid + 1;
                    } else {    // num이 중앙값보다 작으면 오른쪽 절반 탐색
                        right = mid - 1;
                    }
                }

                if (found) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }

        System.out.print(sb.toString());
    }
}