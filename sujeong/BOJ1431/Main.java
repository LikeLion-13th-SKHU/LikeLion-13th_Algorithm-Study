// 시리얼 번호

package BOJ1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] serial_num = new String[N];
        for (int i = 0; i < N; i++) {
            serial_num[i] = br.readLine();
        }

        // 람다식을 사용한 정렬
        Arrays.sort(serial_num, (a, b) -> {

            int sum_A = 0;
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if (c >= '0' && c <= '9') {
                    sum_A += c - '0';
                }
            }

            int sum_B = 0;
            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                if (c >= '0' && c <= '9') {
                    sum_B += c - '0';
                }
            }

            // 길이 비교
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            // 숫자 합 비교
            if (sum_A != sum_B) {
                return sum_A - sum_B;
            }

            // 사전순 비교
            return a.compareTo(b);
        });

        for (int i = 0; i < N; i++) {
            sb.append(serial_num[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}