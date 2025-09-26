import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "1" : {
                    int x = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    map.put(w,x);
                    break;
                }
                case "2" : {
                    int w = Integer.parseInt(st.nextToken());
                    sb.append(map.get(w)).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}