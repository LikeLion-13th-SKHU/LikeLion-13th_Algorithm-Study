import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Boolean> map = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == 1) map.put(i, true);
        }

        int cur = 1;

        for (int j = 0; j < q; j++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "1" : {
                    int i = Integer.parseInt(st.nextToken());
                    if(map.containsKey(i)) map.remove(i);
                    else map.put(i, true);
                    break;
                }
                case "2" : {
                    int x = Integer.parseInt(st.nextToken());
                    cur = (cur + x) % n != 0 ? (cur + x) % n : n;
                    break;
                }
                case "3" : {
                    if(map.isEmpty()) {
                        sb.append(-1).append('\n');
                        break;
                    }

                    if(map.ceilingKey(cur) == null) sb.append(map.firstKey() - cur + n).append('\n');
                    else sb.append(map.ceilingKey(cur) - cur).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}