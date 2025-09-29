package BOJ10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> set = new TreeSet<>();

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(str[i]));
        }

        for (Integer integer : set) {
            System.out.print(integer + " ");
        }
    }
}
