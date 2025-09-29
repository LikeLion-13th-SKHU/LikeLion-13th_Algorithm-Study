package BOJ7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] str = {};

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            map.put(str[0], str[1]);

            // enter면 맵에 추가
            if (Objects.equals(map.get(str[0]), "enter")) {
                map.put(str[0], str[1]);
            }
            // leave면 맵에서 제거
            else if (Objects.equals(map.get(str[0]), "leave")) {
                map.remove(str[0]);
            }

        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb.toString());
    }
}