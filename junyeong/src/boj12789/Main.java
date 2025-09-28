package boj12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        int next = 1;

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (cur == next) {
                next++;
            } else {
                stack.push(cur);
            }

            while (!stack.isEmpty() && stack.peek() == next) {
                stack.pop();
                next++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
