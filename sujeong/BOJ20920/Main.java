// 영단어 암기는 괴로워

package BOJ20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 단어 길이

        // key : 단어, value : 빈도 수
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.length() >= M) { // 단어의 길이가 M 이상
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        // map의 key(단어)들을 저장할 List
        List<String> words = new ArrayList<>(map.keySet());

        // 람다식을 사용한 정렬
        Collections.sort(words, (w1, w2) -> {

            // 빈도수 비교
            int count1 = map.get(w1);
            int count2 = map.get(w2);
            if (count1 != count2) {
                return count2 - count1;
            }

            // 단어 길이 비교
            if (w1.length() != w2.length()) {
                return w2.length() - w1.length();
            }

            // 사전순 비교
            return w1.compareTo(w2);

        });

        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.println(sb.toString());

    }
}
