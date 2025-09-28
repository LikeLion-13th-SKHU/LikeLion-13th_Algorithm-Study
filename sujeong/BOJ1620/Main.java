package BOJ1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // key가 이름
        HashMap<String, String> map_name = new HashMap<>();

        // key가 번호
        HashMap<String, String> map_num = new HashMap<>();


        String[] str = br.readLine().split(" ");

        // 도감
        for (int i = 1; i <= Integer.parseInt(str[0]); i++) {
            String pokemon = br.readLine();

            map_name.put(pokemon, Integer.toString(i));
            map_num.put(Integer.toString(i), pokemon);
        }

        // 문제
        for (int i = 0; i < Integer.parseInt(str[1]); i++) {
            String X = br.readLine();

            if (map_name.containsKey(X)) {
                sb.append(map_name.get(X)).append("\n");
            } else if (map_num.containsKey(X)) {
                sb.append(map_num.get(X)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}