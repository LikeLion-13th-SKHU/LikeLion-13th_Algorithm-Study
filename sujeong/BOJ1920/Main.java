package BOJ1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        String[] str_N = br.readLine().split(" ");

        // str_N에 있는 숫자들을 Hashmap에 저장
        for (int i = 0; i < N; i++) {
            String str_hash = str_N[i];
            map.put(Integer.parseInt(str_hash), 1);   // 임의의 숫자 1(값)
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String[] str_M = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(str_M[i]);

            if (map.containsKey(num)) {     // containsKey(): key와 일치하는 데이터가 있는지 여부를 반환하는 메서드
                sb.append(1).append("\n");  // append(): 문자열을 추가하는 메서드
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb.toString());  // toString() : string으로 변환
    }
}