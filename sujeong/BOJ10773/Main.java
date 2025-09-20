package BOJ10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> st = new Stack<>();

        System.out.println("줄 개수");
        int K = Integer.parseInt(br.readLine());
        int count = 0;  // 스택 총 합계

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());  // 정수 입력

            if (num != 0) {     // 정수가 0이 아닐 때 count 변수에 저장
                count += num;

            }

            if (num == 0) {
                count -= st.pop();  // 정수가 0이라면 가장 최근 값 지우고 count 변수에서 빼기
            }
            else st.push(num);
        }
        System.out.println(count);
    }
}