// 9시 40분? ~ (50분)

package BOJ11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long, Integer> map = new HashMap<>();   // 숫자, 횟수
        int N = Integer.parseInt(br.readLine());

        // 가장 많이 나온 숫자
        long result = 0;

        // 가장 많이 나온 횟수
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);

            int count = map.get(num);

            // 최빈값 구하기
            if (count > maxCount) { // count가 maxCount 보다 클 때
                maxCount = count;
                result = num;
            } else if (count == maxCount && num < result) { // count가 maxCount 보다 작거나 같을 때
                result = num;
            }
        }

        System.out.println(result);
    }
}