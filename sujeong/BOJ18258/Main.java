package BOJ18258;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 수
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");    // split() 사용 공백 기준으로 문자열 자르기. 문자열 str에 저장

            // push X
            if (Objects.equals(str[0], "push")) {
                q.offer(Integer.parseInt(str[1]));
            }

            // pop
            else if (Objects.equals(str[0], "pop")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            }

            // size
            else if (Objects.equals(str[0], "size")) {
                bw.write(q.size() + "\n");
            }

            // empty
            else if (Objects.equals(str[0], "empty")) {
                if (q.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }

            // front
            else if (Objects.equals(str[0], "front")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.peekFirst() + "\n");
                }
            }

            // back
            else if (Objects.equals(str[0], "back")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.peekLast() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
