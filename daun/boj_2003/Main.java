package daun.boj_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = 0;
        long sum = 0;

        // 슬라이딩 윈도우
        while (true) {
            if (sum >= m) { // 합이 m이상이면 왼쪽 줄임
                sum -= arr[left];
                left++;
            } else if (right == n) {// 오른쪽 끝까지 가면 종료
                break;
            } else { // 합이 m보다 작으면 오른쪽 늘림
                sum += arr[right];
                right++;
            }
            if (sum == m) {
                count++; // 합이 m이면 경우의 수 증가
            }
        }
        System.out.println(count);
    }
}
