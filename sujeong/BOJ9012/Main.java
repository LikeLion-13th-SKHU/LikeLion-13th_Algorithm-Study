package BOJ9012;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 반복 횟수
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            Stack<Character> st = new Stack<>();

            for (int j = 0; j < ps.length(); j++) {
                if (ps.charAt(j) == '(') {
                    st.push('(');
                } else {
                    if (st.isEmpty()) {     // Stack이 비어있는지 확인
                        st.push('(');
                        break;
                    } else {
                        st.pop();
                    }
                }
            }

            if (st.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
