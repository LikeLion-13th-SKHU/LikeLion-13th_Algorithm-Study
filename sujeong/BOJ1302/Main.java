// 베스트셀러

package BOJ1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // key : 책 제목, value : 개수
        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String title = br.readLine();

            // map에 책이 이미 존재하면 +1, 없으면 초기화
            map.put(title, map.getOrDefault(title, 0) + 1);

        }

        int count = 0;

        // 최댓값 찾기
        for (int n : map.values()) {
            if (n > count) {
                count = n;
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == count) {    // 책 개수가 count와 같을 때
                list.add(entry.getKey());       // list에 추가
            }
        }
        Collections.sort(list); // list를 사전 순으로 정렬

        System.out.println(list.get(0));
    }

}
