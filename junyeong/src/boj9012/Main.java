package boj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            String s = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            for(char c: s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

                if(!stack.isEmpty()){
                    isValid = false;
                }

                System.out.println(isValid ? "YES" : "NO");



        }


    }
}
