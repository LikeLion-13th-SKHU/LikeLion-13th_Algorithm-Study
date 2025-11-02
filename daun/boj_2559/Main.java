package daun.boj_2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temp = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 구간의 합 계산
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += temp[i];
        }

        int max = sum; // 첫 구간의 합을 최대값으로 초기화

        // 슬라이딩 윈도우 이동
        for (int i = k; i < n; i++) {
            sum = sum - temp[i - k] + temp[i]; // 이전 구간의 왼쪽 값 빼고, 새 값 더하기
            max = Math.max(max, sum); // max값 갱신
        }

        System.out.println(max);
    }
}
