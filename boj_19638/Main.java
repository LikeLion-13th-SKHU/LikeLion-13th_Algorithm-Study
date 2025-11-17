package boj_19638;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);
        int T = Integer.parseInt(input[2]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        for (int i = 0; i < T; i++) {
            int top = pq.peek();

            if (top < H) break;

            pq.poll();
            if (top == 1) {
                pq.add(1);
                continue;
            }

            pq.add(top / 2);
            count++;
        }

        if (pq.peek() < H) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(pq.peek());
        }

    }
}
