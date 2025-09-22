package BOJ2164;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();

        // Deque에 N까지 추가
        for (int i = 0; i < N; i++) {
            q.offer(i+1);
        }

        // 첫 번째 값 삭제, 두 번째 값 삭제 후 뒤에 추가
        while (q.size() > 1) {
            q.poll();
            q.offerLast(q.poll());
        }
        System.out.println(q.poll());



    }
}
