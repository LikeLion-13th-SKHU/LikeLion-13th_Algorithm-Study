import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Cur {
        long number;
        int depth;

        public Cur (long number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Long, Integer> map = new HashMap<>();

        long n = Long.parseLong(br.readLine());

        Queue<Cur> q = new LinkedList<>();

        q.offer(new Cur(n, 0));
        map.put(n, 0);

        while(!q.isEmpty()) {
            Cur front = q.poll();
            long number = front.number;
            int depth = front.depth;

            if (number == 1) {
                System.out.println(depth);
                return;
            }

            // 수를 3으로 나눈 수에 방문한 적이 없고 3의 배수라면
            if (number % 3 == 0 && !map.containsKey(number / 3)) {
                q.offer(new Cur(number/3, depth+1));
                map.put(number/3, depth+1);
            }
            // 수를 2으로 나눈 수에 방문한 적이 없고 2의 배수라면
            if ((number & 1) == 0 && !map.containsKey(number/2)) {
                q.add(new Cur(number/2, depth+1));
                map.put(number/2, depth+1);
            }

            // 수에 1은 뺀 수에 방문한 적이 없다면
            if (!map.containsKey(number-1)) {
                q.offer(new Cur(number-1, depth+1));
                map.put(number-1, depth+1);
            }
        }
    }
}