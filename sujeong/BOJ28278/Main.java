//정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//        명령은 총 다섯 가지이다.
//
//        1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
//        2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
//        3: 스택에 들어있는 정수의 개수를 출력한다.
//        4: 스택이 비어있으면 1, 아니면 0을 출력한다.
//        5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.

package BOJ28278;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> st = new Stack<>();   // 스택 선언

        System.out.println("N: ");
        int N = Integer.parseInt(br.readLine());  // 명령의 수

        System.out.println("명령어: ");
        while (N-- > 0) {
            String[] str = br.readLine().split(" ");    // split() 사용 공백 기준으로 문자열 자르기. 문자열 str에 저장
            int num = Integer.parseInt(str[0]);

            switch (num) {
                case 1:
                    String X = str[1];  // 정수 X에 해당하는 str[1] 저장
                    st.push(X);         // 정수 X를 스택에 넣음
                    break;
                case 2:
                    if (!st.isEmpty()) {
                        System.out.println(st.pop());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case 3:
                    System.out.println(st.size());
                    break;
                case 4:
                    if (st.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case 5:
                    if (!st.isEmpty()) {
                        System.out.println(st.peek());
                    } else {
                        System.out.println("-1");
                    }
                    break;
            }
        }

    }
}
