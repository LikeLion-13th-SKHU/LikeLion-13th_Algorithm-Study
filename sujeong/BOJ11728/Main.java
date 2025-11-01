// 배열 합치기

package BOJ11728;

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
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        StringTokenizer str_A = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str_A.nextToken());
        }

        int[] B = new int[M];
        StringTokenizer str_B = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(str_B.nextToken());
        }

        int start_A = 0;    // A 배열의 첫 번째 원소
        int start_B = 0;    // B 배열의 첫 번째 원소

        while (start_A < N && start_B < M) {
            if (A[start_A] <= B[start_B]) { // A와 B의 원소를 비교해서 작은 값을 결과에 추가
                sb.append(A[start_A] + " ");
                start_A++;
            } else {
                sb.append(B[start_B] + " ");
                start_B++;
            }
        }

        // 남은 원소를 추가
        while (start_A < N) {
            sb.append(A[start_A] + " ");
            start_A++;
        }

        while (start_B < M) {
            sb.append(B[start_B] + " ");
            start_B++;
        }

        System.out.println(sb.toString().trim());   // .trim() : String의 양 끝 공백을 제거
    }
}
