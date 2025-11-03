// 우당탕탕 영화예매

package BOJ29700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        String[] seat = new String[N];
        for (int i = 0; i < N; i++) {
            seat[i] = br.readLine();    // 문자열로 각 행 입력
        }

        int result = 0; // 최종 결과
        for (int i = 0; i < N; i++) {
            String s = seat[i];

            int count = 0;  // 행이 바뀔 때마다 0으로 초기화

            for (int j = 0; j < M; j++) {

                char num = s.charAt(j);

                if (num == '0') {
                    count++;    // 연속되는 0의 개수 증가
                } else {
                    count = 0;  // 1을 만나면 count 초기화
                }

                if (count >= K) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
