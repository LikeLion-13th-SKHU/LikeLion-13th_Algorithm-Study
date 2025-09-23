package boj28278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String [] input = br.readLine().split(" ");
            int cmd = Integer.parseInt(input[0]);
            if (cmd == 1) {
                stack.push(Integer.parseInt(input[1]));
            } else if (cmd == 2) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());

                } else {
                    System.out.println(-1);
                }

            } else if (cmd == 3) {
                System.out.println(stack.size());

            } else if (cmd == 4) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }

            } else if (cmd == 5) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }

            }

        }
    }
}
